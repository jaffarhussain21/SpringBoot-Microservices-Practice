package org.arpit.java2blog;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringBootApplicatioMain {

	public static void main(String[] args) {
		System.out.println("In main method: ");
		SpringApplication.run(SpringBootApplicatioMain.class, args);
	}

	@Bean
	public Queue queue() {
		System.out.println("Queue Ready: Flat#102");
		return new ActiveMQQueue("Flat#102");
	}
}
