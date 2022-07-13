/* Reduce Fraction
* @modified 20220617
* @date 20220617
* @author Lorrin Shen
* @version 1.0
* @See ICS4U1
* 
* Reduce a given fraction to lowest terms
**/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ReduceFraction extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumerator;
	private JTextField txtDenominator;
	private JTextField txtOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReduceFraction frame = new ReduceFraction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReduceFraction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FRACTION REDUCER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(174, 11, 217, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("This program will reduce a fraction to lowest terms.");
		lblNewLabel_1.setBounds(79, 56, 312, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the Numerator:");
		lblNewLabel_2.setBounds(60, 102, 158, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter the Denominator:");
		lblNewLabel_3.setBounds(60, 127, 130, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNumerator = new JTextField();
		txtNumerator.setBounds(247, 99, 86, 20);
		contentPane.add(txtNumerator);
		txtNumerator.setColumns(10);
		
		txtDenominator = new JTextField();
		txtDenominator.setBounds(247, 124, 86, 20);
		contentPane.add(txtDenominator);
		txtDenominator.setColumns(10);
		
		JButton btnCalculate = new JButton("Reduce Fraction to Lowest Terms");
		btnCalculate.setBounds(60, 162, 273, 23);
		contentPane.add(btnCalculate);

		btnCalculate.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCalculate();
			}
		});
		
		txtOut = new JTextField();
		txtOut.setEditable(false);
		txtOut.setBounds(60, 196, 273, 20);
		contentPane.add(txtOut);
		txtOut.setColumns(10);
	}
	public void btnCalculate() {
		int numerator, denominator;
		String strNumerator = txtNumerator.getText();
		String strDenominator = txtDenominator.getText();
		if (intCheck(strNumerator) && intCheck(strDenominator)) {
			numerator = Integer.parseInt(strNumerator);
			denominator = Integer.parseInt(strDenominator);
			txtOut.setText(strNumerator+"/"+strDenominator+" in lowest terms is "+reduce(numerator, denominator));
		}
		else {
			txtOut.setText("Please enter an integer for numerator and denominator.");
		}
		
	}
	public String reduce (int numerator, int denominator)  {
		int gcd = gcd(numerator, denominator);
		if (denominator/gcd==1)
			return ""+numerator/gcd;
		return ""+numerator/gcd+"/"+denominator/gcd;
	
	}
	public int gcd(int a, int b) {
		int min = Math.min(a, b);
		int gcd=1;
		for (int i =1; i<=min; i++) {
			if (a%i==0 && b%i==0) {
				gcd=i;
			}
		}
		return gcd;
	}
	static public boolean intCheck(String in){
		int x = 0;
		try {
			x = Integer.parseInt(in);
			return true;
		}
		catch (Exception e ) {
			return false;
		}
	}


}
