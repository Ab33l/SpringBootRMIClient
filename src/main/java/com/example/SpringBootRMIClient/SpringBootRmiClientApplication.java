package com.example.SpringBootRMIClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication
public class SpringBootRmiClientApplication {

	@Bean
	RmiProxyFactoryBean rmiProxy() {
		RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
		bean.setServiceInterface(RMIService.class);
		bean.setServiceUrl("rmi://localhost:1099/SendMessageRMI");

		return bean;
	}

	public static void main(String[] args) {

		RMIService rmiService = SpringApplication.run(SpringBootRmiClientApplication.class, args)
				.getBean(RMIService.class);

		System.out.println("================Client Side ========================");

		System.out.println(rmiService.SayHello("Hello stanley"));
	}

}
