package business;

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersBusinessInterface {

	public List<Order> getOrders();
	public void setOrders(List<Order> orders);
	void test();
}
