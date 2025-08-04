package tw.brad.spring6.dto;

import java.util.List;

public class CustomerDTO {
	private String customerID;
	private String companyName;
	private List<OrderDTO> orders;
	
	public CustomerDTO(
			String customerID,
			String companyName,
			List<OrderDTO> orders
			) {
		this.customerID = customerID;
		this.companyName = companyName;
		this.orders = orders;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<OrderDTO> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}
	
	
	
}
