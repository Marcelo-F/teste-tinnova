package com.tinnova.api.mapper;

import static org.junit.jupiter.api.Assertions.*;

import com.tinnova.api.entity.VeiculoEntity;
import com.tinnova.model.TodosVeiculosPaginado;
import com.tinnova.model.Veiculo;
import com.tinnova.model.VeiculoSalvo;
import fixture.VeiculoFixture;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class MapeaVeiculoTest {

    @Test
    void deveConverterVeiculoParaEntity() {
        // Arrange
        Veiculo veiculo = VeiculoFixture.criarVeiculo();


        MapeaVeiculo mapper = new MapeaVeiculo();

        // Act
        VeiculoEntity veiculoEntity = mapper.toEntityVeiculo(veiculo);
        // Assert
        assertNotNull(veiculoEntity);
        assertEquals("Toyota", veiculoEntity.getVeiculo());
        assertEquals("Corolla", veiculoEntity.getMarca());
        assertEquals("black", veiculoEntity.getCor());
        assertEquals(1999, veiculoEntity.getAno());
    }

    @Test
    void deveRetornarNovaEntityQuandoVeiculoForNulo() {
        // Arrange
        MapeaVeiculo mapper = new MapeaVeiculo();

        // Act
        VeiculoEntity veiculoEntity = mapper.toEntityVeiculo(null);

        // Assert
        assertNotNull(veiculoEntity);
        assertNull(veiculoEntity.getVeiculo());
        assertNull(veiculoEntity.getMarca());
    }

    @Test
    void deveConverterEntityParaResponse() {
        // Arrange

        VeiculoEntity veiculoEntity = VeiculoFixture.criarVeiculoEntity();
        // Act
        VeiculoSalvo veiculoSalvo = MapeaVeiculo.toVeiculoReponse(veiculoEntity);

        // Assert
        assertNotNull(veiculoSalvo);
        assertEquals(1L, veiculoSalvo.getId());
        assertEquals("Toyota", veiculoSalvo.getVeiculo());
        assertEquals("Corolla", veiculoSalvo.getMarca());
        assertEquals(1999, veiculoSalvo.getAno());
    }

    @Test
    void deveRetornarVeiculoSalvoVazioQuandoEntityForNulo() {
        // Arrange
        VeiculoEntity veiculoEntity = null;

        // Act
        VeiculoSalvo veiculoSalvo = MapeaVeiculo.toVeiculoReponse(veiculoEntity);

        // Assert
        assertNotNull(veiculoSalvo);
        assertNull(veiculoSalvo.getVeiculo());
        assertNull(veiculoSalvo.getMarca());
    }

    @Test
    void deveConverterSalvoParaEntityComId() {
        // Arrange

        VeiculoSalvo veiculoSalvo = VeiculoFixture.criarVeiculoSalvo();
        MapeaVeiculo mapper = new MapeaVeiculo();

        // Act
        VeiculoEntity veiculoEntity = mapper.toEntityComVeiculoId(veiculoSalvo);

        // Assert
        assertNotNull(veiculoEntity);
        assertEquals(1L, veiculoEntity.getId());
        assertEquals("Toyota", veiculoEntity.getVeiculo());
        assertEquals("Corolla", veiculoEntity.getMarca());
    }

    @Test
    void deveConverterPageParaTodosVeiculosPaginado() {
        // Arrange
        List<VeiculoEntity> listaVeiculos = Collections.singletonList(new VeiculoEntity());
        Page<VeiculoEntity> page = new PageImpl<>(listaVeiculos, PageRequest.of(0, 10), listaVeiculos.size());

        // Act
        TodosVeiculosPaginado todosVeiculosPaginado = MapeaVeiculo.toPageableResponse(page);

        // Assert
        assertNotNull(todosVeiculosPaginado);
        assertEquals(10, todosVeiculosPaginado.getTamanho());
        assertEquals(1, todosVeiculosPaginado.getSchema().size());
    }



}
