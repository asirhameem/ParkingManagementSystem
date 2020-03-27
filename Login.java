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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends Frame implements ActionListener{
	
	TextField tf1;
	TextField tf2;
	private Home home;
	private Admin admin;
	private User user;
	private Frame parent;
	
	public Login(Home h){
		super("Log In ");
		home=h;
		Label l1=new Label(" ID ");
		Label l2=new Label("Password");
		tf1=new TextField(20);
		tf2=new TextField(20);
		tf2.setEchoChar('*');
		Button b1=new Button("Back");
		Button b2=new Button("Log in");

		add(l1);add(tf1);
		add(l2);add(tf2);
		add(b1);add(b2);
		
		l1.setBounds(80,60,80,20);
        tf1.setBounds(165,60,155,20);
        l2.setBounds(80,90,80,20);
        tf2.setBounds(165,90,155,20);
		b1.setBounds(80,210,70,20);
        b2.setBounds(165,210,70,20);
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		setSize(600,400);
		setLayout(null);
		//setVisible(true);
		setBackground(new Color(103, 129, 171));
		
	}
	
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Log in")){
			DataAccess da=new DataAccess();
			String typedId=tf1.getText();
			String typedPass=tf2.getText();
			String q="select user_id,password from user";
			 q="select * from user where user_id='"+typedId+"' and password='"+typedPass+"'";
			ResultSet rs=null;
			System.out.println("Button pressed");		
			try{
				rs=da.getData(q);
				System.out.println(q);
				while(rs.next()){
					String id = rs.getString("user_id");
					String pass= rs.getString("password");
					if(id.equals(typedId) && pass.equals(typedPass)){
						System.out.println("Correct Cred.");
						JOptionPane.showMessageDialog(this,"Correct Cred.");
						user.setVisible(true);
						this.setVisible(false);
						break;
					}
				}
			}
			
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Login Error");
				//ex.printStackTrace();
			}
		}
		else if(s.equals("Back")){
			home.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		//this.setVisible(false);
		System.exit(0);
		//System.out.println("Window closing");
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}