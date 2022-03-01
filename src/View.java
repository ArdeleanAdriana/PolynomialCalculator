import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {
	public JPanel contentPane;
	public JLabel p1;
	public JLabel p2;
	public JLabel rez;
	public JTextField polinom1;
	public JTextField polinom2;
	public JTextField rezultat;
	public JButton adunare;
	public JButton scadere;
	public JButton inmultire;
	public JButton impartire;
	public JButton derivare;
	public JButton integrare;

	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		adunare = new JButton("Adunare");
		adunare.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		adunare.setBounds(0, 100, 150, 20);
		contentPane.add(adunare);

		scadere = new JButton("Scadere");
		scadere.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scadere.setBounds(150, 100, 150, 20);
		contentPane.add(scadere);

		inmultire = new JButton("Inmultire");
		inmultire.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inmultire.setBounds(300, 100, 150, 20);
		contentPane.add(inmultire);

		impartire = new JButton("Impartire");
		impartire.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		impartire.setBounds(0, 120, 150, 20);
		contentPane.add(impartire);

		derivare = new JButton("Derivare");
		derivare.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		derivare.setBounds(150, 120, 150, 20);
		contentPane.add(derivare);

		integrare = new JButton("Integrare");
		integrare.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		integrare.setBounds(300, 120, 150, 20);
		contentPane.add(integrare);

		polinom1 = new JTextField();
		polinom1.setBounds(100, 20, 300, 20);
		contentPane.add(polinom1);

		p1 = new JLabel("Polinom 1:");
		p1.setBounds(20, 20, 80, 20);
		contentPane.add(p1);

		polinom2 = new JTextField();
		polinom2.setBounds(100, 50, 300, 20);
		contentPane.add(polinom2);

		p2 = new JLabel("Polinom 2:");
		p2.setBounds(20, 50, 80, 20);
		contentPane.add(p2);

		rezultat = new JTextField();
		rezultat.setBounds(100, 200, 300, 20);
		contentPane.add(rezultat);

		rez = new JLabel("Rezultat:");
		rez.setBounds(20, 200, 80, 20);
		contentPane.add(rez);

	}

	public String getPolinom1() {
		return polinom1.getText();
	}

	public String getPolinom2() {
		return polinom2.getText();
	}

	public void setRezultat(String result) {
		rezultat.setText(result);
	}

	public JButton getAdunare() {
		return adunare;
	}

	public JButton getScadere() {
		return scadere;
	}

	public JButton getInmultire() {
		return inmultire;
	}

	public JButton getImpartire() {
		return impartire;
	}

	public JButton getDerivare() {
		return derivare;
	}

	public JButton getIntegrare() {
		return integrare;
	}
}
