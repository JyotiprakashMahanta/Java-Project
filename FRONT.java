import java.awt.Frame;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class MJ extends Frame implements ActionListener {
	Label l1 = new Label("SCHOLARS ENROLLMENT MANEGEMENT SYSTEM");
	Label l2 = new Label("");
	Label l3 = new Label("J");
	Label l4 = new Label("ava");
	Label l5 = new Label("Project");
	Label l6 = new Label("");
	Label l7 = new Label("");
	Label l8 = new Label("");
	Label l9 = new Label("");
	Label a = new Label("");
	Label b = new Label("");
	Label c = new Label("");
	Label d = new Label("");
	Label e = new Label("");
	Label f = new Label("");
	Label g = new Label("");
	Label h = new Label("");
	Label i = new Label("");
	Label j = new Label("");
	Label k = new Label("");
	Label l = new Label("");
	Label m = new Label("");
	Label n = new Label("");
	Font f1 = new Font("", Font.BOLD, 30);
	Font f2 = new Font("", Font.BOLD, 38);
	Font f3 = new Font("", Font.BOLD, 25);
	Button b1 = new Button("Click Here to Enter The Project");

	MJ() {
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(b1);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(m);
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
		add(f);
		add(g);
		add(h);
		add(i);
		add(j);
		add(k);
		add(l);
		add(n);
		setLayout(null);
		l1.setBounds(500, 300, 1500, 100);
		l1.setFont(f1);
		l1.setForeground(Color.red);
		l1.setBackground(Color.yellow);
		l2.setBounds(0, 300, 500, 100);
		l2.setBackground(Color.yellow);
		l3.setBounds(560, 200, 20, 80);
		l3.setFont(f2);
		l3.setForeground(Color.red);
		l3.setBackground(Color.black);
		l4.setBounds(580, 200, 50, 80);
		l4.setFont(f3);
		l4.setForeground(Color.red);
		l4.setBackground(Color.black);
		l5.setBounds(650, 200, 100, 80);
		l5.setFont(f3);
		l5.setForeground(Color.white);
		l5.setBackground(Color.black);
		l6.setBounds(0, 220, 50, 40);
		l6.setBackground(Color.magenta);
		l7.setBounds(100, 220, 50, 40);
		l7.setBackground(Color.red);
		l8.setBounds(200, 220, 50, 40);
		l8.setBackground(Color.yellow);
		l9.setBounds(300, 220, 50, 40);
		l9.setBackground(Color.blue);
		a.setBounds(400, 220, 50, 40);
		a.setBackground(Color.white);
		b.setBounds(500, 220, 50, 40);
		b.setBackground(Color.orange);
		c.setBounds(750, 220, 50, 40);
		c.setBackground(Color.green);
		d.setBounds(850, 220, 50, 40);
		d.setBackground(Color.magenta);
		e.setBounds(950, 220, 50, 40);
		e.setBackground(Color.red);
		f.setBounds(1050, 220, 50, 40);
		f.setBackground(Color.yellow);
		g.setBounds(1150, 220, 50, 40);
		g.setBackground(Color.blue);
		h.setBounds(1250, 220, 50, 40);
		h.setBackground(Color.white);
		i.setBounds(1350, 220, 50, 40);
		i.setBackground(Color.orange);
		j.setBounds(1450, 220, 50, 40);
		j.setBackground(Color.green);
		k.setBounds(1550, 220, 50, 40);
		k.setBackground(Color.magenta);
		l.setBounds(1650, 220, 50, 40);
		l.setBackground(Color.red);
		m.setBounds(1750, 220, 50, 40);
		m.setBackground(Color.yellow);
		n.setBounds(1850, 220, 50, 40);
		n.setBackground(Color.blue);
		b1.setBounds(800, 600, 600, 80);
		b1.setFont(f3);
		b1.setForeground(Color.green);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		setBounds(0, 0, 2000, 1100);
		setVisible(true);
		setBackground(Color.black);
	}

	public void actionPerformed(ActionEvent ew) {
		try {
			Button ba = (Button) ew.getSource();
			if (ba == b1) {
				SJ hd = new SJ();
				dispose();
			}
		} catch (Exception as) {
		}
	}
}

class Dipu {
	public static void main(String args[]) {
		MJ mj = new MJ();
	}
}