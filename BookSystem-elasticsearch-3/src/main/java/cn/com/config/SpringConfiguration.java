package cn.com.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 初始化es
 */
@Configuration
public class SpringConfiguration {
	@Bean
	public TransportClient client() throws UnknownHostException {


		Settings settings = Settings.builder()
				.put("cluster.name","superMan")
				.build();
		TransportClient client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
		return client;
	}
}
