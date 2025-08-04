package tw.brad.spring6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.brad.spring6.entity.Employee;
import tw.brad.spring6.projection.EmployeeProjection;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<EmployeeProjection> findByTitleStartingWith(String start);
}
