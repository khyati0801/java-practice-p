package com.onerivet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onerivet.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByFirstName(String firstname);
	
	public List<Employee> findByLastName(String firstname);
	
	@Query(value="SELECT * FROM Employee_Details WHERE emp_city=?",nativeQuery = true)
	public List<Employee> findByCity(@Param("city")String city);

}
