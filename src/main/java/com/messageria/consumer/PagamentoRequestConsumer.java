package com.messageria.consumer;

import com.messageria.dto.PagamentoDTO;
import com.messageria.service.PagamentoService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestConsumer {

    private final PagamentoService pagamentoService;

    public PagamentoRequestConsumer(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @KafkaListener(topics = "${app.topic.pagamento}", groupId = "pagamentos-group-v2")
    public void listen(PagamentoDTO pagamentoDTO) {
        PagamentoDTO processado = pagamentoService.processar(pagamentoDTO);

        System.out.println("Processado: " + pagamentoDTO);
    }


}
