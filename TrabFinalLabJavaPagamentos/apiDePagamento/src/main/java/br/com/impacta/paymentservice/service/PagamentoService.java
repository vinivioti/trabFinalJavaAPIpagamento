package br.com.impacta.paymentservice.service;

import br.com.impacta.paymentservice.exception.ParameterException;
import br.com.impacta.paymentservice.exception.EntityNotFoundException;
import br.com.impacta.paymentservice.interfaces.IPagamentos;
import br.com.impacta.paymentservice.model.Pagamento;
import br.com.impacta.paymentservice.repositorio.PagamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService implements IPagamentos {

    @Autowired
    private PagamentoRepositorio repositorio;

    @Override
    public List<Pagamento> buscaTodosPedidos() {
        return repositorio.listaDePagamento();
    }

    @Override
    public Pagamento buscaPedidoPorId(int idPagamento) throws EntityNotFoundException {
        var pagamento = getPagamento(idPagamento);
        if (pagamento.isEmpty())
            throw new EntityNotFoundException(String.format("O pagamento %s não foi encontrado.", idPagamento));

        return pagamento.get();
    }

    @Override
    public int salvar(Pagamento pagamento) throws ParameterException {
        if (!(pagamento.getNumeroCartao() == 0 && pagamento.getBandeira().equals(null))){
            Pagamento novoPagamento = new Pagamento(pagamento.getIdTransacao(), pagamento.getNumeroCartao(), //
                                                    pagamento.getValidadeCartao(), pagamento.getValorCompra(), pagamento.getBandeira());

            repositorio.adicionaPagamento(novoPagamento);
            return novoPagamento.getIdTransacao();
        }

        throw new ParameterException("O pedido está incorreto!");
    }

    @Override
    public Boolean deletarPedido(int idPagamento) throws ParameterException, EntityNotFoundException {
        if (idPagamento == 0)
            throw new ParameterException("O parametro id está incorreto!");

        var pagamento = getPagamento(idPagamento);
        if (pagamento.isEmpty())
            throw new EntityNotFoundException(String.format("O pagamento %s não foi encontrado.", idPagamento));

        return repositorio.deletarPagamento(pagamento.get());
    }

    @Override
    public Pagamento atualizarPedido(int idPedido, Pagamento pagamento) throws EntityNotFoundException {
        var pagamentoConsultado = getPagamento(idPedido);
        if (pagamentoConsultado.isEmpty())
            throw new EntityNotFoundException(String.format("O pedido %s não foi encontrado.", idPedido));

        return atualizaDados(pagamentoConsultado.get(), pagamento);
    }

    private Pagamento atualizaDados(Pagamento pagEspecifico, Pagamento pagamento){
        Pagamento atualizar = pagEspecifico;
        atualizar.setNumeroCartao(pagamento.getNumeroCartao());
        atualizar.setValidadeCartao(pagamento.getValidadeCartao());
        atualizar.setValorCompra(pagamento.getValorCompra());
        atualizar.setBandeira(pagamento.getBandeira());
        return atualizar;
    }

    private Optional<Pagamento> getPagamento(int idPagamento){
        return repositorio.listaDePagamento().stream() //
                           .filter(pag -> pag.getIdTransacao() == idPagamento)
                           .findFirst();
    }

}
