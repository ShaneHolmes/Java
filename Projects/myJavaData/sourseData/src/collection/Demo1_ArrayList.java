package collection;

/*
 * ������
 */
import java.util.*;
import java.io.*;//����io��������

public class Demo1_ArrayList {
	public static void main(String[] args) throws Exception{
	    EmpManager em=new EmpManager();//����һ������Ա������������
	    //��������Ҫд
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    //����һ�����ײ˵�
	    while(true)
	    {
	    	System.out.println("��ѡ����Ҫ���еĲ�����");
	    	System.out.println("1.���һ����Ա");
	    	System.out.println("2.����һ����Ա");
	    	System.out.println("3.�޸�һ����Ա");
	    	System.out.println("4.ɾ��һ����Ա");
	    	System.out.println("�����������Ϸ�������������");
	    	
	    	String operType=br.readLine();//br���Է���ʹ��
	    	
	    	if(operType.equals("1"))//1.���һ����Ա
	    	{
	    		System.out.println("�������ţ�");
	    		String empNo=br.readLine();
	    		System.out.println("���������֣�");
	    		String name=br.readLine();
	    		System.out.println("�����빤�ʣ�");
	    		float sal=Float.parseFloat(br.readLine());//����ȡ�����ַ���ת����flaot����
	    		
	    	    Emp emp=new Emp(empNo,name,sal);
	    	    em.addEmp(emp);//em�ǹ���Ա�������������ڵ����ж��壬���ù�Ա������EmpManager��addEmp()��������ӳ�Ա
	    	}
	    	else if(operType.equals("2"))//2.����һ����Ա
	    	{
	    		System.out.println("�������ţ�");
	    		String empNo=br.readLine();
	    		
	    		em.showInfo(empNo);//em�ǹ���Ա������������,���ù�Ա������EmpManager��showInfo()�������������������Ա����ŵ���Ϣ
	    	}
	    	else if(operType.equals("3"))//3.�޸�һ����Ա
	    	{
	    		System.out.println("�������ţ�");
	    		String empNo=br.readLine();
	    		
	    		System.out.println("�������޸ĺ��нˮ��");
	    		float newSal=Float.parseFloat(br.readLine());
	    		
	    		em.updateSal(empNo, newSal);
	    		
	    	}
	    	else if(operType.equals("4"))//4.ɾ��һ����Ա
	    	{
	    		System.out.println("������Ҫɾ���Ĺ�Ա�ı�ţ�");
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

//��Ա������
class EmpManager
{
	private ArrayList al=null;//������̬���������ͱ���al,al��������е�˽�б�����������еķ�������ʹ���������
	public EmpManager()
	{
		al=new ArrayList();//������̬���������ͱ���al
		/*ע��1:������ʹ��
		 *     Hashtable ht=new Hashtable();
		 *     ht.put(null,null);
		 *     System.out.println("���ԣ�"+ht.get(null));
		 *ע��2:ArrayList,Vector������
		 *     Vector���߳�ͬ���ģ�ArrayList�߳��첽�������ǰ�ȫ�ԣ�Ӧ��ʹ��Vector������
		 *     ��Ԫ�ظ��������ڲ����ϵ�Ŀǰ���ȣ�Vector������ȱʡ������Զ�����ԭ����һ�����ȣ�ArrayList��ԭ����50%
		 *     �ڼ����б���������ݵ�ʱ��Ӧ��ʹ��Vector
		 *         
		 * */
	}
	//����Ա��
	public void addEmp(Emp emp)
	{
		al.add(emp);//����̬��������ӹ�Ա��Ķ����Ա����add����
	}
	//���ݸ�����Ա����ţ����������ʾԱ������Ϣ
	public void showInfo(String empNo)
	{
		//��������ArrayList
		for(int i=0;i<al.size();i++)
		{
			//ȡ��Emp����
			Emp emp=(Emp)al.get(i);/*��ArrayList�еĵ�i������Ԫ�ر�����Emp�����ʱ������
			���У�(Emp)��ǿ��ת����al.get(i)��object��������*/
			if(emp.getEmpNo().equals(empNo))
			{
				//ʹ��equals�����Ƚ�����
				System.out.println("�ҵ���Ա����������Ϣ�ǣ�");
				System.out.println("���="+emp.getEmpNo());
				System.out.println("����="+emp.getName());
				System.out.println("����="+emp.getSal());
				break;
			}
		}
	}
	//�޸Ĺ���
	public void updateSal(String empNo,float newSal)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				emp.setSal(newSal);//�޸�нˮ
			}
		}
	}
	//ɾ��ĳ��Ա��
	public void delEmp(String empNo)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				al.remove(i);//��i��==Ҫɾ����Ԫ��
				//����al.remove(emp);//ɾ���������
			}
		}
	}
	
}


//��Ա��
class Emp
{
	private String empNo;
	private String name;
	private float sal;
	//���캯��
	public Emp(String empNo,String name,float sal)
	{
		this.empNo=empNo;
		this.name=name;
		this.sal=sal;
	}
	//ͨ��������������˽�ж����Ա
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
	//ͨ��������������˽�ж����Ա
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