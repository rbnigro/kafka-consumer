package com.messageria.consumer;

import com.messageria.dto.PagamentoDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestConsumer {

    @PostConstruct
    public void init() {
        System.out.println("CONSUMER SUBIU");
    }

    @KafkaListener(topics = "${app.topic.pagamento}", groupId = "pagamentos-group-v2")
    public void listen(PagamentoDTO pagamento) {
        System.out.println("CHEGOU DTO: " + pagamento);
    }

}
