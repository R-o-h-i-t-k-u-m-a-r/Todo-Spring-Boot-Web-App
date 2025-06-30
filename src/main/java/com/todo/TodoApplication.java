package com.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		System.out.println("This message is for Jenkins Pipeline evaluation");
		SpringApplication.run(TodoApplication.class, args);
	}

}
