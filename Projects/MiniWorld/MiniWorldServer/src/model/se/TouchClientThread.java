//和客户端保持连接的线程
package model.se;
import java.net.*;

import net.user.ChatMessage;

import java.io.*;
public class TouchClientThread extends Thread
{
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public TouchClientThread(Socket s)
	{
		this.s=s;
	}
	
	public void run()
	{
		while(!s.isClosed())
		{
			try
			{
				
				Thread.sleep(500);
				
				ois=new ObjectInputStream(s.getInputStream());
				ChatMessage cm=(ChatMessage)ois.readObject();
				oos=new ObjectOutputStream(TouchClientThreadManage.getTouchClientThread(cm.getReceiver()).s.getOutputStream());
				oos.writeObject(cm);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				try {
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

}
