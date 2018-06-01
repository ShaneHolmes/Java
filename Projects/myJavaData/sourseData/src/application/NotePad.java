package application;
import java.io.*;//文件输入输出流
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class NotePad extends JFrame implements ActionListener{

	//声明要用的组件
	JMenuBar jmenubar;//菜单栏组件
	JMenu jmenu1,jmenu2,jmenu3,jmenu4,jmenu5;
	JMenuItem jmenuitem2,jmenuitem3,jmenuitem4,jmenuitem5,jmenuitem6,jmenuitem7;
	
	JMenu secondmenu;//二级菜单
	JMenuItem itemfile,itemproject;
	
	JTextArea jtextarea;
	
	//工具条
	JToolBar jtoolbar;
	JButton jbutton1,jbutton2;
	
	
	//构造函数
	public NotePad()
	{
		//创建组件
		jmenubar=new JMenuBar(); 
		jmenu1=new JMenu("文件<F>");
		jmenu1.setMnemonic('F');//设置助记符，按下Alt+F键相当于点击这一个JMenu"文件<F>"
		jmenu2=new JMenu("编辑<E>");
		jmenu2.setMnemonic('E');//设置助记符
		jmenu3=new JMenu("格式<O>");
		jmenu3.setMnemonic('O');//设置助记符
		jmenu4=new JMenu("查看<V>");
		jmenu4.setMnemonic('V');//设置助记符
		jmenu5=new JMenu("帮助<H>");
		jmenu5.setMnemonic('H');//设置助记符
		
		secondmenu=new JMenu("新建");
		itemfile=new JMenuItem("文件");
		itemproject=new JMenuItem("工程");
		
		jmenuitem2=new JMenuItem("打开");
		jmenuitem3=new JMenuItem("保存");
		jmenuitem4=new JMenuItem("另存为");
		jmenuitem5=new JMenuItem("页面设置");
		jmenuitem6=new JMenuItem("打印");
		jmenuitem7=new JMenuItem("退出");
		
		jtextarea=new JTextArea();
		
		jtoolbar=new JToolBar();
		jbutton1=new JButton(new ImageIcon("images/start.jpg"));//将图片放到按钮上
		jbutton1.setToolTipText("新建");//设置当鼠标划过时的提示信息
		jbutton2=new JButton(new ImageIcon("images/continue.jpg"));
		jbutton2.setToolTipText("打开");//设置当鼠标划过时的提示信息
		
		//设置布局管理器
		
		
		//添加组件,按从小到大的顺序逐个添加
		//将菜单项添加到菜单上
		secondmenu.add(itemfile);
		secondmenu.add(itemproject);
		
		jmenu1.add(secondmenu);
		jmenu1.add(jmenuitem2);
		jmenu1.add(jmenuitem3);
		jmenu1.add(jmenuitem4);
		jmenu1.addSeparator();//添加分割线
		jmenu1.add(jmenuitem5);
		jmenu1.addSeparator();//添加分割线
		jmenu1.add(jmenuitem6);
		jmenu1.addSeparator();//添加分割线
		jmenu1.add(jmenuitem7);
		
		//将按钮添加到工具条上
		jtoolbar.add(jbutton1);
		jtoolbar.add(jbutton2);
		
		//将菜单添加到菜单条上
		jmenubar.add(jmenu1);
		jmenubar.add(jmenu2);
		jmenubar.add(jmenu3);
		jmenubar.add(jmenu4);
		jmenubar.add(jmenu5);
		
		//将菜单条添加到窗体上
		this.setJMenuBar(jmenubar);
		
		//将工具条放到窗体上
		this.add(jtoolbar,BorderLayout.NORTH);
		
		//将jtextarea放到窗体中
		JScrollPane jscrollpane=new JScrollPane(jtextarea);//设置滚动窗格
		//下面一行设置滚动条何时出现，有从不出现NEVER，一直出现ALWAYS，需要时出现NEEDED三种
		jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    //最后往窗口中添加
	    this.add(jscrollpane);
	
	    
	    /*
	     * 注册监听
	     */
	    jmenuitem2.addActionListener(this);
	    jmenuitem3.addActionListener(this);
	    jmenu1.addActionListener(this);//jmenu1是事件源,让this去监听
	    jmenu2.addActionListener(this);
	    jmenu3.addActionListener(this);
	    jmenu4.addActionListener(this);
	    jmenu5.addActionListener(this);
	    
	    
	    
	    
	    //指定action命令，监听者监听多个事件源，通过指定action命令的方法，将是哪个事件源的事件发生传递给监听者，监听者以此做出相应的反应
	    jmenuitem2.setActionCommand("打开");
	    jmenuitem3.setActionCommand("保存");
	    jmenu1.setActionCommand("文件");
	    jmenu2.setActionCommand("编辑");
	    jmenu3.setActionCommand("格式");
	    jmenu4.setActionCommand("查看");
	    jmenu5.setActionCommand("帮助");
	    
	    
	    //设置窗口的属性
	    this.setIconImage((new ImageIcon("images/1.jpg")).getImage());
	    this.setTitle("记事本");
	    this.setSize(600,800);
	  	this.setBackground(getForeground());
	  	this.setLocation(700,100);
	  	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  	this.setVisible(true);
	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotePad demo=new NotePad();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("打开")){
			//文件选择组件
			JFileChooser jfc1=new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("请选择文件...");//设置创建文件对话框名字
			jfc1.showOpenDialog(null);//以默认方式展示创建文件路径
			jfc1.setVisible(true);//显示
			
			String filename=jfc1.getSelectedFile().getAbsolutePath();//将选中的文件的绝对路径赋给filename
			System.out.println(filename);
			FileReader fr=null;
			BufferedReader br=null;
			try{
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				
				//从文件中读取信息并显示
				String s="";
				String alls="";
				while((s=br.readLine())!=null)
				{
					alls+=s+"\r\n";//把所有的文件信息先保存在alls,之后再一起输出显示
				}
				//显示在JTextArea
				jtextarea.setText(alls);
			}catch(Exception en){
				en.printStackTrace();
			}finally{
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fr.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("保存")){
			//出现保存对话框
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("另存为...");
			jfc.showSaveDialog(null);//按默认的方式保存
			jfc.setVisible(true);
			
			//得到用户希望保存的路径
			String file=jfc.getSelectedFile().getName();
			
			//然后写入要保存的文件中
			FileWriter fw=null;
			BufferedWriter bw=null;
			try{
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				
				bw.write(this.jtextarea.getText());
			}catch(Exception e2){
				e2.printStackTrace();
			}finally{
				try {
					fw.close();
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else if(e.getActionCommand().equals("格式")){
			
		}else if(e.getActionCommand().equals("查看")){
			
		}else if(e.getActionCommand().equals("帮助")){
			
		}else if(e.getActionCommand().equals("格式")){
			
		}
			
	}

}
