/*
 *@author ShaneHolmes
 *date:2018.5.7
 *@Right Copy.All right reserved.
**/
package zyd.hw1.crs;
public class Student {
	private String sid=null;
	private String name=null;
	private String major=null;
	
	public Student(String sid){
		this.sid=sid;
		this.name = "小明";
		this.major = "软件工程";
	}
	
	public Student(String sid, String name){
		this.sid=sid;
		this.name=name;
		this.major="软件工程";
	}
	
	public Student(String sid, String name, String major){
		this.sid=sid;
		this.name=name;
		this.major=major;
	}
	
	public String getSid(){
		return this.sid;
	}
}
