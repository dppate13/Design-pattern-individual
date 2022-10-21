import java.io.*;

class Facade {
	private Product theSelectProduct = null;
	private int nProductCategory = 0;
	ClassProductList theProductList;
	private Person thePerson;

	Facade() {
	}

	static boolean Login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.GetUserName();
		userinfoItem.UserType = login.GetUserType();
		return login.isExit();
	}

	/*
	 // When the add button of the ProductMenu is clicked, call this function.
	 * Function will make a new trading fill that required information.
	 */

	void AddTrading(Product theProduct) {
		TradingMenu theTradingMenu;
		if (thePerson.type == 0)
		{
			theTradingMenu = new BuyerTradingMenu();
		} else {
			theTradingMenu = new SellerTradingMenu();
		}
		Trading theTrading = new Trading();
		theTradingMenu.ShowMenu(theTrading, thePerson);
		theProduct.AddTrading(theTrading);
	}

	void ViewTrading(Trading theTrading) {
		TradingMenu theTradingMenu;
		if (thePerson.type == 0)
		{
			theTradingMenu = new BuyerTradingMenu();
		} else {
			theTradingMenu = new SellerTradingMenu();
		}

		theTradingMenu.ShowMenu(theTrading, thePerson);
	}

	void Remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.GetProductList());
	}

	void CreateUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.TYPE_USER.Buyer)
		{
			thePerson = new Buyer();
		} else
		{
			thePerson = new Seller();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}

	/*
	 * create a product list and initialize it with ProductInfo.txt file
	 */
	void CreateProductList() {
		theProductList = new ClassProductList();
		theProductList.InitializeFromFile();
	}

	/*
	 * call this function after creating user, create productlist then read the
	 * UserProduct.txt file & match the productname with theProductList.
	 */
	void AttachProductToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserProduct.txt"));
			String aline, strUserName, strProductName;
			while ((aline = file.readLine()) != null) // not EOF
			{
				strUserName = GetUserName(aline);
				strProductName = GetProductName(aline);
				if (strUserName.compareTo(thePerson.UserName) == 0)
				{
					theSelectProduct = FindProductByProductName(strProductName);
					if (theSelectProduct != null)
					{
						thePerson.AddProduct(theSelectProduct);
					}
				}
			}
		} catch (Exception ignored) {
        }
	}

	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	private String GetProductName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1);
	}

	boolean SelectProduct() {
		ProductSelectDlg theDlg = new ProductSelectDlg();
		theSelectProduct = theDlg.ShowDlg(thePerson.ProductList);
		thePerson.CurrentProduct = theSelectProduct;
		nProductCategory = theDlg.nProductCategory;
		return theDlg.isLogout();
	}

	boolean ProductOperation() {
		thePerson.CreateProductMenu(theSelectProduct, nProductCategory);
		return thePerson.ShowMenu();//// 0: logout 1 select another product
	}

	private Product FindProductByProductName(String strProductName) {
		ProductIterator Iterator = new ProductIterator(theProductList);
		return (Product) Iterator.next(strProductName);
	}

}