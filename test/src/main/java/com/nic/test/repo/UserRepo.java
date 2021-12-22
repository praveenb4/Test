package com.nic.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.nic.test.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String name); 	 
}
