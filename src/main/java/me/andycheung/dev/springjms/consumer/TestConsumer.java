package me.andycheung.dev.springjms.consumer;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class TestConsumer {
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public String recive() {
		while (true) {
			try {
				TextMessage txtmsg = (TextMessage) jmsTemplate.receive();
				if (null != txtmsg) {
					return txtmsg.getText();
				} else {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;
	}

}

