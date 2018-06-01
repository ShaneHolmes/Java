package wdx.hw2.substring;
import java.lang.*;
import java.util.*;
public class Substring {

	public static void main(String args[]){
		System.out.println(args[0].substring
				(Integer.parseInt(args[1]),
				Integer.parseInt(args[1])+Integer.parseInt(args[2])));
	}
	
}

