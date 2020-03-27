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


class Admin extends Frame implements ActionListener{
       
        private RemoveUser remove;
		private AdminUpdate update;
		private AdminProfile profile;
		private Home home;
   	
        public Admin(Home h){
		super("Admin");
		home=h;
	
		
		Button b1=new Button("Profile");
		Button b2=new Button("Remove User");
		Button b3=new Button("Users List");
		Button b4=new Button("Update");
		Button b5=new Button("Sign out");
		add(b1);add(b2);
		add(b3);add(b4);
		add(b5);
                
        b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		setSize(600,400);
		b1.setBounds(150,80,260,30);
       	b2.setBounds(150,120,260,30);
		b3.setBounds(150,160,260,30);
		b4.setBounds(150,200,260,30);
		b5.setBounds(150,240,260,30);
	
		setLayout(null);
		setVisible(true);
		setBackground(new Color(103, 129, 171));
            }        
        
           @Override
        public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
                if(s.equals("Profile")){
					this.setVisible(false);
					profile.setVisible(true);
                   
        }
                if(s.equals("Remove User")){
                   remove.setVisible(true);
                   this.setVisible(false);
        }
                if(s.equals("User List")){
                    String q = "select * from user";
                    DataAccess da=new DataAccess();
                    da.updateDB(q);
                    
        }
                if(s.equals("Update")){
					this.setVisible(false);
					update.setVisible(true);
                    
        }
                if(s.equals("Sign out")){
                    this.setVisible(false);
					home.setVisible(true);
                    
        }
		}

}
		