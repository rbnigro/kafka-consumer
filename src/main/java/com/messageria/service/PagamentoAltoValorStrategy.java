package com.messageria.service;

import com.messageria.dto.PagamentoDTO;
import com.messageria.strategy.PagamentoStrategy;

public class PagamentoAltoValorStrategy  implements PagamentoStrategy {

    @Override
    public boolean seAplica(PagamentoDTO dto) {
        return dto.getValor().doubleValue() > 1000;
    }

    @Override
    public void processar(PagamentoDTO dto) {
        dto.setDescricao(dto.getDescricao() + " [ALTO VALOR]");
    }

}
