package cd2tec.JavaTest.views;

import java.time.LocalDateTime;

public class EntregaView {

    private Double valorFrete;
    private LocalDateTime dataPrevistaEntrega;
    private String cepOrigem;
    private String cepDestino;

    public EntregaView(Double valorFrete, LocalDateTime dataPrevistaEntrega, String cepOrigem, String cepDestino) {
        this.valorFrete = valorFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
    }

    public EntregaView() {
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public LocalDateTime getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDateTime dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
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
}
