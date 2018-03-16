package com.a97lynk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {
        "resgistration-application.properties",
        "registration-persistence.properties",
        "sendmail-application.properties",
})
public class RegistrationApplication {

    public static void main(String[] args) {
      SpringApplication.run(RegistrationApplication.class, args);
//        Arrays.asList(context.getBeanDefinitionNames())
//                .forEach(e->{
//                    System.out.println(e.toString());
//                });
    }
}
