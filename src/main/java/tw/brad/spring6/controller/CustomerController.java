package tw.brad.spring6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.spring6.dto.CustomerDTO;
import tw.brad.spring6.dto.OrderDTO;
import tw.brad.spring6.dto.OrderDetailDTO;
import tw.brad.spring6.entity.Customer;
import tw.brad.spring6.entity.Order;
import tw.brad.spring6.entity.OrderDetial;
import tw.brad.spring6.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/customer/v1/{id}")
	public ResponseEntity<Customer> test1(@PathVariable String id) {
		return ResponseEntity.ok(repository.findById(id).orElse(null));
	}
	
	@GetMapping("/customer/v2/{id}")
	public ResponseEntity<Customer> test2(@PathVariable String id) {
		return ResponseEntity.ok(repository.findByCustomerIdWithOrders(id).orElse(null));
	}

	@GetMapping("/customer/v3/{id}")
	public ResponseEntity<CustomerDTO> test3(@PathVariable String id) {
		Customer c = repository.findById(id).orElse(null);
		
		ArrayList<OrderDTO> oDTO = new ArrayList<OrderDTO>();
		
		List<Order> orders = c.getOrders();
		for (Order order : orders) {
			ArrayList<OrderDetailDTO> dDTO = new ArrayList<OrderDetailDTO>();
			for (OrderDetial detail : order.getOrderDetails()) {
				OrderDetailDTO dto = new OrderDetailDTO(
						detail.getUnitPrice(), 
						detail.getQuantity(), 
						detail.getProduct().getProductName());
				dDTO.add(dto);
			}
			OrderDTO dto = new OrderDTO(
					order.getOrderId(), 
					order.getOrderDate(), 
					dDTO);
			oDTO.add(dto);
		}
		
		CustomerDTO cDTO = new CustomerDTO(c.getCustomerid(), c.getCompanyName(), oDTO);
		
		return ResponseEntity.ok(cDTO);
		
	}
	
	
}
