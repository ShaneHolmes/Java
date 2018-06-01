package collection;

/*
 * 集合类
 */
import java.util.*;
import java.io.*;//进入io流，输入

public class Demo1_ArrayList {
	public static void main(String[] args) throws Exception{
	    EmpManager em=new EmpManager();//创建一个管理员工对象的类对象
	    //输入流需要写
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    //做出一个简易菜单
	    while(true)
	    {
	    	System.out.println("请选择你要进行的操作：");
	    	System.out.println("1.添加一个雇员");
	    	System.out.println("2.查找一个雇员");
	    	System.out.println("3.修改一个雇员");
	    	System.out.println("4.删除一个雇员");
	    	System.out.println("输入其他不合法的数结束程序");
	    	
	    	String operType=br.readLine();//br可以反复使用
	    	
	    	if(operType.equals("1"))//1.添加一个雇员
	    	{
	    		System.out.println("请输入编号：");
	    		String empNo=br.readLine();
	    		System.out.println("请输入名字：");
	    		String name=br.readLine();
	    		System.out.println("请输入工资：");
	    		float sal=Float.parseFloat(br.readLine());//将读取到的字符串转化成flaot类型
	    		
	    	    Emp emp=new Emp(empNo,name,sal);
	    	    em.addEmp(emp);//em是管理员工对象的类对象，在第七行定义，调用雇员管理类EmpManager的addEmp()方法，添加成员
	    	}
	    	else if(operType.equals("2"))//2.查找一个雇员
	    	{
	    		System.out.println("请输入编号：");
	    		String empNo=br.readLine();
	    		
	    		em.showInfo(empNo);//em是管理员工对象的类对象,调用雇员管理类EmpManager的showInfo()方法，查找输出给定的员工编号的信息
	    	}
	    	else if(operType.equals("3"))//3.修改一个雇员
	    	{
	    		System.out.println("请输入编号：");
	    		String empNo=br.readLine();
	    		
	    		System.out.println("请输入修改后的薪水：");
	    		float newSal=Float.parseFloat(br.readLine());
	    		
	    		em.updateSal(empNo, newSal);
	    		
	    	}
	    	else if(operType.equals("4"))//4.删除一个雇员
	    	{
	    		System.out.println("请输入要删除的雇员的编号：");
	    		String empNo=br.readLine();
	    		
	    		em.delEmp(empNo);
	    	}
	    	else
	    	{
	    		System.out.println("ERROR DATA!");
	    		break;
	    	}
	    }
	}

}

//雇员管理类
class EmpManager
{
	private ArrayList al=null;//声明动态的数组类型变量al,al是这个类中的私有变量，这个类中的方法可以使用这个变量
	public EmpManager()
	{
		al=new ArrayList();//创建动态的数组类型变量al
		/*注释1:还可以使用
		 *     Hashtable ht=new Hashtable();
		 *     ht.put(null,null);
		 *     System.out.println("测试："+ht.get(null));
		 *注释2:ArrayList,Vector的区别
		 *     Vector是线程同步的，ArrayList线程异步。若考虑安全性，应该使用Vector集合类
		 *     在元素个数超出内部集合的目前长度，Vector集合类缺省情况下自动增长原长的一倍长度，ArrayList是原来的50%
		 *     在集合中保存大量数据的时候应该使用Vector
		 *         
		 * */
	}
	//加入员工
	public void addEmp(Emp emp)
	{
		al.add(emp);//往动态数组中添加雇员类的对象成员，用add方法
	}
	//根据给定的员工编号，查找输出显示员工的信息
	public void showInfo(String empNo)
	{
		//遍历整个ArrayList
		for(int i=0;i<al.size();i++)
		{
			//取出Emp对象
			Emp emp=(Emp)al.get(i);/*将ArrayList中的第i个对象元素保存在Emp类的临时对象中
			其中，(Emp)是强制转换，al.get(i)是object对象类型*/
			if(emp.getEmpNo().equals(empNo))
			{
				//使用equals方法比较内容
				System.out.println("找到该员工，他的信息是：");
				System.out.println("编号="+emp.getEmpNo());
				System.out.println("名字="+emp.getName());
				System.out.println("工资="+emp.getSal());
				break;
			}
		}
	}
	//修改工资
	public void updateSal(String empNo,float newSal)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				emp.setSal(newSal);//修改薪水
			}
		}
	}
	//删除某个员工
	public void delEmp(String empNo)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				al.remove(i);//第i个==要删除的元素
				//或者al.remove(emp);//删除这个对象
			}
		}
	}
	
}


//雇员类
class Emp
{
	private String empNo;
	private String name;
	private float sal;
	//构造函数
	public Emp(String empNo,String name,float sal)
	{
		this.empNo=empNo;
		this.name=name;
		this.sal=sal;
	}
	//通过方法调用类中私有对象成员
	public String getEmpNo()
	{
		return empNo;
	}
	public String getName()
	{
		return name;
	}
	public float getSal()
	{
		return sal;
	}
	//通过方法调用类中私有对象成员
	public void setEmpNo(String empNo)
	{
		this.empNo=empNo;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setSal(float sal)
	{
		this.sal=sal;
	}
	
}