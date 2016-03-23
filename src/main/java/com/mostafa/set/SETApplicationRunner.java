package com.mostafa.set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SETApplicationRunner implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("SET APPLICATION STARTED!");
	}
}
