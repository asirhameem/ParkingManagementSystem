import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;



class Signup extends Frame implements ActionListener{
	private TextField tf1;
	private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	private TextField tf5; 
	private Home home;
	private Frame parent;
	
	public Signup(Home h){
		super("Sign up");
		home=h;
            Label i=new Label(" ID ");
            Label n=new Label(" Name ");
			Label c=new Label(" Car Number ");
			Label e=new Label(" Email ");
            Label p=new Label("Password");
                				
            tf1=new TextField(0);
			tf2=new TextField(0);
			tf3=new TextField(0);
			tf4=new TextField(0);
			tf5=new TextField(0);
		
            Button b=new Button("Back");
            Button s=new Button("Signup");
			
		
            add(n); add(tf1);
			add(i); add(tf2);
			add(c); add(tf3);
			add(p); add(tf4);
			add(e); add(tf5);
            add(b); add(s);
                                
            i.setBounds(80,60,80,20);
            tf1.setBounds(165,60,155,20);
            n.setBounds(80,90,80,20);
            tf2.setBounds(165,90,155,20);
            c.setBounds(80,120,80,20);
            tf3.setBounds(165,120,155,20);
            e.setBounds(80,150,80,20);
            tf4.setBounds(165,150,155,20);
            p.setBounds(80,180,80,20);
            tf5.setBounds(165,180,155,20);
                
            b.setBounds(80,210,70,20);
            s.setBounds(165,210,70,20);
           
                               
			b.addActionListener(this);
			s.addActionListener(this);

						
            setLayout(null);
			setSize(600,400);
            setBackground(new Color(103, 129, 171));
			
			
        }
        @Override
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		System.out.println(s);
		if(s.equals("Signup")){
            DataAccess da=new DataAccess();
			String q="insert into users values('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"')";
			System.out.println(q);
			da.updateDB(q);
		}
		else if(s.equals("Back")){
			home.setVisible(true);
			this.setVisible(false);
		}
    
	}
	public void setParent(Frame f){parent=f;}
}