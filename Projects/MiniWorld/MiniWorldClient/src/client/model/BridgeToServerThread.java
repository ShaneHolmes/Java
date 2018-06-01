package client.model;
import java.net.*;
import net.user.*;
import java.io.*;
import client.jiemian.*;
public class BridgeToServerThread extends Thread
{
	private Socket s;
	
	public BridgeToServerThread(Socket s)
	{
		this.s=s;
	}
	
	public Socket getS() {
		return s;
	}

	public void run()
	{
		while(!s.isClosed())
		{
			try 
			{
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				ChatMessage cm=(ChatMessage)ois.readObject();
				ChatWin cw=ChatWinManage.getChatWin(cm.getReceiver()+cm.getSender());
				cw.showChatMessageToJta1(cm);
			} 
			catch (Exception e) 
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
