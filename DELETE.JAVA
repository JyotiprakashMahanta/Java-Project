import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class JS extends Frame implements ActionListener
 {
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    Label l1 = new Label("DELETE USER :");
    Label l2 = new Label("ENTER A NAME :");
    Label l3= new Label("");
    Label l4=new Label("");
    TextField t1 = new TextField("");
    Button b1 = new Button("DELETE");
    Button b2 = new Button("BACK");
    Font f1 = new Font("Arial", Font.BOLD, 30);
    Font f2=new Font("Elephant",Font.PLAIN,20);
    
    JS()
   {
        setLayout(null);
        setBackground(Color.white);
        setTitle("Delete Page"); 
	add(t1); add(l1); add(l2); add(b1); add(b2); add(l3);add(l4);
	l3.setBounds(470,500,500,30);
	l3.setForeground(Color.green);
	l4.setBounds(470,500,500,30);
	l4.setForeground(Color.red);
        b1.setForeground(Color.red);
        b2.setForeground(Color.green);
        l1.setBounds(300, 80, 300, 180);
        l1.setFont(f1);
        l2.setBounds(100, 265, 160, 80);
        t1.setBounds(270, 285, 295, 40);
        b1.setBounds(270, 390, 100, 30);
        b2.setBounds(470, 390, 100, 30);
        l1.setForeground(Color.red);
        l2.setForeground(Color.blue);
        setFont(f2);
        setBounds(100, 100, 800, 700);
	b1.addActionListener(this);
	b2.addActionListener(this);
        setVisible(true);
        Connect();
    }
    public void actionPerformed(ActionEvent ea)
    {
	try
	{
		Button bt=(Button)ea.getSource();
		if(bt==b1){delete();}
		if(bt==b2)
		{
			 Jyoti jk=new Jyoti(); dispose();
		}
	}catch(Exception a){}
     }
     private void delete()
    {
	try
    	 {
		String sq1 = t1.getText();
		String sql="DELETE FROM INFORMATION WHERE NAME='"+sq1+"'";
		ps=con.prepareStatement(sql);
		rs = ps.executeQuery(sql);
		l3.setText("Delete  User Sucessfully...");
	} catch (Exception ex)
	 {
		l4.setText("User not  Found.....");
		ex.printStackTrace();
		
	}
     }
      private void Connect() 
       {
       	  try {
            		Class.forName("oracle.jdbc.driver.OracleDriver");
            		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            		if (con == null) 
		{
              				 System.out.println("Connection error");
            		}
             } catch (Exception e) {System.out.println(e.toString());
        }
    }
}

class Dipu{
    public static void main(String args[]) {
        JS j3 = new JS();
    }
}