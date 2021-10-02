package br.com.impacta.paymentservice.model;

import br.com.impacta.paymentservice.utils.Formatar;

import java.math.BigDecimal;

public class Pagamento {
    private int idTransacao;
    private int numeroCartao;
    private String validadeCartao;
    private BigDecimal valorCompra;
    private String bandeira;

    public Pagamento(int idTransacao, int numeroCartao, String validadeCartao, BigDecimal valorCompra, String bandeira) {
        this.idTransacao = idTransacao;
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.valorCompra = Formatar.casasDecimais(valorCompra);
        this.bandeira = bandeira;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = Formatar.casasDecimais(valorCompra);
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
