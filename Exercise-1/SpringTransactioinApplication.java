package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.TransactionService;


/**
 * @author kumareshkaruppusamy
 * We disable the default hibernate configuration
 * Invocation of money transfer here 
 */

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})
public class SpringTransactioinApplication {
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext configurableApplicationContext =  SpringApplication.run(SpringTransactioinApplication.class, args);
		
		TransactionService transactionService = configurableApplicationContext.getBean("transactionService", TransactionService.class);
		transactionService.moneyTransfer(200, 100, 1000);
	}
}