package loanassistant;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.*;

public class LoanAssistant extends JFrame{
	private static final long serialVersionUID = 1L;
	JButton computeButton, newLoanButton, monthsButton, paymentButton, exitButton, balanceButton, interestButton;
	JTextArea analysisTextArea;
	JLabel balanceLabel, interestLabel, monthsLabel, paymentLabel, analysisLabel; 
	JTextField balanceTextField, interestTextField, monthsTextField, paymentTextField;
	JScrollPane scroll;
	Color lightYellow = new Color(255, 255, 128);
	boolean computePayment, computeBalance, computeMonths, computeInterest;

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// create frame
		new LoanAssistant().show();
	}

	public LoanAssistant() {
		// frame constructor
		setTitle("Loan Assistant");
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitForm(e);
			}
		});
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints;
		
		balanceLabel = new JLabel();
		balanceTextField = new JTextField();
		interestLabel = new JLabel();
		interestTextField = new JTextField();
		monthsLabel = new JLabel();
		monthsTextField = new JTextField();
		paymentLabel = new JLabel();
		paymentTextField = new JTextField();
		computeButton = new JButton();
		newLoanButton = new JButton();
		monthsButton = new JButton();
		paymentButton = new JButton();
		balanceButton = new JButton();
		interestButton = new JButton();
		analysisLabel = new JLabel();
		analysisTextArea = new JTextArea();
		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		exitButton = new JButton();
		
		// declaring a standard font
		Font myFont = new Font("Arial", Font.PLAIN, 16);
		
		balanceLabel.setText("Loan Balance");
		balanceLabel.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.insets = new Insets(10, 10, 0, 0);
		getContentPane().add(balanceLabel, gridConstraints);
		
		balanceTextField.setPreferredSize(new Dimension(100, 25));
		balanceTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		balanceTextField.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		gridConstraints.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(balanceTextField, gridConstraints);
		balanceTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				balanceTextFieldActionPerformed(e);
			}
		});
		
		interestLabel.setText("Interest Rate");
		interestLabel.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.insets = new Insets(10, 10, 0, 0);
		getContentPane().add(interestLabel, gridConstraints);
		
		interestTextField.setPreferredSize(new Dimension(100, 25));
		interestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		interestTextField.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(interestTextField, gridConstraints);
		interestTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				interestTextFieldActionPerformed(e);
			}
		});
		
		monthsLabel.setText("Number of Payments");
		monthsLabel.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.insets = new Insets(10, 10, 0, 0);
		getContentPane().add(monthsLabel, gridConstraints);
		
		monthsTextField.setPreferredSize(new Dimension(100, 25));
		monthsTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		monthsTextField.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		gridConstraints.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(monthsTextField, gridConstraints);
		monthsTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				monthsTextFieldActionPerformed(e);
			}
		});
		
		paymentLabel.setText("Monthly Payment");
		paymentLabel.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 3;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.insets = new Insets(10, 10, 0, 0);
		getContentPane().add(paymentLabel, gridConstraints);
		
		paymentTextField.setPreferredSize(new Dimension(100, 25));
		paymentTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		paymentTextField.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		gridConstraints.insets = new Insets(10, 10, 0, 10);
		getContentPane().add(paymentTextField, gridConstraints);
		paymentTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentTextFieldActionPerformed(e);
			}
		});
		
		computeButton.setText("Compute Monthly Payment");
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 4;
		gridConstraints.gridwidth = 2;
		gridConstraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(computeButton, gridConstraints);
		computeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				computeButtonActionPerformed(e);
			}
		});
		
		newLoanButton.setText("New Loan Analysis");
		newLoanButton.setEnabled(false);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 5;
		gridConstraints.gridwidth = 2;
		gridConstraints.insets = new Insets(10, 0, 10, 0);
		getContentPane().add(newLoanButton, gridConstraints);
		newLoanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newLoanButtonActionPerformed(e);
			}
		});
		
		balanceButton.setText("X");
		balanceButton.setFocusable(false);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		gridConstraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(balanceButton, gridConstraints);
		balanceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				balanceButtonActionPerformed(e);
			}
		});
		
		interestButton.setText("X");
		interestButton.setFocusable(false);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 1;
		gridConstraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(interestButton, gridConstraints);
		interestButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				interestButtonActionPerformed(e);
			}
		});
		
		monthsButton.setText("X");
		monthsButton.setFocusable(false);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 2;
		gridConstraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(monthsButton, gridConstraints);
		monthsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				monthsButtonActionPerformed(e);
			}
		});
		
		paymentButton.setText("X");
		paymentButton.setFocusable(false);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 3;
		gridConstraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(paymentButton, gridConstraints);
		paymentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paymentButtonActionPerformed(e);
			}
		});
		
		analysisLabel.setText("Loan Analysis:");
		analysisLabel.setFont(myFont);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.insets = new Insets(0, 10, 0, 0);
		getContentPane().add(analysisLabel, gridConstraints);
		
		analysisTextArea.setFocusable(false);
		analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		analysisTextArea.setEditable(false);
		analysisTextArea.setBackground(Color.WHITE);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 1;
		gridConstraints.gridheight = 4;
		gridConstraints.insets = new Insets(0, 10, 0, 10);
		scroll.setPreferredSize(new Dimension(250, 150));
		scroll.setFocusable(false);
		scroll.getViewport().setBackground(Color.WHITE);
		scroll.getViewport().add(analysisTextArea);
		getContentPane().add(scroll, gridConstraints);
		
		exitButton.setText("Exit");
		exitButton.setFocusable(false);
		gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 5;
		getContentPane().add(exitButton, gridConstraints);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exitButtonActionPerformed(e);
			}
		});
		
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((int)(0.5 * (screenSize.width - getWidth())), (int)(0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
		
		paymentButton.doClick();
	}
	
	private void exitForm(WindowEvent e) {
		System.exit(0);
	}
	
	private void computeButtonActionPerformed(ActionEvent e) {
		double balance, interest, payment;
		int months;
		double monthlyInterest, multiplier;
		double loanBalance, finalPayment;
		Calendar calendar = Calendar.getInstance();
		
		if (computePayment) {
			// Compute loan payment
			if (validateDecimalNumber(balanceTextField))
				balance = Double.valueOf(balanceTextField.getText()).doubleValue();
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (validateDecimalNumber(monthsTextField)) {
				months = Integer.valueOf(monthsTextField.getText()).intValue();
				if (months > 300) {
					if (JOptionPane.showConfirmDialog(null, "Maximum number of payments must be 300.\nDo you want to use this maximum value?", "Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						monthsTextField.setText(String.valueOf(300));
						months = 300;
					} else {
						monthsTextField.requestFocus();
						return;
					}
				}
			}
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (validateDecimalNumber(interestTextField))
				interest = Double.valueOf(interestTextField.getText()).doubleValue();
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			monthlyInterest = interest / 1200;
			if (interest == 0)
				payment = balance / months;
			else {
				multiplier = Math.pow(1 + monthlyInterest, months);
				payment = balance * monthlyInterest * multiplier / (multiplier - 1);
			}
			paymentTextField.setText(new DecimalFormat("0.00").format(payment));
		} else if (computeMonths){
			// Compute number of payments
			if (validateDecimalNumber(balanceTextField))
				balance = Double.valueOf(balanceTextField.getText()).doubleValue();
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (validateDecimalNumber(interestTextField))
				interest = Double.valueOf(interestTextField.getText()).doubleValue();
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			monthlyInterest = interest / 1200;
			if (validateDecimalNumber(paymentTextField)) {
				multiplier = Math.pow(1 + monthlyInterest, 300);
				double minimumPayment = balance * monthlyInterest * multiplier / (multiplier - 1);
				payment = Double.valueOf(paymentTextField.getText()).doubleValue();
				if (payment < minimumPayment) {
					if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" + new DecimalFormat("0.00").format((int)(minimumPayment)) + "\nDo you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						paymentTextField.setText(new DecimalFormat("0.00").format((int)(minimumPayment)));
						payment = minimumPayment;
					} else {
						paymentTextField.requestFocus();
						return;
					}
				}
			} else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (interest == 0)
				months = (int)(balance / payment);
			else
				months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) / Math.log(1 + monthlyInterest));
			monthsTextField.setText(String.valueOf(months));
		} else if (computeInterest) {
			// Compute interest
			if (validateDecimalNumber(balanceTextField))
				balance = Double.valueOf(balanceTextField.getText()).doubleValue();
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (validateDecimalNumber(monthsTextField)) {
				months = Integer.valueOf(monthsTextField.getText()).intValue();
				if (months > 300) {
					if (JOptionPane.showConfirmDialog(null, "Maximum number of payments must be 300.\nDo you want to use this maximum value?", "Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						monthsTextField.setText(String.valueOf(300));
						months = 300;
					} else {
						monthsTextField.requestFocus();
						return;
					}
				}
			}
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (validateDecimalNumber(paymentTextField))
				payment = Double.valueOf(paymentTextField.getText()).doubleValue();
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (balance == payment * months)
				interest = 0;
			else {
				double i;
				for (i = 0.0001; payment / (payment - i * balance) < Math.pow(1 + i, months); i += 0.0001);
				interest = 1200 * i;
			}
			interestTextField.setText(new DecimalFormat("0.00").format(interest));
		} else {
			// Compute balance
			if (validateDecimalNumber(monthsTextField)) {
				months = Integer.valueOf(monthsTextField.getText()).intValue();
				if (months > 300) {
					if (JOptionPane.showConfirmDialog(null, "Maximum number of payments must be 300.\nDo you want to use this maximum value?", "Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						monthsTextField.setText(String.valueOf(300));
						months = 300;
					} else {
						monthsTextField.requestFocus();
						return;
					}
				}
			}
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (validateDecimalNumber(paymentTextField))
				payment = Double.valueOf(paymentTextField.getText()).doubleValue();
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if (validateDecimalNumber(interestTextField))
				interest = Double.valueOf(interestTextField.getText()).doubleValue();
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			monthlyInterest = interest / 1200;
			if (interest == 0)
				balance = payment * months;
			else {
				multiplier = Math.pow(1 + monthlyInterest, months);
				balance = payment * (multiplier - 1) / monthlyInterest / multiplier;
			}
			balanceTextField.setText(new DecimalFormat("0.00").format(balance));
		}
		// reset payment prior to analysis to fix at two decimals
		payment = Double.valueOf(paymentTextField.getText()).doubleValue();
		// show analysis
		calendar.add(Calendar.MONTH, months);
		analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(balance));
		analysisTextArea.append("\nInterest Rate: " + new DecimalFormat("0.00").format(interest) + "%");
		if (computeBalance) {
			analysisTextArea.append("\n\nMonthly Balance decrease: $" + new DecimalFormat("0.00").format(payment));
			analysisTextArea.append("\n" + String.valueOf(months) + " Payments of $" + new DecimalFormat("0.00").format(payment));
			analysisTextArea.append("\nTotal Payments: $" + new DecimalFormat("0.00").format(months * payment));
			analysisTextArea.append("\nMonthly Interest $" + new DecimalFormat("0.00").format((months * payment - balance) / months));
			analysisTextArea.append("\nTotal Interest $" + new DecimalFormat("0.00").format(months * payment - balance));
		} else {
			// process all but last payment
			loanBalance = balance;
			for (int paymentNumber = 1; paymentNumber < months; paymentNumber++)
				loanBalance += loanBalance * (interest / 1200) - payment;
			// find final payment
			finalPayment = loanBalance;
			if (finalPayment > payment) {
				// apply one more payment
				loanBalance += loanBalance * (interest / 1200) - payment;
				finalPayment = loanBalance;
				months++;
				monthsTextField.setText(String.valueOf(months));
			}
			analysisTextArea.append("\n\nMonthly balance decrease: $" + new DecimalFormat("0.00").format(payment));
			analysisTextArea.append("\n" + String.valueOf(months - 1) + " Payments of $" + new DecimalFormat("0.00").format(payment));
			analysisTextArea.append("\nFinal Payment of: $" + new DecimalFormat("0.00").format(finalPayment));
			analysisTextArea.append("\nTotal Payments: $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
			analysisTextArea.append("\nMonthly Interest $" + new DecimalFormat("0.00").format(((months - 1) * payment + finalPayment - balance) / months));
			analysisTextArea.append("\nTotal Interest $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
		}
		analysisTextArea.append("\nBalance paid off at: " + calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR));
		computeButton.setEnabled(false);
		newLoanButton.setEnabled(true);
		newLoanButton.requestFocus();
	}
	
	private void newLoanButtonActionPerformed(ActionEvent e) {
		// clear computed value and analysis
		if (computePayment)
			paymentTextField.setText("");
		else if (computeMonths)
			monthsTextField.setText("");
		else if (computeBalance)
			balanceTextField.setText("");
		else if (computeInterest)
			interestTextField.setText("");
		analysisTextArea.setText("");
		computeButton.setEnabled(true);
		newLoanButton.setEnabled(false);
		if (!computeBalance)
			balanceTextField.requestFocus();
		else
			interestTextField.requestFocus();
	}
	
	private void balanceButtonActionPerformed(ActionEvent e) {
		// will compute balance
		computeBalance = true;
		computeMonths = false;
		computePayment = false;
		computeInterest = false;
		paymentButton.setVisible(true);
		monthsButton.setVisible(true);
		interestButton.setVisible(true);
		balanceButton.setVisible(false);
		balanceTextField.setText("");
		balanceTextField.setEditable(false);
		balanceTextField.setBackground(lightYellow);
		balanceTextField.setFocusable(false);
		interestTextField.setEditable(true);
		interestTextField.setBackground(Color.WHITE);
		interestTextField.setFocusable(true);
		monthsTextField.setEditable(true);
		monthsTextField.setBackground(Color.WHITE);
		monthsTextField.setFocusable(true);
		paymentTextField.setEditable(true);
		paymentTextField.setBackground(Color.WHITE);
		paymentTextField.setFocusable(true);
		computeButton.setText("Compute Loan Balance");
		interestTextField.requestFocus();
	}
	
	private void interestButtonActionPerformed(ActionEvent e) {
		// will compute rate of interest
		computeInterest = true;
		computeBalance = false;
		computeMonths = false;
		computePayment = false;
		paymentButton.setVisible(true);
		monthsButton.setVisible(true);
		balanceButton.setVisible(true);
		interestButton.setVisible(false);
		interestTextField.setText("");
		interestTextField.setEditable(false);
		interestTextField.setBackground(lightYellow);
		interestTextField.setFocusable(false);
		balanceTextField.setEditable(true);
		balanceTextField.setBackground(Color.WHITE);
		balanceTextField.setFocusable(true);
		monthsTextField.setEditable(true);
		monthsTextField.setBackground(Color.WHITE);
		monthsTextField.setFocusable(true);
		paymentTextField.setEditable(true);
		paymentTextField.setBackground(Color.WHITE);
		paymentTextField.setFocusable(true);
		computeButton.setText("Compute Interest Rate");
		balanceTextField.requestFocus();
	}
	
	private void monthsButtonActionPerformed(ActionEvent e) {
		// will compute months
		computeMonths = true;
		computePayment = false;
		computeBalance = false;
		computeInterest = false;
		paymentButton.setVisible(true);
		balanceButton.setVisible(true);
		interestButton.setVisible(true);
		monthsButton.setVisible(false);
		monthsTextField.setText("");
		monthsTextField.setEditable(false);
		monthsTextField.setBackground(lightYellow);
		monthsTextField.setFocusable(false);
		balanceTextField.setEditable(true);
		balanceTextField.setBackground(Color.WHITE);
		balanceTextField.setFocusable(true);
		interestTextField.setEditable(true);
		interestTextField.setBackground(Color.WHITE);
		interestTextField.setFocusable(true);
		paymentTextField.setEditable(true);
		paymentTextField.setBackground(Color.WHITE);
		paymentTextField.setFocusable(true);
		computeButton.setText("Compute Number of Payments");
		balanceTextField.requestFocus();
	}
	
	private void paymentButtonActionPerformed(ActionEvent e) {
		// will compute payment
		computePayment = true;
		computeMonths = false;
		computeBalance = false;
		computeInterest = false;
		paymentButton.setVisible(false);
		monthsButton.setVisible(true);
		balanceButton.setVisible(true);
		interestButton.setVisible(true);
		monthsTextField.setEditable(true);
		monthsTextField.setBackground(Color.WHITE);
		monthsTextField.setFocusable(true);
		balanceTextField.setEditable(true);
		balanceTextField.setBackground(Color.WHITE);
		balanceTextField.setFocusable(true);
		interestTextField.setEditable(true);
		interestTextField.setBackground(Color.WHITE);
		interestTextField.setFocusable(true);
		paymentTextField.setText("");
		paymentTextField.setEditable(false);
		paymentTextField.setBackground(lightYellow);
		paymentTextField.setFocusable(false);
		computeButton.setText("Compute Monthly Payment");
		balanceTextField.requestFocus();
	}
	
	private void exitButtonActionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	private void balanceTextFieldActionPerformed(ActionEvent e) {
		balanceTextField.transferFocus();
	}
	
	private void interestTextFieldActionPerformed(ActionEvent e) {
		interestTextField.transferFocus();
	}
	
	private void monthsTextFieldActionPerformed(ActionEvent e) {
		monthsTextField.transferFocus();
	}
	
	private void paymentTextFieldActionPerformed(ActionEvent e) {
		paymentTextField.transferFocus();
	}
	
	public boolean validateDecimalNumber(JTextField textField) {
		/*checks to see if text field contains
		 * valid decimal number with only digits and a single decimal point*/
		String s = textField.getText().trim();
		boolean hasDecimal = false;
		boolean valid = true;
		if (s.isEmpty())
			valid = false;
		else {
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= '0' && c <= '9')
					continue;
				else if (c == '.' && !hasDecimal)
					hasDecimal = true;
				else
					//invalid character found
					valid = false;
			}
		}
		textField.setText(s);
		if (!valid)
			textField.requestFocus();
		return valid;
	}
}
