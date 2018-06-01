package collection;


/*
 * ����
 */

import java.lang.reflect.Method;//java���䷽����
public class Demo3_Generic {
	public static void main(String[] args)
	{
		Gen<Bird> gen1=new Gen<Bird>(new Bird());//��T�������Ϊ���������������棬T����Bird���͵ı�������
		gen1.showTypeName();//gen1 ��Gen<>���ͣ�Bird�����͵ı���������Gen<>�����е�showTypeName()����
	
	    Gen<String> str=new Gen<String>("Shane Holmes");
	    str.showString();
	}

}


//����һ��Bird��
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



class Gen<T>//TΪδ֪�����ͣ�����ʹ�÷��͡�����Ĳ�����ʲô��T����ʲô����
{
	private T o;
	//���캯��
	public Gen(T a)
	{
		o=a;
	}
	
	//�õ�T���͵�����
	public void showTypeName()
	{
		System.out.println("�����ǣ�"+o.getClass().getName());
		//ͨ��������ƣ����ǿ��Եõ�T������͵ĺܶ���Ϣ�����Ա���� 
		Method []m=o.getClass().getDeclaredMethods();//m�ĳ���Ϊo�����T�������ķ�����
		//��ӡ
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
