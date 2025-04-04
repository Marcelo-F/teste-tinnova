package com.tinnova.api.controller;

import com.tinnova.api.repository.VeiculoRepository;
import com.tinnova.api.service.ServiceVeiculo;
import com.tinnova.model.TodosVeiculosPaginado;
import com.tinnova.model.Veiculo;
import com.tinnova.model.VeiculoPatch;
import com.tinnova.model.VeiculoSalvo;
import fixture.VeiculoFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private Controller controller;

    @Mock
    private ServiceVeiculo service;

    @Mock
    private VeiculoRepository veiculoRepository;


    @BeforeEach
    void setUp() {

        veiculoRepository = Mockito.mock(VeiculoRepository.class);
        service = Mockito.mock(ServiceVeiculo.class);
        controller = new Controller(service);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void adicionarCarroDeveRetornarVeiculoSalvo() {

        Veiculo veiculo = VeiculoFixture.criarVeiculo();

        // Act
        ResponseEntity<VeiculoSalvo> response = controller.adicionarCarro(veiculo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void atualizaDadosEspecificoDoVeiculoDeveRetornarVoid() {
        // Arrange
        Long id = 1L;
        VeiculoPatch veiculoPatch = VeiculoFixture.criarVeiculoPatch();

        // Act
        ResponseEntity<Void> response = controller.atualizaDadosEspecificoDoVeculo(id, veiculoPatch);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deletarVeiculoDeveRetornarStatusOk() {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<Void> response = controller.deletarVeiculo(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void buscarTodosVeiculosDeveRetornarListaDeVeiculos() {
        // Arrange
        String marca = "Toyota";
        Integer ano = 2020;
        String cor = "Preto";

        // Act
        ResponseEntity<List<VeiculoSalvo>> response = controller.buscarTodosVeiculos(marca, ano, cor);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

    }

    @Test
    public void buscarTodosVeiculosPaginadoDeveRetornarPagina() {
        // Arrange
        Integer pagina = 0;
        Integer tamanho = 10;

        // Act
        ResponseEntity<TodosVeiculosPaginado> response = controller.buscarTodosVeiculosPaginado(pagina, tamanho);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
