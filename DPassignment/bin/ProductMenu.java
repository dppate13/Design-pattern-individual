import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


abstract class ProductMenu extends JDialog
{
  Product theProduct;
  private boolean bLogout=true;
  JButton TradingAddButton = new JButton();
  JRadioButton OptionRadio = new JRadioButton();
  JComboBox OptionCombo = new JComboBox();
  JRadioButton TradingRadiao = new JRadioButton();
  JComboBox<Trading> TradingCombox = new JComboBox<>();
  JButton TradingViewButton = new JButton();
  JButton OptionAddButton = new JButton();
  JButton OptionViewButton = new JButton();
  private JButton buttonChangeProduct = new JButton();
  private JButton buttonLogout = new JButton();

  ProductMenu()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    setModal(true);
    setSize(500,300);
  }

  private void jbInit() {
    buttonChangeProduct.setText("ChangeProduct");
    buttonChangeProduct.setBounds(new Rectangle(100, 210, 75, 40));
    buttonChangeProduct.addActionListener(this::buttonChangeProduct_actionPerformed);
    this.getContentPane().setLayout(null);
    this.setTitle("");
    buttonLogout.setText("logout");
    buttonLogout.setBounds(new Rectangle(265, 210, 75, 40));
    buttonLogout.addActionListener(this::buttonLogout_actionPerformed);
    this.getContentPane().add(buttonChangeProduct, null);
    this.getContentPane().add(buttonLogout, null);
  }

  abstract void ShowAddButton();
  abstract void ShowRadio();
  abstract void ShowCombox();
  abstract void ShowViewButtons();

  void TradingViewButton_actionPerformed()
  {
    Trading theTra=(Trading)TradingCombox.getSelectedItem() ;
    PtbsMainClass.theFacade.ViewTrading(theTra);
  }

  void refresh()
  {
    TradingCombox.removeAllItems() ;
    for (Trading trading : theProduct.tradingList) {
      TradingCombox.addItem(trading);
    }
  }
  void TradingAddButton_actionPerformed()
  {
    PtbsMainClass.theFacade.AddTrading(theProduct);
    refresh();
  }
  private void buttonLogout_actionPerformed(ActionEvent e)
  {
    bLogout=true;
    dispose();
  }
  private void buttonChangeProduct_actionPerformed(ActionEvent e)
  {
    bLogout=false;
    dispose();
  }

  boolean ifLogout()
  {
    return bLogout;
  }
}