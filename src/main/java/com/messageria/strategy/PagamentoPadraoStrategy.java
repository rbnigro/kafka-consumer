package com.messageria.strategy;

import com.messageria.dto.PagamentoDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PagamentoPadraoStrategy implements PagamentoStrategy {

    private final KafkaTemplate<String, PagamentoDTO> kafkaTemplate;

    public PagamentoPadraoStrategy(KafkaTemplate<String, PagamentoDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void processar(PagamentoDTO dto) {
        dto.setDescricao(dto.getDescricao() + " [NORMAL]");
        kafkaTemplate.send("pagamentos-topic", "normal", dto);
    }

    @Override
    public boolean seAplica(PagamentoDTO dto) {
        return dto.getValor().compareTo(new BigDecimal("1000")) <= 0;
    }
}
