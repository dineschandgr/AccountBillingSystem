package com.user.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.user.account.service.UserService;

@SpringBootApplication
public class AccountBillingApplication {

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(AccountBillingApplication.class, args);
	}

	
	@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {
		
		@Override
		public void run(String... args) throws Exception {
			userService.saveUser();
		}
	
	}
}
