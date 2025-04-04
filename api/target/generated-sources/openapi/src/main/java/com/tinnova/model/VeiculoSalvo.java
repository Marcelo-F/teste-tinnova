package com.tinnova.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * VeiculoSalvo
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-04T09:09:40.569788920-03:00[America/Sao_Paulo]")
public class VeiculoSalvo {

  private Long id;

  private String veiculo;

  private String marca;

  private String cor;

  private Integer ano;

  private String descricao;

  private Boolean vendido;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime created;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime update;

  /**
   * Default constructor
   * @deprecated Use {@link VeiculoSalvo#VeiculoSalvo(String, String, Integer)}
   */
  @Deprecated
  public VeiculoSalvo() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VeiculoSalvo(String veiculo, String marca, Integer ano) {
    this.veiculo = veiculo;
    this.marca = marca;
    this.ano = ano;
  }

  public VeiculoSalvo id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public VeiculoSalvo veiculo(String veiculo) {
    this.veiculo = veiculo;
    return this;
  }

  /**
   * Get veiculo
   * @return veiculo
  */
  @NotNull @Size(min = 3, max = 10) 
  @Schema(name = "veiculo", example = "veiculo", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("veiculo")
  public String getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(String veiculo) {
    this.veiculo = veiculo;
  }

  public VeiculoSalvo marca(String marca) {
    this.marca = marca;
    return this;
  }

  /**
   * Get marca
   * @return marca
  */
  @NotNull @Size(min = 3, max = 10) 
  @Schema(name = "marca", example = "marca do carro", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("marca")
  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public VeiculoSalvo cor(String cor) {
    this.cor = cor;
    return this;
  }

  /**
   * Get cor
   * @return cor
  */
  
  @Schema(name = "cor", example = "cor", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cor")
  public String getCor() {
    return cor;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public VeiculoSalvo ano(Integer ano) {
    this.ano = ano;
    return this;
  }

  /**
   * Get ano
   * @return ano
  */
  @NotNull 
  @Schema(name = "ano", example = "1992", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("ano")
  public Integer getAno() {
    return ano;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public VeiculoSalvo descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  /**
   * Get descricao
   * @return descricao
  */
  @Size(min = 10, max = 30) 
  @Schema(name = "descricao", example = "Carro sem avarias", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("descricao")
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public VeiculoSalvo vendido(Boolean vendido) {
    this.vendido = vendido;
    return this;
  }

  /**
   * Get vendido
   * @return vendido
  */
  
  @Schema(name = "vendido", example = "false", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("vendido")
  public Boolean getVendido() {
    return vendido;
  }

  public void setVendido(Boolean vendido) {
    this.vendido = vendido;
  }

  public VeiculoSalvo created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  */
  @Valid @Pattern(regexp = "YYYY-MM-DD") 
  @Schema(name = "created", example = "2018-03-20T09:12:28Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created")
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public VeiculoSalvo update(OffsetDateTime update) {
    this.update = update;
    return this;
  }

  /**
   * Get update
   * @return update
  */
  @Valid @Pattern(regexp = "YYYY-MM-DD") 
  @Schema(name = "update", example = "2018-03-20T09:12:28Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("update")
  public OffsetDateTime getUpdate() {
    return update;
  }

  public void setUpdate(OffsetDateTime update) {
    this.update = update;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VeiculoSalvo veiculoSalvo = (VeiculoSalvo) o;
    return Objects.equals(this.id, veiculoSalvo.id) &&
        Objects.equals(this.veiculo, veiculoSalvo.veiculo) &&
        Objects.equals(this.marca, veiculoSalvo.marca) &&
        Objects.equals(this.cor, veiculoSalvo.cor) &&
        Objects.equals(this.ano, veiculoSalvo.ano) &&
        Objects.equals(this.descricao, veiculoSalvo.descricao) &&
        Objects.equals(this.vendido, veiculoSalvo.vendido) &&
        Objects.equals(this.created, veiculoSalvo.created) &&
        Objects.equals(this.update, veiculoSalvo.update);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, veiculo, marca, cor, ano, descricao, vendido, created, update);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VeiculoSalvo {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    veiculo: ").append(toIndentedString(veiculo)).append("\n");
    sb.append("    marca: ").append(toIndentedString(marca)).append("\n");
    sb.append("    cor: ").append(toIndentedString(cor)).append("\n");
    sb.append("    ano: ").append(toIndentedString(ano)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    vendido: ").append(toIndentedString(vendido)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    update: ").append(toIndentedString(update)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

