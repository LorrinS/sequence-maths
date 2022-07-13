/* NChooseR
* @modified 20220617
* @date 20220617
* @author Lorrin Shen
* @version 1.0
* @See ICS4U1
* 
* Calculate the number of ways r objects can be chosen from a set of n objects.
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

public class NChooseR extends JFrame {

	private JPanel contentPane;
	private JTextField txtR;
	private JTextField txtN;
	private JTextField txtOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NChooseR frame = new NChooseR();
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
	public NChooseR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("n Choose r");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(226, 11, 141, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("this program calculates the number of ways r objects can be chosen from a set of n objects.");
		lblNewLabel_1.setBounds(32, 44, 576, 54);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the number of objects to choose: ");
		lblNewLabel_2.setBounds(32, 109, 309, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter the number of objects there are to choose from: ");
		lblNewLabel_3.setBounds(32, 153, 309, 14);
		contentPane.add(lblNewLabel_3);
		
		txtR = new JTextField();
		txtR.setBounds(351, 109, 86, 20);
		contentPane.add(txtR);
		txtR.setColumns(10);
		
		txtN = new JTextField();
		txtN.setBounds(351, 153, 86, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate the Number of Ways");
		btnCalculate.setBounds(170, 187, 229, 23);
		contentPane.add(btnCalculate);
		
		btnCalculate.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCalculate();
			}
		});
		
		
		txtOut = new JTextField();
		txtOut.setEditable(false);
		txtOut.setBounds(32, 243, 421, 20);
		contentPane.add(txtOut);
		txtOut.setColumns(10);
	}
	public void btnCalculate() {
		int n,r;
		String strN = txtN.getText();
		String strR = txtR.getText();
		
		if (intCheck(strN) && intCheck(strR)) {
			n = Integer.parseInt(strN);
			r = Integer.parseInt(strR);
			txtOut.setText("There are "+nchooser(n,r)+" ways.");
		}
		else {
			txtOut.setText("Please enter an integer for n and r.");
		}
	}
	public int nchooser (int n, int r)  {
		return factorial(n) / (factorial(r) * factorial(n - r));
	
	}
	int factorial(int n) {
		int out=n;
	    for (int i = (n-1); i>1 ; i--)
	        out *= i;
	    return out;
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
