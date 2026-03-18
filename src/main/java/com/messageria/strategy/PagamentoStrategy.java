package com.messageria.strategy;

import com.messageria.dto.PagamentoDTO;

public interface PagamentoStrategy {

    void processar( PagamentoDTO dto);

    boolean seAplica(PagamentoDTO dto);
}
