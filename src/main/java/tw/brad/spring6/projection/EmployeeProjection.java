package tw.brad.spring6.projection;

import java.util.List;

import tw.brad.spring6.entity.Order;

public interface EmployeeProjection {
	String getLastName();
	String getFirstName();
	List<Order> getOrders();
}
