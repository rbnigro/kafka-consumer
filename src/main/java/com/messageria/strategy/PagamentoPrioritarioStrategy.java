package com.messageria.strategy;

import com.messageria.dto.PagamentoDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PagamentoPrioritarioStrategy implements PagamentoStrategy {

    private final KafkaTemplate<String, PagamentoDTO> kafkaTemplate;

    public PagamentoPrioritarioStrategy(KafkaTemplate<String, PagamentoDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void processar(PagamentoDTO dto) {
        dto.setDescricao(dto.getDescricao() + " [PRIORIDADE ALTA]");
        kafkaTemplate.send("pagamento.request.topic.v2", "high-priority", dto);
    }

    @Override
    public boolean seAplica(PagamentoDTO dto) {
        return dto.getValor().compareTo(new BigDecimal("1000")) > 0;
    }
}
