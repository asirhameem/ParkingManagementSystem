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


class User extends Frame implements ActionListener{ 

		public UserUpdate update;
		public Home home;

	public User(Home h){
		super("User");
		home=h;
		
		Label l1=new Label("Name");
		Label l2=new Label("ID");
		Label l3=new Label("email");
		Label l4=new Label("Car Number");
		Label l5=new Label("Balance");
		Button b1=new Button("Update");
		Button b2=new Button("Sign Out");
		
		add(l1);add(l2);
		add(l3);add(l4);
		add(l5);
		add(b1);add(b2);
		
		setSize(600,400);
		l1.setBounds(150,80,260,30);
       	l2.setBounds(150,120,260,30);
		l3.setBounds(150,160,260,30);
		l4.setBounds(150,200,260,30);
		l5.setBounds(150,240,260,30);
		b1.setBounds(100,300,170,30);
		b2.setBounds(300,300,150,30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(103, 129, 171));
		
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("Update")){
			this.setVisible(false);
			update.setVisible(true);
		}
		else if(s.equals("Sign Out")){
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/Y HH:mm");
			String q="insert into departure_time values('"+sdf.format(date)+"')";
			System.out.println(q);
			DataAccess da=new DataAccess();
			da.updateDB(q);
			this.setVisible(false);
			home.setVisible(true);
		}
	}
}