package com.onerivet.Repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onerivet.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	@Query(value="SELECT e.firstName firstname,d.departmentName department FROM Employee e JOIN e.department d WHERE e.id=:id")
	public Map<String,String> getDepartmentDetailsByEmployeeId(int id);
	

}
