package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Order")
public class Order {

	String OrderNo = "";
	String productName = "";
	float price = 0;
	int quantity = 0;

	public Order(String OrderNo, String productName, float price, int quantity) {
		this.OrderNo = OrderNo;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;

	}

	public Order() {

	}

	public String getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
