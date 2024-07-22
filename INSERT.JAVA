import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Prakash extends Frame implements ActionListener {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	Font f1 = new Font("ARIAL", Font.BOLD, 28);
	Font f2 = new Font("Forte", Font.PLAIN, 20);
	Label ll = new Label("DATA is Inserting Here :");
	Label l1 = new Label("Sl_No     (EX- 08)  :");
	Label l2 = new Label("Name :");
	Label l3 = new Label("F_Name :");
	Label l4 = new Label("Address :");
	Label l5 = new Label("DOB(EX-DD/MM/YY):");
	Label l6 = new Label("DOA(EX-DD/MM/YY):");
	Label l7 = new Label("Stream :");
	Label l8 = new Label("MOB_No :");
	Label nn=new Label("");
	TextField t1 = new TextField("");
	TextField t2 = new TextField("");
	TextField t3 = new TextField("");
	TextField t4 = new TextField("");
	TextField t5 = new TextField("");
	TextField t6 = new TextField("");
	TextField t7 = new TextField("");
	TextField t8 = new TextField("");
	Button b1 = new Button("Sumbit");
	Button b3 = new Button("Back");
	Button n1 = new Button("ERASE");
	Button n2 = new Button("ERASE");
	Button n3 = new Button("ERASE");
	Button n4 = new Button("ERASE");
	Button n5 = new Button("ERASE");
	Button n6 = new Button("ERASE");
	Button n7 = new Button("ERASE");
	Button n8 = new Button("ERASE");
	Button b2 = new Button("ERASE ALL");
	Label msg=new Label("");
	Prakash() {
		setLayout(null);
		setBackground(Color.white);
		setTitle("Inserting Page");
		add(msg);add(l1);add(l2);add(l3);add(l4);add(l5);	add(l6);add(l7);add(l8);add(nn);add(ll);add(t1);add(t2);	add(t3);add(t4);add(t5);			add(t6);add(t7);add(t8);add(n1);add(n2);add(n3);add(n4);add(n5);add(n6);add(n7);add(n8);add(b3);
		setFont(f2);
		msg.setBounds(300,480,360,30);
		nn.setBounds(20,640,660,30);
		msg.setForeground(Color.GREEN);
		ll.setBounds(180, 80, 385, 40);
		ll.setFont(f1);
		l1.setBounds(40, 150, 185, 30);
		t1.setBounds(270, 150, 200, 30);
		l2.setBounds(40, 190, 185, 30);
		t2.setBounds(270, 190, 200, 30);
		l3.setBounds(40, 230, 185, 30);
		t3.setBounds(270, 230, 200, 30);
		l4.setBounds(40, 270, 185, 30);
		t4.setBounds(270, 270, 200, 30);
		l5.setBounds(40, 310, 200, 30);
		t5.setBounds(270, 310, 200, 30);
		l6.setBounds(40, 350, 200, 30);
		t6.setBounds(270, 350, 200, 30);
		l7.setBounds(40, 390, 185, 30);
		t7.setBounds(270, 390, 200, 30);
		l8.setBounds(40, 430, 185, 30);
		t8.setBounds(270, 430, 200, 30);
		n1.setBounds(540, 150, 100, 30);
		n1.addActionListener(this);
		n2.setBounds(540, 190, 100, 30);
		n2.addActionListener(this);
		n3.setBounds(540, 230, 100, 30);
		n3.addActionListener(this);
		n4.setBounds(540, 270, 100, 30);
		n4.addActionListener(this);
		n5.setBounds(540, 310, 100, 30);
		n5.addActionListener(this);
		n6.setBounds(540, 350, 100, 30);
		n6.addActionListener(this);
		n7.setBounds(540, 390, 100, 30);
		n7.addActionListener(this);
		n8.setBounds(540, 430, 100, 30);
		ll.setForeground(Color.BLUE);
		n8.addActionListener(this);
		b2.setBounds(320, 530, 120, 30);
		b2.addActionListener(this);
		add(b1);
		b1.setBounds(60, 530, 80, 30);
		b1.addActionListener(this);
		add(b2);
		b3.setBounds(520, 530, 80, 30);
		b3.addActionListener(this);
		setBounds(300, 150, 750, 700);
		setVisible(true);
		Connect();
	}

	public void actionPerformed(ActionEvent ea) {
		try {
			Button bt = (Button) ea.getSource();
			if (bt == b1) {
				insert();
				t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");t7.setText("");t8.setText("");
				
				msg.setText("ONE ROW'S SUBMITED SUCESSFULY.........");
			}
			if (bt == n1) 
			{
				add(t1);
				t1.setText("");
			}
			if (bt == n2) {
				add(t2);
				t2.setText("");
			}
			if (bt == n3) {
				add(t3);
				t3.setText("");
			}
			if (bt == n4) {
				add(t4);
				t4.setText("");
			}
			if (bt == n5) {
				add(t5);
				t5.setText("");
			}
			if (bt == n6) {
				add(t6);
				t6.setText("");
			}
			if (bt == n7) {
				add(t7);
				t7.setText("");
			}
			if (bt == n8) {
				add(t8);
				t8.setText("");
			}
			if (bt == b2) {
				add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);add(t8);
				t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");t7.setText("");t8.setText("");
					
			}
			if (bt == b3) {
				Jyoti mm = new Jyoti();
				dispose();
			}
		} catch (Exception a) {
		}
	}
	private void Connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			if (con == null) {
				System.out.println("Connection ERROR....");
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	private void insert()
	{
		try
		{
			int x1=Integer.parseInt(t1.getText());
				
			String x2=t2.getText();
			String u1=x2.toUpperCase();

			String x3=t3.getText();
			String u2=x3.toUpperCase();

			String x4=t4.getText();
			String u3=x4.toUpperCase();

			String x5=t5.getText();
			String u4=x5.toUpperCase();

			String x6=t6.getText();
			String u5=x6.toUpperCase();

			String x7=t7.getText();
			String u6=x7.toUpperCase();

			String x8=t8.getText();
			String u7=x8.toUpperCase();

			String opi="insert into information values(" + x1 + ",'" + u1 + "','" + u2 + "','" + u3 + "','" + u4 + "','" + u5 + "','" + u6 + "','"+ u7 + "')";
			//System.out.println(opi);
			nn.setText(opi);
			stmt=con.createStatement();
			rs=stmt.executeQuery(opi);
			msg.setText("ONE ROW'S SUBMITED SUCESSFULY.........");
		}
		catch(Exception ex){ex.printStackTrace();}
	}
}

class Dipu {
	public static void main(String args[]) {
		Prakash in = new Prakash();
	}
}