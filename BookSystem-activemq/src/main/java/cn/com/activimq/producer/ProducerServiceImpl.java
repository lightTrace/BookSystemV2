package cn.com.activimq.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class ProducerServiceImpl implements ProducerService{
    @Autowired
    JmsTemplate jmsTemplate;
    @Resource(name ="topicDestination")
    Destination destination;
	@Override
	public void sendMessage(final String message) {
		//使用jmsTemplate发送消息
		jmsTemplate.send(destination,new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage(message);
				System.out.println("发送消息"+textMessage.getText());
				return textMessage;
			}
			
		});
		System.out.println("发送消息"+message);
	}

}
