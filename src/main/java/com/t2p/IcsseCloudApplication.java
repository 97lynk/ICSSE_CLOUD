package com.t2p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.a97lynk", "com.t2p"})
public class IcsseCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcsseCloudApplication.class, args);
	}

}
