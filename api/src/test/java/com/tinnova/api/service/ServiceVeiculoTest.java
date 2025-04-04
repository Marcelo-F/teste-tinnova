package com.tinnova.api.service;
import com.tinnova.api.entity.VeiculoEntity;
import com.tinnova.api.log.NotFoundException;
import com.tinnova.api.mapper.MapeaVeiculo;
import com.tinnova.api.repository.VeiculoRepository;
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
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceVeiculoTest {


    @Mock
    private VeiculoRepository veiculoRepository;

    @Mock
    private MapeaVeiculo mapeaVeiculo;

    @InjectMocks
    private ServiceVeiculo serviceVeiculo;

    @BeforeEach
    void setUp() {
        veiculoRepository = Mockito.mock(VeiculoRepository.class);
        mapeaVeiculo = Mockito.mock(MapeaVeiculo.class);
        serviceVeiculo = new ServiceVeiculo(veiculoRepository, mapeaVeiculo);
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }


    @Test
    void deveSalvarVeiculo() {
        // Arrange
        Veiculo veiculo = VeiculoFixture.criarVeiculo();
        VeiculoEntity veiculoEntity = VeiculoFixture.criarVeiculoEntity();

        when(mapeaVeiculo.toEntityVeiculo(veiculo)).thenReturn(veiculoEntity);
        when(veiculoRepository.save(veiculoEntity)).thenReturn(veiculoEntity);


        // Act
        VeiculoSalvo salvo = serviceVeiculo.save(veiculo);

        // Assert
        assertNotNull(salvo);
        assertEquals("Corolla", salvo.getMarca());
        verify(veiculoRepository, times(1)).save(veiculoEntity);
    }

    @Test
    void deveAtualizarVeiculoExistente() {
        // Arrange
        Long id = 1L;
        VeiculoPatch veiculoPatch = VeiculoFixture.criarVeiculoPatch();
        veiculoPatch.setId(id);
        VeiculoEntity veiculoEntity = VeiculoFixture.criarVeiculoEntity();

        when(veiculoRepository.findById(id)).thenReturn(Optional.of(veiculoEntity));

        // Act
        serviceVeiculo.atualizaVeiculo(id, veiculoPatch);

        // Assert
        verify(veiculoRepository, times(1))
                .atualizaVeiculo(veiculoPatch.getVeiculo(), veiculoPatch.getMarca(), veiculoPatch.getVendido(), id);
    }

    @Test
    void deveLancarExcecaoSeVeiculoNaoExistir() {
        // Arrange
        Long id = 1L;
        VeiculoPatch veiculoPatch = new VeiculoPatch("Toyota", "Corolla");

        when(veiculoRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> serviceVeiculo.atualizaVeiculo(id, veiculoPatch));
    }


    @Test
    void deveAtualizarVeiculoPorId() {
        // Arrange
        Long id = 1L;
        VeiculoSalvo veiculoSalvo = new VeiculoSalvo();
        veiculoSalvo.setId(id);
        veiculoSalvo.setVeiculo("Corolla");
        veiculoSalvo.setMarca("Toyota");

        VeiculoEntity entidadeComId = new VeiculoEntity();
        entidadeComId.setId(id);

        VeiculoEntity entidadeSalva = new VeiculoEntity();
        entidadeSalva.setId(id);
        entidadeSalva.setVeiculo("Corolla");
        entidadeSalva.setMarca("Toyota");

        when(mapeaVeiculo.toEntityComVeiculoId(veiculoSalvo)).thenReturn(entidadeComId);
        when(veiculoRepository.save(entidadeComId)).thenReturn(entidadeSalva);

        // Act
        VeiculoSalvo resultado = serviceVeiculo.atualizarVeiculoPorId(id, veiculoSalvo);

        // Assert
        assertNotNull(resultado);
        assertEquals("Corolla", resultado.getVeiculo());
        assertEquals("Toyota", resultado.getMarca());
        verify(mapeaVeiculo, times(1)).toEntityComVeiculoId(veiculoSalvo);
        verify(veiculoRepository, times(1)).save(entidadeComId);
    }


    @Test
    void deveDeletarVeiculoQuandoEncontrado() {
        // Arrange
        Long id = 1L;
        VeiculoEntity veiculoEntity = new VeiculoEntity();
        veiculoEntity.setId(id);

        when(veiculoRepository.findById(id)).thenReturn(Optional.of(veiculoEntity));
        doNothing().when(veiculoRepository).deleteById(id);

        // Act
        serviceVeiculo.deletarVeiculoPorId(id);

        // Assert
        verify(veiculoRepository, times(1)).findById(id);
        verify(veiculoRepository, times(1)).deleteById(id);
    }

    @Test
    void deveLancarNotFoundExceptionQuandoVeiculoNaoEncontrado() {
        // Arrange
        Long id = 1L;

        when(veiculoRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            serviceVeiculo.deletarVeiculoPorId(id);
        });

        assertEquals("Recurso com ID " + id + " não encontrado.", exception.getMessage());
        verify(veiculoRepository, times(1)).findById(id);
        verify(veiculoRepository, never()).deleteById(anyLong());
    }

    @Test
    void deveRetornarListaDeVeiculos() {
        // Arrange
        Veiculo veiculo = VeiculoFixture.criarVeiculo();
        VeiculoEntity veiculoEntity = VeiculoFixture.criarVeiculoEntity();

        when(veiculoRepository.findAll(veiculo.getMarca(), veiculo.getAno(), veiculo.getCor())).thenReturn(List.of(veiculoEntity));

        // Act
        List<VeiculoSalvo> veiculos = serviceVeiculo.findAll(veiculo.getMarca(), veiculo.getAno(), veiculo.getCor());

        // Assert
        assertNotNull(veiculos);
        assertEquals(1, veiculos.size());
        verify(veiculoRepository, times(1)).findAll(veiculo.getMarca(), veiculo.getAno(), veiculo.getCor());
    }

    @Test
    void deveRetornarVeiculoPorId() {
        // Arrange
        VeiculoEntity veiculoEntity = VeiculoFixture.criarVeiculoEntity();

        when(veiculoRepository.findById(veiculoEntity.getId())).thenReturn(Optional.of(veiculoEntity));

        // Act
        VeiculoSalvo salvo = serviceVeiculo.findById(veiculoEntity.getId());

        // Assert
        assertNotNull(salvo);
        assertEquals("Corolla", salvo.getMarca());
        verify(veiculoRepository, times(1)).findById(veiculoEntity.getId());
    }

}