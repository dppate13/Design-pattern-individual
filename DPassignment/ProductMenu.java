import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


abstract class ProductMenu extends JDialog
{
  Product theProduct;
  private boolean bLogout=true;

  JRadioButton TradingRadiao = new JRadioButton();
  JComboBox<Trading> TradingCombox = new JComboBox<>();
  JButton TradingViewButton = new JButton();
  JButton TradingAddButton = new JButton();
  JRadioButton OptionRadio = new JRadioButton();
  JComboBox OptionCombo = new JComboBox();
  JButton OptionViewButton = new JButton();
  JButton OptionAddButton = new JButton();
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
    setSize(503,294);
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
  abstract void ShowViewButton();
  abstract void ShowRadio();
  abstract void ShowCombox();

  void TradingAddButton_actionPerformed()
  {
    PtbsMainClass.theFacade.AddTrading(theProduct);
    refresh();
  }
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

  private void buttonChangeProduct_actionPerformed(ActionEvent e)
  {
    bLogout=false;
    dispose();
  }

  private void buttonLogout_actionPerformed(ActionEvent e)
  {
    bLogout=true;
    dispose();
  }
  boolean ifLogout()
  {
    return bLogout;
  }
}