import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class BuyerTradingMenu extends TradingMenu {

	private boolean boolSubmit = false;
    private JLabel lTradingName = new JLabel();
	private JLabel lDueDate = new JLabel();
	private JTextField tbOffering = new JTextField();
	private JLabel lSuggestedOffering = new JLabel();
	private JLabel lView = new JLabel();
	private JButton bSubmit = new JButton();
	private JButton bCancel = new JButton();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel3 = new JLabel();
	private JLabel jLabel5 = new JLabel();
	private JLabel jLabel6 = new JLabel();
	private JLabel jLabel7 = new JLabel();

	BuyerTradingMenu() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		jLabel1.setText("Trading : ");
		jLabel1.setBounds(new Rectangle(20, 36, 91, 18));
		this.getContentPane().setLayout(null);
		lTradingName.setText("jLabel2");
		lTradingName.setBounds(new Rectangle(260, 35, 280, 20));
		jLabel3.setText("Due Date");
		jLabel3.setBounds(new Rectangle(20, 80, 90, 20));
		lDueDate.setText("jLabel4");
		lDueDate.setBounds(new Rectangle(255, 80, 295, 20));
		jLabel5.setText("Offering");
		jLabel5.setBounds(new Rectangle(25, 130, 90, 20));
		tbOffering.setText("jTextField1");
		tbOffering.setBounds(new Rectangle(250, 130, 210, 20));
		jLabel6.setText("Suggested Offering");
		jLabel6.setBounds(new Rectangle(25, 175, 120, 20));
		jLabel7.setText("View");
		jLabel7.setBounds(new Rectangle(20, 225, 40, 20));
		lSuggestedOffering.setText("jLabel8");
		lSuggestedOffering.setBounds(new Rectangle(260, 170, 200, 20));
		lView.setText("jLabel9");
		lView.setBounds(new Rectangle(260, 230, 40, 20));
		bSubmit.setText("Submit");
		bSubmit.setBounds(new Rectangle(475, 120, 80, 30));
		bSubmit.addActionListener(e -> bSubmit_actionPerformed());
		bCancel.setText("Cancel");
		bCancel.setBounds(new Rectangle(475, 165, 80, 80));
		bCancel.addActionListener(e -> bCancel_actionPerformed());
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel3, null);
		this.getContentPane().add(jLabel5, null);
		this.getContentPane().add(jLabel6, null);
		this.getContentPane().add(lTradingName, null);
		this.getContentPane().add(lDueDate, null);
		this.getContentPane().add(tbOffering, null);
		this.getContentPane().add(jLabel7, null);
		this.getContentPane().add(lSuggestedOffering, null);
		this.getContentPane().add(lView, null);
		this.getContentPane().add(bSubmit, null);
		this.getContentPane().add(bCancel, null);
	}

	/*
	 * check if the buyer has an offering or not.
	 * if there is no offer create a new offering for the buyer.
	 */
	public void ShowMenu(Trading trading, Person thePerson) {
		OfferingIterator theIter = trading.GetOfferingIterator();
		Offering theOffering = (Offering) theIter.next(thePerson.UserName);
		if (theOffering == null) {
			tbOffering.setText("");
			lView.setText("-1");
		} else {
			tbOffering.setText(theOffering.OfferingFileName);
			lView.setText(theOffering.getViewString());
		}

		lTradingName.setText(trading.TraName);
		lDueDate.setText(trading.DueDate.toString());
		lSuggestedOffering.setText(trading.SuggestOffering.OfferingFileName);

		setVisible(true);

		if (boolSubmit) {
			if (theOffering == null) {
				theOffering = new Offering();
				trading.AddOffering(theOffering);
			}
			theOffering.theAuthor = thePerson.UserName;
			theOffering.OfferingFileName = tbOffering.getText();
			theOffering.theSubmitData = new Date();
		}
	}

	private void bSubmit_actionPerformed() {
		boolSubmit = true;
		dispose();
	}

	private void bCancel_actionPerformed() {
		boolSubmit = false;
		dispose();
	}

}