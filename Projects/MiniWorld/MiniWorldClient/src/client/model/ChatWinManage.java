package client.model;
import java.util.*;
import client.jiemian.*;
public class ChatWinManage 
{
	private static HashMap<String, ChatWin> hm=new HashMap<String, ChatWin>();
	
	public static void addChat(String mf, ChatWin cw)
	{
		hm.put(mf, cw);
	}
	
	public static ChatWin getChatWin(String mf)
	{
		return hm.get(mf);
	}

}
