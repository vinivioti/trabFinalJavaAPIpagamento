package br.com.impacta.paymentservice.interfaces;

import br.com.impacta.paymentservice.model.Pagamento;
import br.com.impacta.paymentservice.exception.ParameterException;
import br.com.impacta.paymentservice.exception.EntityNotFoundException;

import java.util.List;

public interface IPagamentos {
    abstract List<Pagamento> buscaTodosPedidos();
    abstract Pagamento buscaPedidoPorId(int idPagamento) throws EntityNotFoundException;
    abstract int salvar(Pagamento pagamento) throws ParameterException;
    abstract Boolean deletarPedido(int idPagamento) throws ParameterException, EntityNotFoundException;
    abstract Pagamento atualizarPedido(int idPedido, Pagamento pagamento) throws EntityNotFoundException;
}
