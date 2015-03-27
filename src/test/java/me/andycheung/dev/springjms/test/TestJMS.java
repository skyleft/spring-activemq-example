package me.andycheung.dev.springjms.test;

import junit.framework.Assert;
import me.andycheung.dev.springjms.consumer.TestConsumer;
import me.andycheung.dev.springjms.producer.TestProducer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJMS {
	
	private TestProducer producer;
	private TestConsumer consumer;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.producer = (TestProducer) ctx.getBean("producer");
		this.consumer = (TestConsumer) ctx.getBean("consumer");
	}

	@Test
	public void test() {
		Assert.assertNotNull(this.producer);
		Assert.assertNotNull(this.consumer);
		this.producer.send();
		Assert.assertEquals("message recieved", "HelloJMS", this.consumer.recive());
	}

}
