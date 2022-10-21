import java.awt.*;

class ProduceProductMenu extends ProductMenu {

	ProduceProductMenu() {
	}

    void ShowAddButton() {
		TradingAddButton.addActionListener(e -> TradingAddButton_actionPerformed());
		TradingAddButton.setText("Add");
		TradingAddButton.setBounds(new Rectangle(390, 55, 80, 30));
		OptionAddButton.setText("Add");
		OptionAddButton.setBounds(new Rectangle(390, 125, 80, 30));
		this.getContentPane().add(TradingAddButton, null);
		this.getContentPane().add(OptionAddButton, null);
	}

	void ShowRadio() {
		TradingRadiao.setText("Trading");
		TradingRadiao.setBounds(new Rectangle(20, 55, 100, 26));
		this.getContentPane().add(TradingRadiao, null);
		OptionRadio.setText("ProduceExperiment");
		OptionRadio.setBounds(new Rectangle(20, 130, 100, 26));
		this.getContentPane().add(OptionRadio, null);
	}

	void ShowCombox() {
		TradingCombox.setBounds(new Rectangle(160, 56, 126, 22));
		OptionCombo.setBounds(new Rectangle(160, 130, 126, 22));
		this.getContentPane().add(TradingCombox, null);
		this.getContentPane().add(OptionCombo, null);
		refresh();
	}

	void ShowViewButton() {
		TradingViewButton.setText("View");
		TradingViewButton.setBounds(new Rectangle(290, 52, 79, 29));
		TradingViewButton.addActionListener(e -> TradingViewButton_actionPerformed());
		OptionViewButton.setText("View");
		OptionViewButton.setBounds(new Rectangle(290, 125, 79, 29));
		this.getContentPane().add(TradingViewButton, null);
		this.getContentPane().add(OptionViewButton, null);
	}

}