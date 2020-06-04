package org.arpit.java2blog.springboot;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	@JmsListener(destination = "Flat#102")
	@Async
		public void receiveQueue(String text) {
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Message Received: "+text);
	}
	
	@Async
	public void calculateSalary() {
		
	}
}
