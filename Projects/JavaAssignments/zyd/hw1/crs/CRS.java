/*
 *@author ShaneHolmes
 *date:2018.5.7
 *@Right Copy.All right reserved.
**/
package zyd.hw1.crs;

public class CRS {
	private static Book[] books1= { new Book("Thinking in Java"), new Book("Java 8") };
	private static Book[] books2 = { new Book("Web Engineering") };
	
	static Student[] stus = { new Student("15131001") };
	static Course[] courses = { new Course("101", "Java", books1), new Course("102", "WebEngineering", books2) };
	
	public static boolean checkStudent(String stuNo){
		for(Student stu : stus){
			if(stu.getSid().equals(stuNo))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("选课信息不足");
			return;
		}
		String sid = args[0];
		if(!checkStudent(sid)){
			System.out.println("没有这个学生");
			return ;
		}
		boolean firstcourse = true;
		nextCouse: for (int i = 1; i < args.length; i++) {
			for (Course course : courses) {
				if (course.getName().equals(args[i])) {
					if(firstcourse){
						System.out.print(sid + " select " + course.getName() + " with books " + course.bookslist());
						firstcourse = false;
					}else{
						System.out.print("; and " + course.getName() + " with " + course.bookslist());
					}
					continue nextCouse;
				}
			}
		}
	}

}
