package com.springboot.rabbitmq;

import com.springboot.rabbitmq.fanout.FanoutSender;
import com.springboot.rabbitmq.simple.SimpleSender;
import com.springboot.rabbitmq.topic.TopicSender;
import com.springboot.rabbitmq.work.WorkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class RabbitMQTest {

	//简单模式
	@Autowired
	private SimpleSender simpleSender;

	@Test
	public void simpleSender() throws Exception {
		simpleSender.send();
	}

	//工作模式
	@Autowired
	private WorkSender workSender;

	@Test
	public void workSender() throws Exception {
		for (int i=0;i<30;i++){
			workSender.send(i);
			Thread.sleep(100);
		}
	}

	//订阅模式
	@Autowired
	private FanoutSender fanoutSender;

	@Test
	public void fanoutSender() throws Exception {
		for (int i=0;i<30;i++){
			fanoutSender.send(i);
			Thread.sleep(100);
		}
	}

	//主题模式
	@Autowired
	private TopicSender topicSender;

	@Test
	public void topicSender1() throws Exception {
		topicSender.send1();
	}

	@Test
	public void topicSender2() throws Exception {
		topicSender.send2();
	}
}
