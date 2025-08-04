package tw.brad.spring6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.spring6.entity.Employee;
import tw.brad.spring6.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping("/employee/query/{start}")
	public ResponseEntity<List<Employee>> findByTitle(@PathVariable String start) {
		
		List<Employee> employees = repository.findByTitleStartingWith(start);
		
		return ResponseEntity.ok(employees);
	}
	
}
