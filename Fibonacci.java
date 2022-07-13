/* Fibonacci
* @modified 20220617
* @date 20220617
* @author Lorrin Shen
* @version 1.0
* @See ICS4U1
* 
* Find the number at the given fibonacci sequence term
**/
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Fibonacci extends JFrame {

	private JPanel contentPane;
	private JTextField txtTerm;
	private JTextField txtOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fibonacci frame = new Fibonacci();
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
	public Fibonacci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fibonacci Numbers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(116, 11, 217, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The first nine fibonacci numbers are listed as follows:");
		lblNewLabel_1.setBounds(67, 53, 322, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1, 1, 2, 3, 5, 8, 13, 21, 34");
		lblNewLabel_2.setBounds(78, 78, 255, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter the fibonacci term that you would like to see");
		lblNewLabel_3.setBounds(69, 106, 303, 14);
		contentPane.add(lblNewLabel_3);
		
		txtTerm = new JTextField();
		txtTerm.setBounds(195, 131, 86, 20);
		contentPane.add(txtTerm);
		txtTerm.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Term Number: ");
		lblNewLabel_4.setBounds(78, 131, 98, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnCalculate = new JButton("Find the Fibonacci number");
		btnCalculate.setBounds(103, 159, 192, 23);
		contentPane.add(btnCalculate);
		
		btnCalculate.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCalculate();
			}
		});
		
		txtOut = new JTextField();
		txtOut.setEditable(false);
		txtOut.setBounds(78, 205, 255, 20);
		contentPane.add(txtOut);
		txtOut.setColumns(10);
	}
	public void btnCalculate() {
		int fibTerm;
		String out;
		String in = txtTerm.getText();
		
		if (intCheck(in)) {
			fibTerm = Integer.parseInt(in);
			txtOut.setText("Fibonacci number "+fibTerm+" is "+fibonacci(fibTerm)+".");
		}
		else {
			txtOut.setText("Please enter an integer.");
		}
	}
	public int fibonacci(int in)  {
	    if(in == 0)
	        return 0;
	    else if(in == 1)
	      return 1;
	   else
	      return fibonacci(in - 1) + fibonacci(in - 2);
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
