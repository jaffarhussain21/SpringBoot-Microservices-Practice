package org.arpit.java2blog.springboot;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageCreator implements CommandLineRunner {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;
	
	public void run(String... arg0) throws Exception {
		// This will put text message to queue
		this.jmsMessagingTemplate.convertAndSend(this.queue, "Pick up the post form the Flat#102!!!");
		System.out.println("Message has been put to queue (Post Box) by sender");
		try {
			Thread.sleep(100000);
			System.out.println("Message has been put second time to queue (Post Box) by sender");
			this.jmsMessagingTemplate.convertAndSend(this.queue, "Pick up another post form the Flat#102!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}