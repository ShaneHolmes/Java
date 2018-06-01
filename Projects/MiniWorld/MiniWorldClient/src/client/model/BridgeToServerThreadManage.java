package client.model;
import java.util.*;
public class BridgeToServerThreadManage 
{
	private static HashMap<String, BridgeToServerThread> hm=new HashMap<String, BridgeToServerThread>();

	public static void addBridgeToServerThread(String uid, BridgeToServerThread btt)
	{
		hm.put(uid, btt);
	}
	
	public static BridgeToServerThread getBridgeToServerThread(String uid)
	{
		return hm.get(uid);
	}
	
	public static void deleteBridgeToServerThread(String uid)
	{
		hm.remove(uid);
	}
}
