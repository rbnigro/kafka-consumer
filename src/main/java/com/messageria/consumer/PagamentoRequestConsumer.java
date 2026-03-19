package com.messageria.consumer;

import com.messageria.dto.PagamentoDTO;
import com.messageria.service.PagamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestConsumer {

    private static final Logger log = LoggerFactory.getLogger(PagamentoRequestConsumer.class);

    private final PagamentoService pagamentoService;

    public PagamentoRequestConsumer(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @KafkaListener(topics = "${app.topic.pagamento}", groupId = "pagamentos-group-v2")
    public void listen(PagamentoDTO pagamentoDTO) {
        try {
            log.info("Recebido pagamento: {}", pagamentoDTO);

            PagamentoDTO processado = pagamentoService.processar(pagamentoDTO);

            log.info("Pagamento processado: {}", processado);
        } catch (Exception e) {
            log.error("Erro ao processar pagamento: {}", pagamentoDTO, e);
        }

        System.out.println("Processado: " + pagamentoDTO);
    }
}