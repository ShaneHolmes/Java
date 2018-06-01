//客户端连接服务器的后台
package client.model;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import net.user.User;
import net.user.VerifyMessage;
public class BridgeToServer 
{
	public Socket s;
	
	public User sendVMToServer(VerifyMessage vm)
	{
		User user=null;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		try {
			s = new Socket("10.173.196.184", 8899);
			oos=new ObjectOutputStream(s.getOutputStream());
			ois=new ObjectInputStream(s.getInputStream());
			oos.writeObject(vm);
			
			vm=(VerifyMessage)ois.readObject();
			
			if(vm.getResult().equals("succeed"))
			{
				user=(User)ois.readObject();
				BridgeToServerThread btt=new BridgeToServerThread(s);
				btt.start();
				BridgeToServerThreadManage.addBridgeToServerThread(user.getIdcard(), btt);
			}
				
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return user;
	}

}
