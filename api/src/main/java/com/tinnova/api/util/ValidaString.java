package com.tinnova.api.util;

import com.tinnova.api.log.BadRequestException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidaString {

    public static void validaCampoVeiculo(String veiculo) {
        if (veiculo == null || veiculo.isEmpty() || veiculo.length() < 4 || veiculo.length() > 12) {
            throw new BadRequestException("Dados inválidos para Veículo .");
        }
    }

    public static void validaCampoMarca(String marca) {
        if (marca == null || marca.isEmpty() || marca.length() < 3 || marca.length() > 10) {
            throw new BadRequestException("Dados inválidos para a Marca do veículo.");
        }
    }

    public static void validaTamanhoDescricao(String veiculo) {
        if (veiculo == null || veiculo.isEmpty() || veiculo.length() > 30) {
            throw new BadRequestException("Descrição maior que 30 caracteres");
        }
    }

    public static String validaStringENuloOuVazio(String veiculo){
        return veiculo == null || veiculo.isEmpty() ? "" : veiculo;
    }
}



