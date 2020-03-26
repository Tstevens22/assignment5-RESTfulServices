package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class OrdersRestService {

	@Inject
	OrdersBusinessInterface bs;

	// gets all orders and display them in json format
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)

	public List<Order> getOrdersAsJson() {
		return bs.getOrders();
	}

	// gets all orders and display them in XML format
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)

	public Order[] getOrdersAsXML() {
		List<Order> orders = bs.getOrders();
		return orders.toArray(new Order[orders.size()]);
	}

}
