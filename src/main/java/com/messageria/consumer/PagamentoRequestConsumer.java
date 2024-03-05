package com.messageria.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestConsumer {
	
	
	@KafkaListener(topics = "${spring.kafka.producer.pagamento.request.topic.v1}", groupId = "pagamento-request-consumer1")
	public void consumer(String message) {
		System.out.println("==== MENSAGEM RECEBIDA ==== " + message);
	}

}
