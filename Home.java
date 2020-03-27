import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

class Home extends Frame implements ActionListener, WindowListener{
	
	public Login log;
	public Signup sign;
	private int space=30;
	private Label l3=new Label("Available Space :  ");
	private Label l4=new Label();
	
	public Home(){
		super("Parking Management");
		
		log=new Login(this);
		sign=new Signup(this);
		Button b1=new Button("Login");
		Button b2=new Button("Signup");
		Label l1=new Label("Terms & Conditions");
		Label l2=new Label("Contact : parking@aiub.edu");
		
		add(b1);add(b2);
		add(l1);add(l2);
		add(l3);add(l4);
		
       	b1.setBounds(80,80,70,20);
		b2.setBounds(250,80,70,20);
		l1.setBounds(40,240,150,20);
		l2.setBounds(205,240,155,20);
		l3.setBounds(125,140,150,20);
		l4.setBounds(125,180,150,20);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		addWindowListener(this);
		setSize(600,400);
		setLayout(null);
		setVisible(true);
		setBackground(new Color(103, 129, 171));
		
	
		
	}
	public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("Login")){
			space=space-1;
			l4.setText(String.valueOf(space));
			this.setVisible(false);
			log.setVisible(true);
		}
		else if(s.equals("Signup")){
			this.setVisible(false);
			sign.setVisible(true);
			
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