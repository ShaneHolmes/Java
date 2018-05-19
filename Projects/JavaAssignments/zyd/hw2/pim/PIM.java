/*
 *@author ShaneHolmes
 *date:2018.5.7
 *@Right Copy.All right reserved.
**/
package zyd.hw2.pim;
import java.util.Scanner;
import java.io.*;

interface Date {
	void setDate(String d);
}

abstract class PIMEntity {
    String Priority; // every kind of item has a priority
   // default constructor sets priority to "normal"
    PIMEntity() {
        Priority = "normal";
    }
   // priority can be established via this constructor.
    PIMEntity(String priority) {
        Priority =  priority;
    }
   // accessor method for getting the priority string
    public String getPriority() {
        return Priority;
    }
    // method that changes the priority string
    public void setPriority(String p) {
        Priority = p;
    }
   // Each PIMEntity needs to be able to set all state information
    // (fields) from a single text string.
    abstract public void fromString(String s);
   // This is actually already defined by the super class
    // Object, but redefined here as abstract to make sure
    // that derived classes actually implement it
    abstract public String toString();
}

class PIMTodo extends PIMEntity implements Date {

	String date, todoText;

	public PIMTodo() {

	}

	public void setDate(String d) {

		date = d;

	}

	void setTodoText(String todo) {

		todoText = todo;

	}

	public void fromString(String s) {

	}

	public String toString() {

		return ("Item " + PIM.itemno + ": TODO " + Priority + " " + date + " " + todoText + ".");

	}

}

class PIMNote extends PIMEntity {

	String noteText;

	void setNoteText(String n) {

		noteText = n;

	}

	public void fromString(String s) {

		// TODO Auto-generated method stub

	}

	public String toString() {

		// TODO Auto-generated method stub

		return ("Item " + PIM.itemno + ": NOTE " + Priority + " " + noteText + ".");

	}

}

class PIMAppointment extends PIMEntity implements Date {

	String date, description;

	public void setDate(String d) {

		date = d;

	}

	void setDescription(String des) {

		description = des;

	}

	public void fromString(String s) {

		// TODO Auto-generated method stub

	}

	public String toString() {

		// TODO Auto-generated method stub

		return ("Item " + PIM.itemno + ": APPOINTMENT " + Priority + " " + date + " " + description + ".");

	}

}

class PIMContact extends PIMEntity {

	String firstname, lastname, email;

	void setFirstname(String f) {

		firstname = f;

	}

	void setLastname(String l) {

		lastname = l;

	}

	void setEmail(String e) {

		email = e;

	}

	public void fromString(String s) {

		// TODO Auto-generated method stub

	}

	public String toString() {

		// TODO Auto-generated method stub

		return ("Item " + PIM.itemno + ": CONTACT " + Priority + " " + firstname + " " + lastname + " " + email
				+ ".");

	}

}

public class PIM {

	static int itemno = 0;

	static String[] List = new String[100];

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		System.out.println("Welcome to PIM.");

		Scanner in = new Scanner(System.in);

		OUT:

		while (true) {

			System.out.println("---Enter a command (supported commands are List Create Save Load Quit)---");

			String input = in.next();

			switch (input) {

			case "List":

				System.out.println("There are " + itemno + " items.");

				for (int i = 1; i <= itemno; i++) {

					if (itemno == 0)
						break;

					System.out.println(List[i]);

				}

				break;

			case "Create":

				System.out.println("Enter an item type(todo,note,contact,appointment)");

				input = in.next();

				switch (input) {

				case "todo":

					PIMTodo todo = new PIMTodo();

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

					// start with 1(zero is not used)

					itemno++;

					String r = todo.toString();

					List[itemno] = r;

					break;

				case "note":

					PIMNote note = new PIMNote();

					System.out.println("Enter note text:");

					BufferedReader buff3 = new BufferedReader(new InputStreamReader(System.in));

					input = buff3.readLine();

					note.setNoteText(input);

					System.out.println("Enter note priority:");

					input = in.next();

					note.setPriority(input);

					itemno++;

					String r1 = note.toString();

					List[itemno] = r1;

					break;

				case "contact":

					PIMContact contact = new PIMContact();

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

					String r2 = contact.toString();

					List[itemno] = r2;

					break;

				case "appointment":

					PIMAppointment appointment = new PIMAppointment();

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

					String r3 = appointment.toString();

					List[itemno] = r3;

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

