package com.messageria.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class PagamentoDTO {

    public PagamentoDTO() {

    }

    private Integer numero;

    private String descricao;

    private BigDecimal valor;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagamentoDTO that = (PagamentoDTO) o;
        return Objects.equals(numero, that.numero) && Objects.equals(descricao, that.descricao) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, descricao, valor);
    }

    @Override
    public String toString() {
        return "PagamentoDTO{" +
                "numero=" + getNumero() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", valor=" + getValor() +
                '}';
    }
}
