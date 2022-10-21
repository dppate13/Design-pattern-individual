
public class PtbsMainClass {

	static Facade theFacade = new Facade();

	public PtbsMainClass() {
	}

	public static void main(String[] args) {

		UserInfoItem userinfoitem = new UserInfoItem();
		theFacade.CreateProductList();
		while (true) {
			boolean bExit;
			bExit = Facade.Login(userinfoitem);
			if (bExit)
				break;
			theFacade.CreateUser(userinfoitem);
			theFacade.AttachProductToUser();
			if (userinfoitem.UserType == UserInfoItem.TYPE_USER.Buyer)
				theFacade.Remind();
			boolean bLogout = false;
			while (!bLogout) {
				bLogout = theFacade.SelectProduct();
				if (bLogout)
					break;
				bLogout = theFacade.ProductOperation();
			}
		}
	}
}