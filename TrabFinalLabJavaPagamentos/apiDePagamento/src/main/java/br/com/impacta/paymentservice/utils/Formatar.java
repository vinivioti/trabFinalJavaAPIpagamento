package br.com.impacta.paymentservice.utils;

import java.math.BigDecimal;

public class Formatar {
    public static BigDecimal casasDecimais (BigDecimal numeral){
        BigDecimal numero = new BigDecimal(String.valueOf(numeral));
        numero = numero.setScale(2, BigDecimal.ROUND_HALF_UP);
        return numero;
    }
}
