import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class SJ extends Frame implements ActionListener
{
	Connection con;
	ResultSet rs;
	Statement st;
	String s1, s2 , s3, s4;
	Label l1 = new Label("--:LOGIN HERE:-- ");
	Label l2= new Label("User Name :- ");
	Label l3= new Label("Password :- ");
	Label l4=new Label("");
	TextField t1=new TextField("");
    	TextField t2=new TextField("");
    	Button b1 = new Button("Login");
    	Button b2 = new Button("Close");
    	Font f1 = new Font("Arial", Font.BOLD, 20);
    	Font f2 = new Font("Arial", Font.BOLD, 18);
	Button bt;
    	SJ()
	 {
        		setLayout(null);
        		setBackground(Color.white);
        		setTitle("LOGIN PAGE");
         		l1.setBounds(220, 80, 200, 80);
         		l1.setForeground(Color.blue);
        		b1.setForeground(Color.green);
         		b2.setForeground(Color.orange);	
        		add(l1);
        		add(b1);
        		add(b2);
        		add(l2);add(l3);add(t1);add(t2);add(l4);
         		l2.setBounds(90,220,120,30);
         		setForeground(Color.BLACK);
        		l3.setBounds(90,300,120,30);
        		l4.setBounds(200,450,380,30);
		l4.setForeground(Color.red);
        		t1.setBounds(210, 220, 200, 30);
         		t2.setBounds(210,300,200,30);
        		l1.setFont(f1);
         		b1.setBounds(170, 390, 80, 30);
        		b2.setBounds(370, 390, 80, 30);
        //l1.setForeground(Color.black);
        		setFont(f2);
		b1.addActionListener(this);
		b2.addActionListener(this);
        		setBounds(100, 100, 600, 600);
        		setVisible(true);
        		Connect();
       	}
	private void check()
     	{
		try
		{
			st=con.createStatement();
			System.out.println("Enter");
			rs=st.executeQuery("select * from login");
			while(rs.next())
			{
				s1=rs.getString(1);
				s2=rs.getString(2);
			}
		
                   
            	
			if(s1.equals(t1.getText()) && s2.equals(t2.getText()))
             		{
				Jyoti j1 = new Jyoti();dispose();
			}
	else
	{
		System.out.println("Wrong password...");
		l4.setText("Wrong Password Please Try Again....");
		t1.setText("");
		t2.setText("");
	}
}
		catch(Exception ex){System.out.println(ex);}	
      	}
       	public void actionPerformed(ActionEvent ae2) {
        	try 
	{	 
		bt = (Button) ae2.getSource();
		if (bt==b1)
            	{
		check();
		}
            	if (bt == b2) 
            	{
                		dispose();
            	}
        	} 
	catch (Exception a)
	{}
    	}
      	private void Connect() {
        	try
	 {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
            	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            	if (con == null) 
		{
                		System.out.println("Connection error");
            	}
        	} 
	catch (Exception e)
	{
            	System.out.println(e.toString());
        	}
    }	 
}
class Dipu
{
	public static void main(String args[])
	 {
		SJ j3 = new SJ();
   	 }
}