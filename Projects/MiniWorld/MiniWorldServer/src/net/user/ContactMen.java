package net.user;
import javax.swing.ImageIcon;
public class ContactMen implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	String type;
	String idcard;
	String nickname;
	String signature;
	ImageIcon icon;
	String markname=null;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public String getMarkname() {
		return markname;
	}
	public void setMarkname(String markname) {
		this.markname = markname;
	}
	
	
	
}
