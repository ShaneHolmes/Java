/*
 *@author ShaneHolmes
 *date:2018.5.7
 *@Right Copy.All right reserved.
**/
package zyd.hw3.pimcollection;
import java.util.*;
import java.io.*;
import java.lang.String;
interface Date {
	void setDate(String date);
}
abstract class PIMEntity {
    public String priority;
    PIMEntity() {
        priority = "normal";
    }
    PIMEntity(String priority) {
        this.priority =  priority;
    }
    public String getPriority() {
        return this.priority;
    }
    public void setPriority(String priority) {
		this.priority =  priority;
    }
}
class PIMTodo extends PIMEntity implements Date {
	private String date;
	private String todoText;
	static Collection<String> pimTodo=new ArrayList<String>();
	public PIMTodo() {
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setTodoText(String todo) {
		this.todoText = todo;
	}
	public void addToPIMTodo(){
		todoText="Item " + PIMCollection.itemno + ": TODO " + todoText + " DATE "+date+" PRIORITY " + priority + ".";
		pimTodo.add(todoText);
	}
	public Collection getTodo() {
		return pimTodo;
	}
}
class PIMNote extends PIMEntity{
	private String note;
	private String priority;
	static Collection<String> pimNote=new ArrayList<String>();
	public void setNote(String note) {
		this.note = note;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public void addToPIMNote(){
		note="Item " + PIMCollection.itemno + ": NOTE " + note + " PRIORITY " + priority + ".";
		pimNote.add(note);
	}
	public Collection getNote() {
		return pimNote;
	}
}
class PIMAppointment extends PIMEntity implements Date {
	private String date;
	private String description;
	static Collection<String> pimAppointment=new ArrayList<String>();
	public void setDate(String date) {
		this.date = date;
	}
	public void setDescription(String des) {
		this.description = des;
	}
	public void addToPIMAppointment() {
		String appointment="Item " + PIMCollection.itemno + ": APPOINTMENT " + description + " PRIORITY " + priority+" DATE "+date + " "+ ".";
		pimAppointment.add(appointment);
	}
	public Collection getAppointment(){
		return pimAppointment;
	}
}
class PIMContact extends PIMEntity {
	private String firstname, lastname, email;
	static Collection<String> pimAppointment=new ArrayList<String>();
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void addToPIMContact() {
		String contact="Item " + PIMCollection.itemno + ": CONTACT " + " PRIORITY "+priority + " FIRSTNAME " + firstname + " LASTNAME " + lastname + " EMAIL " + email
				+ ".";
		pimAppointment.add(contact);
	}
	public Collection getContact(){
		return pimAppointment;
	}
}
public class PIMCollection {
	static Collection<String> list=new ArrayList<String>();
	static int itemno=0;
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to PIM.");
		Scanner in = new Scanner(System.in);
		OUT:
		while (true) {
			PIMTodo todo = new PIMTodo();
			PIMNote note = new PIMNote();
			PIMContact contact = new PIMContact();
			PIMAppointment appointment = new PIMAppointment();
			System.out.println("---Enter a command (supported commands are List Create Save Load Quit)---");
			String input = in.next();
			switch (input) {
			case "List":
				/*
				 *如果不空就加到list中
				 */
				if(!todo.getTodo().isEmpty()){
					//System.out.println("as");debug
					list.addAll(todo.getTodo());
					if(!note.getNote().isEmpty()){
						list.addAll(note.getNote());
						if(!contact.getContact().isEmpty()){
							list.addAll(contact.getContact());
							if(!appointment.getAppointment().isEmpty()){
								list.addAll(appointment.getAppointment());
							}
						}
					}
				}
				//对list中的重复元素剔除并保持顺序（输入的顺序）
				Set set  =   new  HashSet();
				List newList  =   new  ArrayList();
				for  (Iterator iter  =  list.iterator(); iter.hasNext();)   {
					Object element  =  iter.next();
					if  (set.add(element))
						newList.add(element);
				}
				list.clear();
				list.addAll(newList);

				System.out.println("There are " + list.size() + " items.");
				String s;
				//将list转为string，以空格代替首尾的【，】，以换行符代替隔开list中的逗号，最后trim首尾去除空格。
				s=list.toString().replace('[',' ').replace(']',' ').replace(',','\n').trim();
				System.out.println(' '+s);
				break;
			case "Create":
				System.out.println("Enter an item type(todo,note,contact,appointment)");
				input = in.next();
				switch (input) {
				case "todo":
					System.out.println("Enter date for todo item:");
					BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
					input = buff.readLine();
					todo.setDate(input);
					System.out.println("Enter todo text:");
					BufferedReader buff1 = new BufferedReader(new InputStreamReader(System.in));
					input = buff1.readLine();
					todo.setTodoText(input);
					System.out.println("Enter todo priority:");
					BufferedReader buff2 = new BufferedReader(new InputStreamReader(System.in));
					input = buff2.readLine();
					todo.setPriority(input);
					itemno++;
					todo.addToPIMTodo();
					break;
				case "note":
					System.out.println("Enter note text:");
					BufferedReader buff3 = new BufferedReader(new InputStreamReader(System.in));
					input = buff3.readLine();
					note.setNote(input);
					System.out.println("Enter note priority:");
					input = in.next();
					note.setPriority(input);
					itemno++;
					note.addToPIMNote();
					break;
				case "contact":
					System.out.println("Enter firstname for contact item:");
					BufferedReader buff4 = new BufferedReader(new InputStreamReader(System.in));
					input = buff4.readLine();
					contact.setFirstname(input);
					System.out.println("Enter lastname for contact item:");
					BufferedReader buff5 = new BufferedReader(new InputStreamReader(System.in));
					input = buff5.readLine();
					contact.setLastname(input);
					System.out.println("Enter email for contact item:");
					BufferedReader buff6 = new BufferedReader(new InputStreamReader(System.in));
					input = buff6.readLine();
					contact.setEmail(input);
					System.out.println("Enter contact priority:");
					input = in.next();
					contact.setPriority(input);
					itemno++;
					contact.addToPIMContact();
					break;
				case "appointment":
					System.out.println("Enter date for appointment item:");
					BufferedReader buff7 = new BufferedReader(new InputStreamReader(System.in));
					input = buff7.readLine();
					appointment.setDate(input);
					System.out.println("Enter appointment description:");
					BufferedReader buff8 = new BufferedReader(new InputStreamReader(System.in));
					input = buff8.readLine();
					appointment.setDescription(input);
					System.out.println("Enter appointment priority:");
					input = in.next();
					appointment.setPriority(input);
					itemno++;
					appointment.addToPIMAppointment();
					break;
				default:
					System.out.println("the item type is not exist");
					break;
				}
				break;
			case "Save":
				System.out.println("Item have been saved.");
				break;
			case "Quit":
				in.close();
				break OUT;
			default:
				System.out.println("the command is not exist");
				break;
			}
		}
	}
}
