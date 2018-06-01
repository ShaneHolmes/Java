package net.user;
public class VerifyMessage implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	String uid;
	String password;
	String result;

	public VerifyMessage(String uid,String password)
	{
		this.uid=uid;
		this.password=password;
		this.result="fail";
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
