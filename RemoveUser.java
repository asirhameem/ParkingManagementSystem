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


public class RemoveUser extends Frame implements ActionListener{
   
	TextField tf1;
    private Admin admin;
    private Home home;
	public RemoveUser(Home h){
			super("Remove User");
			home=h;
		    Label l1=new Label(" ID ");
            tf1=new TextField(20);
            Button b1=new Button("Remove");
            Button b2=new Button("Back");
            add(l1);add(tf1);
            add(b1);add(b2);
            setSize(600,400);
            setLayout(new FlowLayout());
            setVisible(true);
            setBackground(new Color(103, 129, 171));
            
            b1.addActionListener(this);
            b2.addActionListener(this);
			
		
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String s = ae.getActionCommand();
        if(s.equals("Remove")){
            DataAccess da=new DataAccess();
            String typedId=tf1.getText();
            String q="select * from user where user_id='"+typedId+"'";
            ResultSet rs=null;
            try{
		rs = da.getData(q);
		while(rs.next()){
		String id = rs.getString("user_id");
		if(id.equals(typedId)){
			String d = "delete from user where user_id = '"+typedId+"'";
			da.updateDB(d);
                        JOptionPane.showMessageDialog(this,"Removed Successfully");
                        break;
				}
                else{
                    JOptionPane.showMessageDialog(this,"Invalid ID !!");
                    System.out.println("Invalid ID !!");
			}
		}
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Invalid ID !!");
                ex.printStackTrace();
            }
        }
        if(s.equals("Back")){
            admin.setVisible(true);
            this.setVisible(false);
        }
}
}