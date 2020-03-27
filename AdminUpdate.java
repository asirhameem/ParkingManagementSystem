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


class AdminUpdate extends Frame implements ActionListener{
	
	private TextField tf1;
	private TextField tf2;
	private TextField tf3;
    private Admin admin;
	private Home home;
	
	public AdminUpdate(Home h){
		super("Update Admin Profile");
		home=h;
		Label l1=new Label(" New email");
		Label l2=new Label(" New Car Number");
		Label l3=new Label(" New Password");
		tf1=new TextField(20); 
		tf2=new TextField(20);
		tf3=new TextField(20);
		Button b1=new Button("Back");
		Button b2=new Button("Update");
		
		add(l1);add(tf1);
		add(l2);add(tf2);
		add(l3);add(tf3);
		add(b1);add(b2);
		
		setSize(600,400);
		l1.setBounds(80,80,130,30);
        l2.setBounds(80,120,130,30);
		l3.setBounds(80,160,130,30);
		tf1.setBounds(230,80,260,30);
		tf2.setBounds(230,120,260,30);
		tf3.setBounds(230,160,260,30);
		b1.setBounds(100,300,170,30);
		b2.setBounds(300,300,150,30);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(103, 129, 171));
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		System.out.println(s);
		if(s.equals("Update")){
			String q="insert into admin values('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"')";
			System.out.println(q);
			DataAccess da=new DataAccess();
			da.updateDB(q);
		}
		else if(s.equals("Back")){
			admin.setVisible(true);
			this.setVisible(false);
		}
	}
}