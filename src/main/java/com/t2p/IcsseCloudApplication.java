package com.t2p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.a97lynk", "com.t2p"})
@RestController
public class IcsseCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcsseCloudApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "hello";
	}
}
