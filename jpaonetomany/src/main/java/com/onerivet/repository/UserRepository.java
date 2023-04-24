package com.onerivet.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onerivet.enitity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="SELECT u.name,u.age,u.address FROM User u JOIN u.address a WHERE u.id=:id")
	public Map<String,String> getUserdetailsByid(int id);
}
