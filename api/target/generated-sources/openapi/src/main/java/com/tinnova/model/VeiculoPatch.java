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
 * VeiculoPatch
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-04T09:09:40.569788920-03:00[America/Sao_Paulo]")
public class VeiculoPatch {

  private Long id;

  private String veiculo;

  private String marca;

  private Boolean vendido;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime update;

  /**
   * Default constructor
   * @deprecated Use {@link VeiculoPatch#VeiculoPatch(String, String)}
   */
  @Deprecated
  public VeiculoPatch() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public VeiculoPatch(String veiculo, String marca) {
    this.veiculo = veiculo;
    this.marca = marca;
  }

  public VeiculoPatch id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public VeiculoPatch veiculo(String veiculo) {
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

  public VeiculoPatch marca(String marca) {
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

  public VeiculoPatch vendido(Boolean vendido) {
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

  public VeiculoPatch update(OffsetDateTime update) {
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
    VeiculoPatch veiculoPatch = (VeiculoPatch) o;
    return Objects.equals(this.id, veiculoPatch.id) &&
        Objects.equals(this.veiculo, veiculoPatch.veiculo) &&
        Objects.equals(this.marca, veiculoPatch.marca) &&
        Objects.equals(this.vendido, veiculoPatch.vendido) &&
        Objects.equals(this.update, veiculoPatch.update);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, veiculo, marca, vendido, update);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VeiculoPatch {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    veiculo: ").append(toIndentedString(veiculo)).append("\n");
    sb.append("    marca: ").append(toIndentedString(marca)).append("\n");
    sb.append("    vendido: ").append(toIndentedString(vendido)).append("\n");
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

