package collection;


/*
 * Vector������
 */
import java.util.Vector;//����JDK��Vector��

public class Demo2_Vector1 extends Vector
{
      public static void main(String[] args)
      {
    	  Demo2_Vector1 a=new Demo2_Vector1();
    	  a.add("13");//���Ԫ��
    	  a.add("32");//���Ԫ��
    	  a.add(1,"99");//�ڵڶ���λ�ò���Ԫ��99
    	  //������
    	  for(int i=0;i<a.size();i++){
    		  System.out.print(a.get(i)+" ");
    	  }
    	  a.set(1,"22");//�޸ĵڶ���Ԫ��
    	  a.remove(0);//ɾ����һ��Ԫ��
    	  System.out.println("\n�޸Ĳ�ɾ��֮��");
    	  for(int i=0;i<a.size();i++){
    		  System.out.print(a.get(i)+" ");
    	  }
    	  
    	  System.out.println("\nת��Ϊ�ַ���֮������\n"+a.toString());
      }
}
