package io.confuent.developer.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
@SpringBootApplication
public class KafkaConsumerSampleApplication {

	private static final Logger logger =
			LoggerFactory.getLogger(KafkaConsumerSampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerSampleApplication.class, args);
	}




	@KafkaListener(topics = "${kafka.topic2}", groupId = "${kafka.group_id_2}")
	public void listener2 (String message) {
		logger.info("Received message = {}", message);
	}

	@KafkaListener(topics = "${kafka.topic1}", groupId = "${kafka.group_id}")
	public void listener(String message) {
		logger.info("Received message = {}", message);
	}
}
