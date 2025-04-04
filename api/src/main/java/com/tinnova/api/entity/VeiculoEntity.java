package com.tinnova.api.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.OffsetDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class VeiculoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "veiculo")
    private String veiculo;

    @Column(name = "cor")
    private String cor;

    @Column(name = "marca")
    private String marca;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "vendido")
    private Boolean vendido;

    @Column(name = "created")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime created;

    @Column(name = "update")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime update;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public OffsetDateTime getUpdate() {
        return update;
    }

    public void setUpdate(OffsetDateTime update) {
        this.update = update;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
