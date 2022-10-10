package com.demo.apachekafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class ApacheKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaProducerApplication.class, args);
	}

}
