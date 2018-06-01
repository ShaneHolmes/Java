package collection;


/*
 * 泛型
 */

import java.lang.reflect.Method;//java反射方法类
public class Demo3_Generic {
	public static void main(String[] args)
	{
		Gen<Bird> gen1=new Gen<Bird>(new Bird());//把T这个类作为参数传到泛型里面，T就是Bird类型的变量类型
		gen1.showTypeName();//gen1 是Gen<>泛型，Bird类类型的变量，调用Gen<>泛型中的showTypeName()方法
	
	    Gen<String> str=new Gen<String>("Shane Holmes");
	    str.showString();
	}

}


//定义一个Bird类
class Bird
{
	public void test1()
	{
		System.out.println("aaa");
	}
	public void count(int a,int b)
	{
		System.out.println(a+b);
	}
}



class Gen<T>//T为未知的类型，可以使用泛型。传入的参数是什么，T就是什么类型
{
	private T o;
	//构造函数
	public Gen(T a)
	{
		o=a;
	}
	
	//得到T类型的名称
	public void showTypeName()
	{
		System.out.println("类型是："+o.getClass().getName());
		//通过反射机制，我们可以得到T这个类型的很多信息，如成员数名 
		Method []m=o.getClass().getDeclaredMethods();//m的长度为o这个类T中声明的方法数
		//打印
		for(int i=0;i<m.length;i++)
		{
			  System.out.println(m[i].getName());
		}
	}
	
	
	public void showString()
	{
		System.out.println(o.toString());
	}
}
