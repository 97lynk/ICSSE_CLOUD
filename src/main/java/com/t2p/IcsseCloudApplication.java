package com.t2p;

import com.a97lynk.service.IUserService;
import com.t2p.entity.News;
import com.t2p.entity.TypeOfNews;
import com.t2p.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.a97lynk", "com.t2p"})
public class IcsseCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcsseCloudApplication.class, args);
	}

}
