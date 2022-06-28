package cd2tec.JavaTest.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class EntregaDto {

    @NotNull
    private Double peso;

    @NotBlank
    @Size(max = 8)
    private String cepOrigem;

    @NotBlank
    @Size(max = 8)
    private String cepDestino;

    @NotBlank
    private String nomeDest;

    private double valorFrete;
    private LocalDateTime dataPrevistaEntrega;
    private LocalDateTime dataConsulta;

    public EntregaDto(Double peso, String cepOrigem, String cepDestino, String nomeDest, double valorFrete, LocalDateTime dataPrevistaEntrega, LocalDateTime dataConsulta) {
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.nomeDest = nomeDest;
        this.valorFrete = valorFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.dataConsulta = dataConsulta;
    }

    public EntregaDto() {
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public String getNomeDest() {
        return nomeDest;
    }

    public void setNomeDest(String nomeDest) {
        this.nomeDest = nomeDest;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public LocalDateTime getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDateTime dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
