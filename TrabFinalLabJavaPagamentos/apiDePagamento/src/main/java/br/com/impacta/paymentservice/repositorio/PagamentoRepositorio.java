package br.com.impacta.paymentservice.repositorio;

import br.com.impacta.paymentservice.model.Pagamento;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PagamentoRepositorio {

    private List<Pagamento> pagamentos = new ArrayList<>();

    private PagamentoRepositorio(){
        pagamentos.add(primeiroPagamento());
        pagamentos.add(segundoPagamento());
        pagamentos.add(terceiroPagamento());
        pagamentos.add(quartoPagamento());
    }

    public void adicionaPagamento(Pagamento pagamento){
        pagamentos.add(pagamento);
    }

    public List<Pagamento> listaDePagamento(){
        return pagamentos;
    }

    public Boolean deletarPagamento(Pagamento pagamento){
        Boolean statusLista;
        int quantidade = pagamentos.size();
        pagamentos.remove(pagamento);
        return statusLista = pagamentos.size() != quantidade ? Boolean.TRUE : Boolean.FALSE;
    }

    private Pagamento primeiroPagamento(){
        return new Pagamento(465498798, 555688784,"05/2028", new BigDecimal(50.00), "Visa");
    }

    private Pagamento segundoPagamento(){
        return new Pagamento(999898752, 336598471,"09/2022", new BigDecimal(110.55), "Mastercard");
    }

    private Pagamento terceiroPagamento(){
        return new Pagamento(778987642, 222356879,"12/2030", new BigDecimal(8.00), "Mastercard");
    }

    private Pagamento quartoPagamento(){
        return new Pagamento(667568795, 775786786,"01/2025", new BigDecimal(75.20), "Visa");
    }

}
