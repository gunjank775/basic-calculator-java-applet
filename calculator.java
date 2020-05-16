import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;;
import java.util.Stack;


/* <applet code="calculator" width="260" height="300"> </applet>*/
public class calculator extends Applet { 
           String s,s1,s2,s3,s4;
             double a,b,c;
	        TextField l; 
		Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1; 
       public void init(){
		l = new TextField(16); 
		b0 = new Button("0"); 
		b1 = new Button("1"); 
		b2 = new Button("2"); 
		b3 = new Button("3"); 
		b4 = new Button("4"); 
		b5 = new Button("5"); 
		b6 = new Button("6"); 
		b7 = new Button("7"); 
		b8 = new Button("8"); 
		b9 = new Button("9"); 
		beq1 = new Button("=");  
		ba = new Button("+"); 
		bs = new Button("-"); 
		bd = new Button("/"); 
		bm = new Button("*"); 
		beq = new Button("C"); 
		be = new Button("."); 
                setLayout(null);
   l.setBounds(20,30,200,30);

   b7.setBounds(20,70,40,40);
   b8.setBounds(70,70,40,40);
   b9.setBounds(120,70,40,40);
   beq.setBounds(170,70,40,30);

   b4.setBounds(20,120,40,40);
   b5.setBounds(70,120,40,40);
   b6.setBounds(120,120,40,40);
   bd.setBounds(170,110,40,30);

   b1.setBounds(20,170,40,40);
   b2.setBounds(70,170,40,40);
   b3.setBounds(120,170,40,40);
   bm.setBounds(170,150,40,30);
   bs.setBounds(170,190,40,30);

   b0.setBounds(20,220,40,40);
   be.setBounds(70,220,40,40);
   beq1.setBounds(120,220,40,40);
   ba.setBounds(170,230,40,30);
  
  
		add(l); 
		add(ba); 
		add(b1); 
		add(b2); 
		add(b3); 
		add(bs); 
		add(b4); 
		add(b5); 
		add(b6); 
		add(bm); 
		add(b7); 
        	add(b8); 
		add(b9); 
		add(bd); 
		add(be); 
		add(b0); 
		add(beq); 
		add(beq1); 	

                bm.addActionListener(new MyHandler()); 
		bd.addActionListener(new MyHandler()); 
		bs.addActionListener(new MyHandler()); 
		ba.addActionListener(new MyHandler()); 
		b9.addActionListener(new MyHandler()); 
		b8.addActionListener(new MyHandler()); 
		b7.addActionListener(new MyHandler()); 
		b6.addActionListener(new MyHandler()); 
		b5.addActionListener(new MyHandler()); 
		b4.addActionListener(new MyHandler()); 
		b3.addActionListener(new MyHandler()); 
		b2.addActionListener(new MyHandler()); 
		b1.addActionListener(new MyHandler()); 
		b0.addActionListener(new MyHandler()); 
		be.addActionListener(new MyHandler()); 
		beq.addActionListener(new MyHandler()); 
		beq1.addActionListener(new MyHandler());
	} 
public class MyHandler implements ActionListener
{

public int getPref(char c)
    {
        switch(c)
        {
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
            default:return 3;
        }
    }


 public void actionPerformed(ActionEvent e)
 {
  s=e.getActionCommand();
  if(s.equals("0")||s.equals("1")||s.equals("2")||
s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6")||s.equals("7")||s.equals("8")||
s.equals("9")||s.equals("0"))
  {
   s1=l.getText()+s;
   l.setText(s1);
  }
  if(s.equals("+"))
  {
     s1=l.getText()+"+";
     l.setText(s1);
  }
  if(s.equals("-"))
  {
     s1=l.getText()+"-";
     l.setText(s1);
  }
  if(s.equals("/"))
  {
     s1=l.getText()+"/";
     l.setText(s1);

  }
  if(s.equals("*"))
  {
     s1=l.getText()+"*";
     l.setText(s1);
  }
  if(s.equals("="))
  {
   String exp=l.getText();
        String result="";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char c = exp.charAt(i); 
              
            if (Character.isLetterOrDigit(c)) 
                result += c; 
            else if (c == '(') 
                stack.push(c); 
            else if (c== ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                if (!stack.isEmpty() && stack.peek() != '(') 
                    l.setText("Error");
                else
                    stack.pop();
               
            }
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && getPref(c) <= getPref(stack.peek())){ 
                    if(stack.peek() == '(') 
                        l.setText("Error");
                    result += stack.pop(); 
             } 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                l.setText("Error");
            result += stack.pop(); 
         }
        //jTextField1.setText(result);
        
        //create a stack 
        Stack<Integer> stack1=new Stack<>(); 
          
        // Scan all characters one by one 
        for(int i=0;i<result.length();i++) 
        { 
            char c=result.charAt(i); 
              
            // If the scanned character is an operand (number here), 
            // push it to the stack. 
            if(Character.isDigit(c)) 
            stack1.push(c - '0'); 
              
            //  If the scanned character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack1.pop(); 
                int val2 = stack1.pop(); 
                  
                switch(c) 
                { 
                    case '+': 
                    stack1.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack1.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack1.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack1.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        l.setText(stack1.pop()+"");
        
  }
  if(s.equals("C"))
  {
   l.setText("");
  }
 }
 public void textValueChanged(TextEvent e)
 {
  
 }
}
} 
