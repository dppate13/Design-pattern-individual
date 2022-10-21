import java.util.*;
/*
 1. In this class we will iterate the product list attached on buyer and in turn
    iterate the tradings of a product.
 2. After Function Visit(ProductList) it will point to the location before the fist class,
 	hasNext will return weather there is next item or not.
 3. next() will return the next item trading
 */

public class ReminderVisitor extends NodeVisitor {
	private Reminder m_Reminder;

	ReminderVisitor(Reminder reminder) {
		m_Reminder = reminder;
	}

	public void visitFacade(Facade facade) {
		ProductIterator productList = new ProductIterator(facade.theProductList);
		while (productList.hasNext()) {
			Product product = (Product) productList.next();
			product.accept(this);
		}
	}

	public void visitProduct(Product product) {
		for (Trading trading : product.tradingList) {
			trading.accept(this);
		}
	}

	public void visitTrading(Trading trading) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(trading.DueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday)
		{
			m_Reminder.listUpcoming.add("today is " + today.toString() + " " + trading.TraName + " Due Date is "
					+ trading.getDueDateString());
		}
		if (nDueDate < ntoday) {
			m_Reminder.listOverdue.add(trading.TraName + " Due Date is " + trading.getDueDateString());
		}

	}

}