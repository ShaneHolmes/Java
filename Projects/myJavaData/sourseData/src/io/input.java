package io;
import java.io.*;
public class input {
	public static void main(String[] args){
//		char c=' ';
//		System.out.print("please input a char:\n");
//		try{
//			c=(char)System.in.read();//����һ���ַ�
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
//			s=in.readLine();//����һ������,�����ո�
//		}catch(IOException e){
//			
//		}
//		System.out.println("You have enter a line:"+s);
		
		
		
		String s1=" ";
		int i=-1;
		System.out.print("please input a int:\n");
		try{
			BufferedReader in1=new BufferedReader(new InputStreamReader(System.in));
			s1=in1.readLine();//�����������ֵ��ַ�����ʽ
			i=Integer.parseInt(s1);//ת������
		}catch(IOException e){
			
		}
		System.out.println("You have enter a int:"+i);
	}

}
