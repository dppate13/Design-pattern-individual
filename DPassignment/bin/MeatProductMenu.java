import java.awt.*;

class MeatProductMenu extends ProductMenu {

	MeatProductMenu() {
	}

    void ShowAddButton() {
		TradingAddButton.addActionListener(e -> TradingAddButton_actionPerformed());
		TradingAddButton.setText("Add");
		TradingAddButton.setBounds(new Rectangle(400, 55, 80, 30));
		OptionAddButton.setText("Add");
		OptionAddButton.setBounds(new Rectangle(390, 125, 80, 30));
		this.getContentPane().add(TradingAddButton, null);
		this.getContentPane().add(OptionAddButton, null);
	}

	void ShowRadio() {
		TradingRadiao.setText("Trading");
		TradingRadiao.setBounds(new Rectangle(21, 55, 105, 26));
		this.getContentPane().add(TradingRadiao, null);
		OptionRadio.setText("Meat Presentation");
		OptionRadio.setBounds(new Rectangle(21, 130, 105, 26));
		this.getContentPane().add(OptionRadio, null);
	}

	void ShowCombox() {
		TradingCombox.setBounds(new Rectangle(140, 57, 126, 22));
		OptionCombo.setBounds(new Rectangle(140, 130, 126, 22));
		this.getContentPane().add(TradingCombox, null);
		this.getContentPane().add(OptionCombo, null);
		refresh();
	}

	void ShowViewButtons() {
		TradingViewButton.setText("View");
		OptionViewButton.setText("View");
		TradingViewButton.setBounds(new Rectangle(290, 55, 80, 30));
		TradingViewButton.addActionListener(e -> TradingViewButton_actionPerformed());

		OptionViewButton.setBounds(new Rectangle(290, 125, 80, 30));
		this.getContentPane().add(TradingViewButton, null);
		this.getContentPane().add(OptionViewButton, null);
	}

}