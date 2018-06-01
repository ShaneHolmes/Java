package model.se;
import java.util.*;
public class TouchClientThreadManage 
{
	public static HashMap<String, TouchClientThread> hm=new HashMap<String, TouchClientThread>();
	
	public static void addTouchClientThread(String uid, TouchClientThread tct)
	{
		hm.put(uid, tct);
	}
	
	public static TouchClientThread getTouchClientThread(String uid)
	{
		return hm.get(uid);
	}

	public static void deleteTouchClientThread(String uid)
	{
		hm.remove(uid);
	}
}
