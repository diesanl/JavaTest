package cd2tec.JavaTest.utils;

import cd2tec.JavaTest.dtos.EntregaDto;

import java.time.LocalDateTime;

public class SigaBemUtils {
    public static EntregaDto calculaFrete(double peso, String origemDdd, String origemUf, String destinoDdd, String destinoUf) {

        EntregaDto entregaDto = new EntregaDto();
        if (origemDdd.equals(destinoDdd)) {
            entregaDto.setValorFrete(peso * 0.5);
            entregaDto.setDataPrevistaEntrega(LocalDateTime.now().plusDays(1));
        } else if (origemUf.equals(destinoUf)) {
            entregaDto.setValorFrete(peso * 0.25);
            entregaDto.setDataPrevistaEntrega(LocalDateTime.now().plusDays(3));
        } else if (!origemUf.equals(destinoUf) ) {
            entregaDto.setValorFrete(peso);
            entregaDto.setDataPrevistaEntrega(LocalDateTime.now().plusDays(10));
        }
        entregaDto.setDataConsulta(LocalDateTime.now());
        return entregaDto;
    }
}