package com.tinnova.api.util;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.tinnova.api.log.BadRequestException;

public class ValidaStringTest {

    @Test
    void deveValidarCampoVeiculoComSucesso() {
        // Arrange
        String veiculo = "Corolla";

        // Act & Assert
        assertDoesNotThrow(() -> ValidaString.validaCampoVeiculo(veiculo));
    }

    @Test
    void deveLancarExcecaoQuandoVeiculoForNulo() {
        // Arrange
        String veiculo = null;

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaCampoVeiculo(veiculo);
        });

        assertEquals("Dados inválidos para Veículo .", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoVeiculoForVazio() {
        // Arrange
        String veiculo = "";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaCampoVeiculo(veiculo);
        });

        assertEquals("Dados inválidos para Veículo .", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoTamanhoDoVeiculoForMenorQue4() {
        // Arrange
        String veiculo = "Car";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaCampoVeiculo(veiculo);
        });

        assertEquals("Dados inválidos para Veículo .", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoTamanhoDoVeiculoForMaiorQue12() {
        // Arrange
        String veiculo = "VeiculoMuitoGrande";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaCampoVeiculo(veiculo);
        });

        assertEquals("Dados inválidos para Veículo .", exception.getMessage());
    }

    @Test
    void deveValidarMarcaVeiculoComSucesso() {
        // Arrange
        String veiculo = "Corolla";

        // Act & Assert
        assertDoesNotThrow(() -> ValidaString.validaCampoMarca(veiculo));
    }


    @Test
    void deveLancarExcecaoQuandoMarcaForNulo() {
        // Arrange
        String veiculo = null;

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaCampoMarca(veiculo);
        });

        assertEquals("Dados inválidos para a Marca do veículo.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoMarcaForVazio() {
        // Arrange
        String veiculo = "";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaCampoMarca(veiculo);
        });

        assertEquals("Dados inválidos para a Marca do veículo.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoTamanhoDoMarcaForMenorQue3() {
        // Arrange
        String veiculo = "Ca";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaCampoMarca(veiculo);
        });

        assertEquals("Dados inválidos para a Marca do veículo.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoTamanhoDoVeiculoForMaiorQue10() {
        // Arrange
        String veiculo = "VeiculoMuitoGrande";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaCampoMarca(veiculo);
        });

        assertEquals("Dados inválidos para a Marca do veículo.", exception.getMessage());
    }

    @Test
    void deveValidarDescricaoComSucesso() {
        // Arrange
        String descricao = "Descrição válida com";

        // Act & Assert
        assertDoesNotThrow(() -> ValidaString.validaTamanhoDescricao(descricao));
    }

    @Test
    void deveLancarExcecaoQuandoDescricaoForVazia() {
        // Arrange
        String descricao = "";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaTamanhoDescricao(descricao);
        });

        assertEquals("Descrição maior que 30 caracteres", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoDescricaoForNull() {
        // Arrange
        String descricao = null;

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaTamanhoDescricao(descricao);
        });

        assertEquals("Descrição maior que 30 caracteres", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoDescricaoForMaiorQue30Caracteres() {
        // Arrange
        String descricao = "Esta descrição possui mais de trinta caracteres.";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            ValidaString.validaTamanhoDescricao(descricao);
        });

        assertEquals("Descrição maior que 30 caracteres", exception.getMessage());
    }

    @Test
    void deveRetornarStringVaziaQuandoEntradaForNula() {
        // Arrange
        String entrada = null;

        // Act
        String resultado = ValidaString.validaStringENuloOuVazio(entrada);

        // Assert
        assertEquals("", resultado);
    }

    @Test
    void deveRetornarStringVaziaQuandoEntradaForVazia() {
        // Arrange
        String entrada = "";
        // Act
        String resultado = ValidaString.validaStringENuloOuVazio(entrada);
        // Assert
        assertEquals("", resultado);
    }

    @Test
    void deveRetornarMesmaStringQuandoEntradaNaoForVaziaNemNula() {
        // Arrange
        String entrada = "TextoValido";

        // Act
        String resultado = ValidaString.validaStringENuloOuVazio(entrada);

        // Assert
        assertEquals("TextoValido", resultado);
    }

}
