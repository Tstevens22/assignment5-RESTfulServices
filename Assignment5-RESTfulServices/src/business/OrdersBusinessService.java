package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
public class OrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders = new ArrayList<Order>();

	@Override
	public void test() {

		System.out.println("===== Hello from the business servcie =====");

	}

	public OrdersBusinessService() {
		orders.add(new Order("000", "This is product 1", (float) 1.00, 1));
		orders.add(new Order("001", "This is product 2", (float) 2.00, 2));
		orders.add(new Order("002", "This is product 3", (float) 3.00, 3));
		orders.add(new Order("003", "This is product 4", (float) 4.00, 4));
		orders.add(new Order("004", "This is product 5", (float) 5.00, 5));
		orders.add(new Order("005", "This is product 6", (float) 6.00, 6));
		orders.add(new Order("006", "This is product 7", (float) 7.00, 7));
		orders.add(new Order("007", "This is product 8", (float) 8.00, 8));
		orders.add(new Order("008", "This is product 9", (float) 9.00, 9));
		orders.add(new Order("009", "This is product 10", (float) 10.00, 10));
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		this.orders = orders;
	}

}
