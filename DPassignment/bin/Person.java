import java.util.*;


abstract public class Person {
	// type=0 : buyer
	// type=1 seller
	int type = 0;
	String UserName;
	Product CurrentProduct;
	ClassProductList ProductList;
	ProductMenu theProductMenu;


	Person() {
		ProductList = new ClassProductList();
	}

	abstract public void CreateProductMenu(Product theProduct, int theCategory);

	void showAddButton() {
		theProductMenu.ShowAddButton();
	}

	void showViewButtons() {
		theProductMenu.ShowViewButtons();
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

	// show the trading list
	public boolean ShowMenu() {
		// iterator for the trading list

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