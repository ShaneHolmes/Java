package model.se;
import java.io.*;
import net.user.*;
import java.net.*;
import javax.swing.ImageIcon;
public class Server 
{
	ServerSocket ss=null;
	Socket s=null;
	
	FileReader fr1,fr2;
	BufferedReader buf1,buf2;
	User master=null;
	
	public static void main(String [] args)
	{
		new Server();
	}
	
	public Server()
	{
		
		try 
		{
			ss=new ServerSocket(8899);
			while(true)
			{
				s=ss.accept();
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				VerifyMessage vm=(VerifyMessage)ois.readObject();
				if(this.handleVM(vm))
				{
					vm.setResult("succeed");
					oos.writeObject(vm);
					oos.writeObject(this.master);
					
					TouchClientThread tct=new TouchClientThread(s);
					tct.start();
					TouchClientThreadManage.addTouchClientThread(this.master.getIdcard(), tct);
				}
				else
				{
					oos.writeObject(vm);
					s.close();
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public boolean handleVM(VerifyMessage vm)
	{
		String str=null;
		ContactMen cm;
		
		try 
		{
			String filepath="Users/"+vm.getUid()+vm.getPassword();
			File file=new File(filepath);
			if(file.exists())
			{
				master=new User();
				
				String s1=filepath+"/message.txt";
				fr1=new FileReader(s1);
				buf1=new BufferedReader(fr1);
				String []string1=new String[5];
				
				//构建验证者信息
				string1=buf1.readLine().split("&");
				master.setIdcard(string1[0]);
				master.setNickname(string1[1]);
				master.setSignature(string1[3]);
				master.setIcon(new ImageIcon(string1[4]));

				//添加验证者好友
				String s2=filepath+"/friends.txt";
				String []string2=new String[6];
				fr2=new FileReader(s2);
				buf2=new BufferedReader(fr2);
				while((str=buf2.readLine())!=null)
				{
					string2=str.split("&");
					cm=new ContactMen();
					cm.setType(string2[0]);
					cm.setIdcard(string2[1]);
					cm.setNickname(string2[2]);
					if(string2[3].equals(""))
					{
						cm.setMarkname(null);
					}
					else
					{
						cm.setMarkname(string2[3]);
					}
					cm.setSignature(string2[4]);
					cm.setIcon(new ImageIcon(string2[5]));
					master.addContactMen(cm);
				}
				
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}
