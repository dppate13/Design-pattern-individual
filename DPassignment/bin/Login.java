import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;

class Login extends JDialog {

	private boolean Exit = false;
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JButton loginButton = new JButton();
	private JButton buttonExit = new JButton();
	private JTextField UserNameText = new JTextField();
	private JPasswordField PasswordField = new JPasswordField();
	private JRadioButton BuyerField = new JRadioButton();
	private JRadioButton SellerField = new JRadioButton();
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private String UserBox = null;
	private UserInfoItem.TYPE_USER UserType = UserInfoItem.TYPE_USER.Buyer;

	Login() {
		try {
			jbInit();
			setSize(500, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		this.getContentPane().setLayout(null);
		jLabel1.setText("Username");
		jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(26, 119, 80, 18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(32, 210, 85, 30));
		loginButton.addActionListener(this::loginButton_actionPerformed);
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(180, 210, 85, 30));
		buttonExit.addActionListener(e -> buttonExit_actionPerformed());
		UserNameText.setBounds(new Rectangle(120, 50, 145, 20));
		PasswordField.setBounds(new Rectangle(120, 120, 145, 20));
		BuyerField.setSelected(true);
		BuyerField.setText("Buyer");
		BuyerField.setBounds(new Rectangle(40, 160, 100, 30));
		SellerField.setText("Seller");
		SellerField.setBounds(new Rectangle(180, 170, 100, 30));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(UserNameText, null);
		this.getContentPane().add(PasswordField, null);
		this.getContentPane().add(BuyerField, null);
		this.getContentPane().add(SellerField, null);
		buttonGroup1.add(BuyerField);
		buttonGroup1.add(SellerField);
	}

	private void loginButton_actionPerformed(ActionEvent e) {
		BufferedReader file;
		Exit = false;
		System.out.println("Login was tapped");
		try {
			if (BuyerField.isSelected())
			{
				UserType = UserInfoItem.TYPE_USER.Buyer;
				file = new BufferedReader(new FileReader("BuyerInfo.txt"));
			} else// seller
			{
				UserType = UserInfoItem.TYPE_USER.Seller;
				file = new BufferedReader(new FileReader("SellerInfo.txt"));
			}
			UserBox = UserNameText.getText();
			String PasswordBox = new String(PasswordField.getPassword());
			String LoginName = null;
			String aline, UserName, Password;
			while ((aline = file.readLine()) != null) {
				UserName = GetUserName(aline);
				Password = GetPassword(aline);
				if (UserName.compareTo(UserBox) == 0 && Password.compareTo(PasswordBox) == 0)
					LoginName = UserName;
			}
			if (LoginName != null) {
				this.dispose();
			}
		} catch (Exception ignored) {
		}

	}

	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	private String GetPassword(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1);
	}

	String GetUserName() {
		return UserBox;
	}

	UserInfoItem.TYPE_USER GetUserType() {
		return UserType;
	}

	boolean isExit() {
		return Exit;
	}

	private void buttonExit_actionPerformed() {
		Exit = true;
		dispose();
	}
}