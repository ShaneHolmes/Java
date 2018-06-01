package wdx.hw2.cal;
import java.util.*;
public class Cal {
	//周几
	public static final String[] DAYS = { "Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday" };
	//月份
	public static final String[] MONTHS = { "January","February","March","April","May","June","July","August","September","October","November","December" };
	//天数
	public static int daysInMonth(Calendar calenda) {
		return (calenda.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	//
	public static String getDayName(Calendar calenda) {
		return (DAYS[calenda.get(Calendar.DAY_OF_WEEK) - 1]);
	}
	
	public static String getMonthName(Calendar calenda) {
		return (MONTHS[calenda.get(Calendar.MONTH)]);
	}
	//构�?�函�? 
	Cal(int month, int year) {
		Calendar calenda = Calendar.getInstance();
		calenda.clear();
		calenda.set(Calendar.YEAR, year);
		calenda.set(Calendar.MONTH, month);
		int day = daysInMonth(calenda);
		int dayOfWeek = calenda.get(Calendar.DAY_OF_WEEK);
		String monthName = getMonthName(calenda);
		System.out.println(monthName + " " + year);
		System.out.println("Su Mo Tu We Th Fr Sa");
		for (int i = 1; i < dayOfWeek; i++) {
			System.out.print("     ");
		}
		for (int i = 1; i <= day; i++) {
			if (i < 10) {
				System.out.print("  " + i + " ");
			} else {
				System.out.print(i + " ");
			}
			if (dayOfWeek == 7) {
				System.out.println();
				dayOfWeek = 1;
			} else {
				dayOfWeek++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方�?
		Calendar calenda = Calendar.getInstance();//calenda实例
		//没有输入，默认为当前时间
		int month = calenda.get(Calendar.MONTH);
		int year = calenda.get(Calendar.YEAR);
		//计算参数个数
		int numOfArgs=0;
		for (String s : args) {
			numOfArgs++;
		}
		if (numOfArgs != 0) {
			month = Integer.parseInt(args[0]) - 1;
			year = Integer.parseInt(args[1]);
		}
		Cal mycal = new Cal(month, year);
	}
}
