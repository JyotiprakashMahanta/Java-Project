import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class Open1 extends Frame implements ActionListener
 {
    	private Connection con;
    	private Statement st;
    	private ResultSet rs;
    	private ResultSetMetaData rsmd;
    	int r, c,b;
	Label ll=new Label("-SEARCH USER-");
	Label l1=new Label("SEARCH BY:");
	Label l2=new Label("");
	TextField t1=new TextField("");
    	TextField t[][] = new TextField[11][8];
	Button b1=new Button("SEARCH");
	Button b2=new Button("EXIT");
    	Font f1 = new Font("Arial", Font.BOLD, 20);
	Font f2 = new Font("Arial",Font.ITALIC,18);
	Font f3=new Font("Elephant",Font.PLAIN,20);
   	 int h = 200;

    	Open1()
	 {
		b1.setForeground(Color.green);
		b2.setForeground(Color.orange);
		l1.setForeground(Color.blue);
        		setLayout(null);
		setBackground(Color.white);
		setFont(f3);
		setTitle("Search Details");
		add(ll);
		ll.setBounds(800,80,200,100);ll.setForeground(Color.BLUE);
		ll.setFont(f1);
		add(l1);
		l1.setBounds(600,600,150,40);
		l1.setFont(f1);
		add(l2);l2.setForeground(Color.RED);
		l2.setBounds(1100,600,150,40);
		add(t1);
		t1.setBounds(750,600,300,40);
		t1.setFont(f1);
		add(b1);
		b1.setBounds(750,700,130,30);
		b1.addActionListener(this);
		add(b2);
		b2.setBounds(950,700,80,30);
		b2.addActionListener(this);
	 	for(r=1;r<=11;r++)
		{
			for(c=1;c<=8;c++)
			{
				t[r-1][c-1]=new TextField(" ");
				add(t[r-1][c-1]);
				t[r-1][c-1].setBounds(200*c,c+h,200,30);
				t[r-1][c-1].setFont(f2);
			}
			if(h>=120){h=h+30;}
		}
		setBounds(0,0,2000,900);
		setVisible(true);
		connect();
	}
	public void actionPerformed(ActionEvent ea)
	{
		try
		{
			Button bt=(Button)ea.getSource();
			if(bt==b1){retrived();}
			if(bt==b2){ Jyoti jj=new Jyoti(); dispose();}
		}catch(Exception a){}
	}
	private void connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			if(con==null)
			{
				System.out.println("JDBC is not Connected");
			}
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}
	}
	private void retrived()
	{
		try
		{
			String ok=t1.getText();
			st=con.createStatement();
			rs=st.executeQuery("Select * from INFORMATION where name='"+ok+"'");
			rsmd=rs.getMetaData();
			int cn=rsmd.getColumnCount();
			//System.out.println("No of column= "+cn);
			for(int n=0;n<cn;n++)
			{
				t[0][n].setText("     "+rsmd.getColumnName(n+1));

				t[0][n].setFont(f1);
			}
			           	
			int m=1;
			boolean z=false;
			while (rs.next())
			{
				z=true;
				int k=0;
				int sn=rs.getInt(1);
				String nm=rs.getString(2);
				String fn=rs.getString(3);
				String add=rs.getString(4);
				String dob=rs.getString(5);
				String doa=rs.getString(6);
				String stm=rs.getString(7);
				String mb=rs.getString(8);
				t[m][k].setText(""+sn); k++;
				t[m][k].setText(nm); k++;
				t[m][k].setText(fn); k++;
				t[m][k].setText(add); k++;
				t[m][k].setText(dob);k++;
				t[m][k].setText(doa);k++;
				t[m][k].setText(stm);k++;
				t[m][k].setText(mb);m++;
			}
			if(z==false)
			{
				l2.setText("Invalid Data!!");
				l2.setFont(f1);
							}
			else
			{
				l2.setText(" ");
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
class Dipu
{
	public static void main(String args[])
	{
		Open1 j1=new Open1();
	}
}		


       












 
