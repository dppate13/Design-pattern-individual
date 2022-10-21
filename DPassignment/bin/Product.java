import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Product {
  private String ProductName;
  ArrayList<Trading> tradingList= new ArrayList<>();

  protected String productName;
  protected int tradCount;
  protected int productCategory;


  public Product(String strProduct, int theCategory) {
    this.ProductName = strProduct;
    this.productCategory = theCategory;
    this.tradCount = 0;

  }

  public String toString()
  {

    return ProductName;
  }
  void AddTrading(Trading newTra)
  {

    tradingList.add(newTra);
  }
  public ArrayList<Trading> getTradingList() {

    return tradingList;
  }
  void accept(NodeVisitor visitor)
  {

    visitor.visitProduct(this);
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setTradingList(ArrayList<Trading> tradingList) {
    this.tradingList = tradingList;
  }

  public void addTrading(Trading newTra) {
    getTradingList().add(newTra);
  }

  public int getTradCount() {
    return tradCount;
  }

  public void setTradCount(int tradCount) {
    this.tradCount = tradCount;
  }

}