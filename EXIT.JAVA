import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class SJ extends Frame {
    private Connection con;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private Statement st;
    int j, p, m;
    Label l1 = new Label("--EXIT HERE-- ");
    Label l2 = new Label("ARE YOU SURE TO EXIT ? ");
    Button b1 = new Button("YES");
    Button b2 = new Button("NO");
    Font f1 = new Font("Arial", Font.BOLD, 20);
    Font f2 = new Font("Arial", Font.ITALIC, 18);

    SJ() {
        setLayout(null);
        setBackground(Color.WHITE);
        setTitle("EXIT PAGE");
        add(l1);
        add(l2);
        add(b1);
        add(b2);
        b1.setForeground(Color.RED);
        b2.setForeground(Color.GREEN);
        l1.setBounds(220, 80, 200, 180);
        l1.setFont(f1);
        l2.setBounds(170, 250, 320, 80);
        b1.setBounds(170, 390, 80, 30);
        b2.setBounds(370, 390, 80, 30);
        l1.setForeground(Color.BLUE);
        setFont(f2);
        setBounds(100, 100, 600, 600);
        setVisible(true);
        Connect();
    }

    /*
     * public void actionPerformed(ActionEvent ea) {
     * try {
     * Button bt = (Button) ea.getSource();
     * if (bt == b1) {
     * }
     * if (bt == b2) {
     * Jyoti jj = new Jyoti();
     * dispose();
     * }
     * } catch (Exception a) {
     * }
     * }
     */

    public void actionPerformed(ActionEvent ae2) {
        try {
            Button bt = (Button) ae2.getSource();
            if (bt == b1) {
            }
            if (bt == b2) {
                Jyoti jo = new Jyoti();
                dispose();
            }
        } catch (Exception a) {
        }
    }

    private void Connect() {
        try {
            Class.forName("Oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            if (con == null) {
                System.out.println("Connection error");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

class Dipu{
    public static void main(String args[]) {
        SJ j3 = new SJ();
    }
}