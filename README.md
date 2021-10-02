# trabFinalJavaAPIpagamento

# Exemplos de utilização PaymentService

    A seguir alguns exemplos de chamadas para se utilizar a API

# PaymentService

## Endpoint findById

    Possibilita ao usuario encontrar uma transacão a partir do ID

### Exemplo de utilização

     
    http://localhost:8080/payment/findById?id=465498798

    OBS.: O mesmo irá retornar a transação no formato JSON
    
## Endpoint FindByAll

    Retorna todos os pagamentos 
    
    http://localhost:8080/payment/findByAll
    
     
## Endpoint Salvar Pagamento

    Possibilita ao usuario salvar uma transação

    OBS.: O mesmo irá retornar o URL para acessar a transação salva

### Exemplo de utilização

    http://localhost:8080/payment/save

    Corpo da requisição:

{
    "idTransacao": 2223233,
    "numeroCartao": 2789965,
    "validadeCartao": "11/2021",
    "valorCompra": 1500.55,
    "bandeira": "Mastercard"
}

## Endpoint update

    Possibilita ao usuario atualizar os dados de uma transação, utilizando seu ID para encontrá-la

### Exemplo de utilização

    http://localhost:8080/payment/update?id=465498798

    Corpo da requisição:

{
    "numeroCartao": 33568712,
    "validadeCartao": "07/2023",
    "valorCompra": 135.78,
    "bandeira": "Visa"
}

## Endpoint delete

    Possibilita ao usuario deletar uma transação, utilizando seu ID para encontra-lo

### Exemplo de utilização

    http://localhost:8080/payment/delete/999898752

    OBS.: O mesmo irá retornar uma transação no formato JSON, após excluí-la
