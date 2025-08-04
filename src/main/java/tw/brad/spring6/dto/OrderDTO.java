package tw.brad.spring6.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
	private Long orderId;
	private Date orderDate;
	private List<OrderDetailDTO> details;
	
	public OrderDTO(
			Long orderId,
			Date orderDate,
			List<OrderDetailDTO> details
			) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.details = details;
	}
	
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderDetailDTO> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetailDTO> details) {
		this.details = details;
	}
	
	
	
	
}
