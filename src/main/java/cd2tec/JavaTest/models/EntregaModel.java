package cd2tec.JavaTest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_entrega")
public class EntregaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private String cepOrigem;

    @Column(nullable = false)
    private String cepDestino;

    @Column(nullable = false)
    private String nomeDest;

    @Column(nullable = false)
    private double valorFrete;

    @Column(nullable = false)
    private LocalDateTime dataPrevistaEntrega;

    @Column(nullable = false)
    private LocalDateTime dataConsulta;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
