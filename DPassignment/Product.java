import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Product {
  private String ProductName;
  ArrayList<Trading> tradingList= new ArrayList<>();

  protected int tradCount;
  protected String productCategory;

  protected String productName;


  public Product(String strProduct, String theCategory) {
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
  void accept(NodeVisitor visitor)
  {

    visitor.visitProduct(this);
  }

  public ArrayList<Trading> getTradingList() { return tradingList; }

  public void setTradingList(ArrayList<Trading> tradingList) { this.tradingList = tradingList; }

  public String getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getTradCount() {
    return tradCount;
  }

  public void setTradCount(int tradCount) {
    this.tradCount = tradCount;
  }

}
