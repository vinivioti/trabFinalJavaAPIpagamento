package br.com.impacta.paymentservice.controller;

import br.com.impacta.paymentservice.model.Pagamento;
import br.com.impacta.paymentservice.service.PagamentoService;
import br.com.impacta.paymentservice.exception.ParameterException;
import br.com.impacta.paymentservice.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamento;
    private final String baseUrl = "http://localhost:8080/payment/";

    @GetMapping("/findById")
    public ResponseEntity buscaPagamento(@PathParam("id") int id) throws EntityNotFoundException {
        return new ResponseEntity(this.pagamento.buscaPedidoPorId(id), HttpStatus.OK);
    }

    @GetMapping("/findByAll")
    public ResponseEntity<List<Pagamento>> buscaTodosPedidos(){
        return ResponseEntity.ok(this.pagamento.buscaTodosPedidos());
    }

    @PostMapping("/save")
    public ResponseEntity salvarPedido(@RequestBody Pagamento pag) throws ParameterException {
        return new ResponseEntity(String.format("%s/save/%s", baseUrl, this.pagamento.salvar(pag)), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletarPedido(@PathVariable(value = "id") int id) throws ParameterException, EntityNotFoundException {
        return new ResponseEntity(String.format("Pagamento excluído.", this.pagamento.deletarPedido(id)), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Pagamento> atualizarDados(@PathParam("id") int id, @RequestBody Pagamento paga) throws EntityNotFoundException {
        Pagamento pag = this.pagamento.atualizarPedido(id,paga);

        return new ResponseEntity(pag, HttpStatus.OK);
    }
}
