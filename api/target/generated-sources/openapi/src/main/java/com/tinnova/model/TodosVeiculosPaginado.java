package com.tinnova.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.tinnova.model.VeiculoSalvo;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TodosVeiculosPaginado
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-04T09:09:40.569788920-03:00[America/Sao_Paulo]")
public class TodosVeiculosPaginado {

  private Integer pagina;

  private Integer tamanho;

  @Valid
  private List<@Valid VeiculoSalvo> schema;

  public TodosVeiculosPaginado pagina(Integer pagina) {
    this.pagina = pagina;
    return this;
  }

  /**
   * Get pagina
   * @return pagina
  */
  
  @Schema(name = "pagina", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pagina")
  public Integer getPagina() {
    return pagina;
  }

  public void setPagina(Integer pagina) {
    this.pagina = pagina;
  }

  public TodosVeiculosPaginado tamanho(Integer tamanho) {
    this.tamanho = tamanho;
    return this;
  }

  /**
   * Get tamanho
   * @return tamanho
  */
  
  @Schema(name = "tamanho", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tamanho")
  public Integer getTamanho() {
    return tamanho;
  }

  public void setTamanho(Integer tamanho) {
    this.tamanho = tamanho;
  }

  public TodosVeiculosPaginado schema(List<@Valid VeiculoSalvo> schema) {
    this.schema = schema;
    return this;
  }

  public TodosVeiculosPaginado addSchemaItem(VeiculoSalvo schemaItem) {
    if (this.schema == null) {
      this.schema = new ArrayList<>();
    }
    this.schema.add(schemaItem);
    return this;
  }

  /**
   * Get schema
   * @return schema
  */
  @Valid 
  @Schema(name = "schema", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("schema")
  public List<@Valid VeiculoSalvo> getSchema() {
    return schema;
  }

  public void setSchema(List<@Valid VeiculoSalvo> schema) {
    this.schema = schema;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TodosVeiculosPaginado todosVeiculosPaginado = (TodosVeiculosPaginado) o;
    return Objects.equals(this.pagina, todosVeiculosPaginado.pagina) &&
        Objects.equals(this.tamanho, todosVeiculosPaginado.tamanho) &&
        Objects.equals(this.schema, todosVeiculosPaginado.schema);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagina, tamanho, schema);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TodosVeiculosPaginado {\n");
    sb.append("    pagina: ").append(toIndentedString(pagina)).append("\n");
    sb.append("    tamanho: ").append(toIndentedString(tamanho)).append("\n");
    sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
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

