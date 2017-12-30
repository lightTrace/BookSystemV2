package cn.com.activimq.consumer;

import cn.com.entity.Book;
import cn.com.service.BookService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener{
	@Autowired
	private BookService bookService;
	@Override
	public void onMessage(Message message) {
       TextMessage textMessage = (TextMessage) message;
		try {
			Book book = JSON.parseObject(textMessage.getText(), Book.class);
			bookService.addBook(book);
			System.out.println("接收消息"+textMessage.getText());
	} catch (JMSException e) {
		e.printStackTrace();
	}
	}

}
