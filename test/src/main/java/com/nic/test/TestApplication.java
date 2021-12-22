package com.nic.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.nic.test.entity.User;
import com.nic.test.repo.UserRepo;

@SpringBootApplication
@EnableEurekaClient
public class TestApplication {
	
	@Autowired
    private UserRepo repo;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(1, "user", "password", "user@gmail.com"),
                new User(2, "user1", "pwd1", "user1@gmail.com"),
                new User(3, "user2", "pwd2", "user2@gmail.com"),
                new User(4, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repo.saveAll(users);
    }

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
