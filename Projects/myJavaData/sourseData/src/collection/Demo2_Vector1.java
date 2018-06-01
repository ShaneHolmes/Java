package collection;


/*
 * Vector集合类
 */
import java.util.Vector;//引用JDK的Vector类

public class Demo2_Vector1 extends Vector
{
      public static void main(String[] args)
      {
    	  Demo2_Vector1 a=new Demo2_Vector1();
    	  a.add("13");//添加元素
    	  a.add("32");//添加元素
    	  a.add(1,"99");//在第二个位置插入元素99
    	  //输出结果
    	  for(int i=0;i<a.size();i++){
    		  System.out.print(a.get(i)+" ");
    	  }
    	  a.set(1,"22");//修改第二个元素
    	  a.remove(0);//删除第一个元素
    	  System.out.println("\n修改并删除之后");
    	  for(int i=0;i<a.size();i++){
    		  System.out.print(a.get(i)+" ");
    	  }
    	  
    	  System.out.println("\n转化为字符串之后的输出\n"+a.toString());
      }
}
