package tw.brad.spring6.entity;

import java.util.Objects;

public class OrderDetailPK {
	private Long orderId;
	private Long productId;
	
	@Override
	public int hashCode() {
		return Objects.hash(orderId,productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (!(obj instanceof OrderDetailPK)) return false;
		OrderDetailPK other = (OrderDetailPK)obj;
		return orderId == other.orderId && productId == other.productId;
	}
	
	
}
