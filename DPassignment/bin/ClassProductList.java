import java.util.ArrayList;
import java.io.*;


class ClassProductList extends ArrayList<Product> {

	ClassProductList() {
	}

	//// initialize the list from the file.
	void InitializeFromFile() {
		try {
			BufferedReader file;
			String strProductName;
			file = new BufferedReader(new FileReader("ProductInfo.txt"));
			while ((strProductName = file.readLine()) != null) {
				Product theProduct;
				theProduct = new Product(strProductName, 0);
				add(theProduct);
			}
		} catch (Exception ignored) {
        }
	}

}