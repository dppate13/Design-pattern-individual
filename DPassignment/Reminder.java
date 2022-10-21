import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


class Reminder extends JDialog {
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	java.awt.List listUpcoming = new java.awt.List();
	java.awt.List listOverdue = new java.awt.List();
	private Button buttonOK = new Button();

	Reminder() {
		try {
			jbInit();
			setModal(true);
			setSize(400, 386);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		jLabel1.setText("Upcoming tradings");
		jLabel1.setBounds(new Rectangle(40, 40, 160, 20));
		this.getContentPane().setLayout(null);
		jLabel2.setText("OverDue Tradings");
		jLabel2.setBounds(new Rectangle(40, 160, 160, 20));
		listUpcoming.setBounds(new Rectangle(30, 65, 340, 80));
		listOverdue.setBounds(new Rectangle(30, 200, 335, 80));
		buttonOK.setLabel("OK");
		buttonOK.setBounds(new Rectangle(150, 300, 70, 37));
		buttonOK.addActionListener(this::buttonOK_actionPerformed);
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(listUpcoming, null);
		this.getContentPane().add(listOverdue, null);
		this.getContentPane().add(buttonOK, null);
	}

	void showReminder(ClassProductList products) {
		ReminderVisitor visitor = new ReminderVisitor(this);
		visitor.visitFacade(PtbsMainClass.theFacade);
		setVisible(true);
	}

	private void buttonOK_actionPerformed(ActionEvent e) {
		dispose();
	}
}