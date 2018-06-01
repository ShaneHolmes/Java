package wdx.hw4.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Calculator简易版本
public class Calculator extends JFrame implements ActionListener {
    //全局变量
    private final String[] contents = {"7","8","9","+","4","5","6","-","1","2","3","*",".","0","=","/"};
    private boolean flag_firstNumber = true;
    String operator = "=";
    double result = 0.0;
    String first_number="",second_number= "";
    JButton []jbuttons;
    JButton clear;
    JTextField expression;
    //constructor
    Calculator(){
        super("Calculator");
        jbuttons = new JButton[contents.length];
        clear = new JButton("clear");
        expression = new JTextField("");
        Container container = this.getContentPane();
        JPanel northernpanel = new JPanel();
        northernpanel.setLayout(new BorderLayout());
        northernpanel.setPreferredSize(new Dimension(300, 40));
        northernpanel.add("Center",expression);
        northernpanel.add("East",clear);
        //注册监听机制
        clear.addActionListener(this);
        expression.addActionListener(this);
        JPanel southernpanel = new JPanel();
        //网格布局
        southernpanel.setLayout(new GridLayout(4,4));
        //布局按钮
        for(int i = 0;i < contents.length; i++)
        {
            jbuttons[i] = new JButton(contents[i]);
            southernpanel.add(jbuttons[i]);
            jbuttons[i].addActionListener(this);
        }
        container.setLayout(new BorderLayout());
        container.add("North",northernpanel);
        container.add("Center",southernpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,250);
        this.setVisible(true);
        this.setBackground(Color.GRAY);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object target = e.getSource();
        String clickSource = e.getActionCommand();

        if(target == clear){   
            handleclear();  
        } else if("0123456789.".indexOf(clickSource) >= 0){
            if(flag_firstNumber){
                first_number+=clickSource;
            } else if (!flag_firstNumber){ 
                second_number+=clickSource;
            }
            handleNumber(clickSource);
        } else{
            handleOperator(clickSource);
            flag_firstNumber = false;
        }
    }

    public void handleclear(){
        expression.setText("");
        flag_firstNumber = true;
        result = 0.0;
        first_number = "";
        second_number = "";
    }

    public void handleNumber(String key){
        expression.setText(expression.getText() + key);
    }

    public void handleOperator(String key){
        expression.setText(expression.getText() + key);

        if(flag_firstNumber) {  operator = key; }
        else {
            double a = Double.parseDouble(first_number);
            double b = Double.parseDouble(second_number);
                      System.out.println(first_number);
                      System.out.println(second_number);
            switch(operator){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                case "/":
                    result = a/b;
                    break;
                default:

            }
            expression.setText("" + result);
        }
    }

    public static void main(String[] args){ 
        new Calculator();  
    }

   }