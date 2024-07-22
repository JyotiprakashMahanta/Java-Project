import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.ResultSetMetaData
import java.sql.DriverManager;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Jyoti extends Frame implements ActionListener {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ResultSetMetaData rsmd;

    int r, c, view;
    Label ll = new Label("-Student Information-");
    TextField t[][] = new TextField[10][8];
    String str[] = { "view", "Search", "insert", "delete", "exit" };
    Button bt[] = new Button[5];
    Font f11 = new Font("Arial", Font.BOLD, 30);
    Font f1 = new Font("Arial", Font.BOLD, 20);
    Font f2 = new Font("Elephant", Font.PLAIN, 20);
    int h = 250;

    Jyoti() {
        add(ll);
        ll.setBounds(580, 80, 380, 100);
        ll.setForeground(Color.blue);
        ll.setFont(f11);
        setTitle("Student Information");
        setLayout(null);

        for (r = 1; r <= 10; r++) {
            for (c = 1; c <= 8; c++) {
                t[r - 1][c - 1] = new TextField("");
                add(t[r - 1][c - 1]);
                t[r - 1][c - 1].setBounds(150 * c, r + h, 150, 40);
                t[r - 1][c - 1].setFont(f2);
            }
            if (h >= 100) {
                h = h + 40;
            }

        }
        for (view = 1; view <= 5; view++) {
            bt[view - 1] = new Button(str[view - 1]);
            add(bt[view - 1]);
            bt[view - 1].setBounds(200 * view + 120, 680, 80, 40);
            bt[view - 1].addActionListener(this);
        }
        bt[0].setForeground(Color.blue);
        bt[1].setForeground(Color.blue);
        bt[2].setForeground(Color.blue);
        bt[3].setForeground(Color.blue);
        bt[4].setForeground(Color.blue);
        setFont(f2);
        setBounds(0, 0, 1500, 1250);
        setVisible(true);
        connect();
    }

    void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            if (con == null) {
                System.out.println("JDBC is not Connected");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        Button bb = (Button) ae.getSource();
        if (bb == bt[0]) {
            retrived();
        }
        if (bb == bt[1]) {
            Open1 pp = new Open1();
            dispose();
        }
        if (bb == bt[2]) {
            Prakash oo = new Prakash();
            dispose();
        }
        if (bb == bt[3]) {
            SA jy = new SA();
            dispose();
        }
        if (bb == bt[4]) {
            JJ nl = new JJ();
            dispose();
        }

    }

    private void retrived() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from INFORMATION");
            rsmd = rs.getMetaData();
            int cn = rsmd.getColumnCount();
            for (int n = 0; n < cn; n++) {
                t[0][n].setText("     " + rsmd.getColumnName(n + 1));
                t[0][n].setFont(f1);
            }

            int m = 1;
            int k;
            while (rs.next()) {
                k = 0;
                int sn = rs.getInt(1);
                String nm = rs.getString(2);
                String fn = rs.getString(3);
                String add = rs.getString(4);
                String dob = rs.getString(5);
                String doa = rs.getString(6);
                String stm = rs.getString(7);
                String mb = rs.getString(8);

                t[m][k].setText("" + sn);
                k++;

                t[m][k].setText(nm);
                k++;

                t[m][k].setText(fn);
                k++;

                t[m][k].setText(add);
                k++;

                t[m][k].setText(dob);
                k++;

                t[m][k].setText(doa);
                k++;

                t[m][k].setText(stm);
                k++;

                t[m][k].setText(mb);
                m++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Dipu {
    public static void main(String args[]) {
        Jyoti j1 = new Jyoti();
    }
}
