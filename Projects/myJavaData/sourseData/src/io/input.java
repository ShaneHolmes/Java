package io;
import java.io.*;
public class input {
	public static void main(String[] args){
//		char c=' ';
//		System.out.print("please input a char:\n");
//		try{
//			c=(char)System.in.read();//输入一个字符
//		}catch(IOException e){
//			
//		}
//		System.out.println("You have enter a char:"+c);
//		
//		
//		
//		String s=" ";
//		System.out.print("please input a line:\n");
//		try{
//			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
//			s=in.readLine();//输入一行数据,包括空格
//		}catch(IOException e){
//			
//		}
//		System.out.println("You have enter a line:"+s);
		
		
		
		String s1=" ";
		int i=-1;
		System.out.print("please input a int:\n");
		try{
			BufferedReader in1=new BufferedReader(new InputStreamReader(System.in));
			s1=in1.readLine();//输入整形数字的字符串形式
			i=Integer.parseInt(s1);//转成数字
		}catch(IOException e){
			
		}
		System.out.println("You have enter a int:"+i);
	}

}
