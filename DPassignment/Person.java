import java.util.*;


abstract public class Person {
	int type = 0; // type=0 : buyer, type=1 seller
	String UserName;
	ClassProductList ProductList;
	ProductMenu theProductMenu;
	Product CurrentProduct;

	Person() {
		ProductList = new ClassProductList();
	}

	abstract public void CreateProductMenu(Product theProduct, int theCategory);

	void showAddButton() {
		theProductMenu.ShowAddButton();
	}

	void showViewButtons() {
		theProductMenu.ShowViewButton();
	}

	void showComboxes() {theProductMenu.ShowCombox();	}

	void showRadios() {
		theProductMenu.ShowRadio();
	}

	void show() {
		theProductMenu.setVisible(true);
	}

	boolean ifLogout() {
		return theProductMenu.ifLogout();
	}

	public boolean ShowMenu() {

		Iterator theIter = CurrentProduct.getTradingList().iterator();
		theProductMenu.theProduct = CurrentProduct;
		Trading theTrading;
		while (theIter.hasNext()) {
			theTrading = (Trading) theIter.next();
			theProductMenu.TradingCombox.addItem(theTrading);
		}
		return false;
	}

	ClassProductList GetProductList() {
		return ProductList;
	}

	void AddProduct(Product theProduct) {
		ProductList.add(theProduct);
	}
}