package com.messageria.config;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConsumerConfig {

	@Autowired
	private KafkaProperties kafkaProperties;
	
	@Value("${app.kafka.producer.pagamento.request.topic.v1}")
	private String pagamentoRequestTopicV1;
	
	@Bean
	NewTopic pagamentoRequestTopicBuilder() {
		return TopicBuilder
				.name(pagamentoRequestTopicV1)
				.partitions(1)
				.replicas(1)
				.build();
	}
}
