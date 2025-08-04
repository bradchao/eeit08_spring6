package tw.brad.spring6.dto;

import java.math.BigDecimal;

public class OrderDetailDTO {
	private BigDecimal unitPrice;
	private Integer quantity;
	private String productName;
	private Double total;
	
	public OrderDetailDTO(
			BigDecimal unitPrice,
			Integer quantity,
			String productName
			) {
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.productName = productName;
		this.total = unitPrice.doubleValue() * quantity;
	}
	
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
