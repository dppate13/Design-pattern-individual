public class Buyer extends Person {

	Buyer() {
		type = 0; // this is a buyer
	}

	public void CreateProductMenu(Product theProduct, int theCategory) {

		if (theCategory == 0) // 0 = Meat which is defined in productselectdlg
		{
			theProductMenu = new MeatProductMenu();
		} else // 1: Produce
		{
			theProductMenu = new ProduceProductMenu();
		}
	}

	@Override
	public boolean ShowMenu() {
		super.ShowMenu();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}