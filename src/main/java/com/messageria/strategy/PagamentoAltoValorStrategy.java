package com.messageria.strategy;

import com.messageria.dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PagamentoAltoValorStrategy  implements PagamentoStrategy {

    @Value("${pagamento.limite-alto-valor}")
    private BigDecimal limite;

    @Override
    public boolean seAplica(PagamentoDTO dto) {
        return dto.getValor().compareTo(limite) > 0;
    }

    @Override
    public void processar(PagamentoDTO dto) {
        dto.setDescricao(dto.getDescricao() + " [ALTO VALOR]");
    }

}
