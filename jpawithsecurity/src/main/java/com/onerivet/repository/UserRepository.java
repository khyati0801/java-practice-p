package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onerivet.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
