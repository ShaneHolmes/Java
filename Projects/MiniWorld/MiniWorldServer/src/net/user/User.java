package net.user;
import javax.swing.*;
import java.util.*;
public class User implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	String idcard;
	String nickname;
	String signature;
	ImageIcon icon;
	
	ContactMen cm1,cm2,cm3,cm4;
	
	public Vector<ContactMen> myfriend=new Vector<ContactMen>();
	
	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Vector<ContactMen> getMyfriend() {
		return myfriend;
	}

	public void setMyfriend(Vector<ContactMen> myfriend) {
		this.myfriend = myfriend;
	}
	
	public void addContactMen(ContactMen cm)
	{
		this.myfriend.add(cm);
	}
}
