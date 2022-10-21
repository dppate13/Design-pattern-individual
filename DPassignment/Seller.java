public class Seller extends Person {
	Seller() {
		type = 1;
	}

	public void CreateProductMenu(Product theProduct, int theCategory) {
		if (theCategory == 0)
		{
			theProductMenu = new MeatProductMenu();
		} else
		{
			theProductMenu = new ProduceProductMenu();
		}
	}

	public boolean ShowMenu() {
		super.ShowMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}