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



class AdminProfile extends Frame implements ActionListener{ 

		private Home home;
		private Admin admin;
	public AdminProfile(Home h){
		super("Admin Profile");
		home=h;
	
		Label l1=new Label("Name");
		Label l2=new Label("ID");
		Label l3=new Label("email");
		Label l4=new Label("Car Number");
		Label l5=new Label("Balance");
		Button b2=new Button("Back");
		
		add(l1);add(l2);
		add(l3);add(l4);
		add(l5);add(b2);
		
		setSize(600,400);
		l1.setBounds(150,80,260,30);
       	l2.setBounds(150,120,260,30);
		l3.setBounds(150,160,260,30);
		l4.setBounds(150,200,260,30);
		l5.setBounds(150,240,260,30);
		b2.setBounds(300,300,150,30);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(103, 129, 171));
		
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
			if(s.equals("Back")){

			this.setVisible(false);
			admin.setVisible(true);
		}
	}
}