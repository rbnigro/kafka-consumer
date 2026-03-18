package com.messageria.service;

import com.messageria.dto.PagamentoDTO;
import com.messageria.strategy.PagamentoStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    private final List<PagamentoStrategy> strategies;

    // O Spring injeta automaticamente todas as classes que implementam PagamentoStrategy
    public PagamentoService(List<PagamentoStrategy> strategies) {
        this.strategies = strategies;
    }

    public PagamentoDTO processar(PagamentoDTO dto) {
        PagamentoStrategy strategy = strategies.stream()
                .filter(s -> s.seAplica(dto))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nenhuma estratégia encontrada"));

        strategy.processar(dto);

        return dto;
    }
}
