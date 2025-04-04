package com.tinnova.api.service;

import com.tinnova.api.entity.VeiculoEntity;
import com.tinnova.api.log.NotFoundException;
import com.tinnova.api.mapper.MapeaVeiculo;
import com.tinnova.api.repository.VeiculoRepository;
import com.tinnova.model.TodosVeiculosPaginado;
import com.tinnova.model.Veiculo;
import com.tinnova.model.VeiculoPatch;
import com.tinnova.model.VeiculoSalvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static com.tinnova.api.util.ValidaString.validaStringENuloOuVazio;

@Service
public class ServiceVeiculo {

    private VeiculoRepository veiculoRepository;

    private MapeaVeiculo mapeaVeiculo;

    @Autowired
    public ServiceVeiculo(VeiculoRepository veiculoRepository, MapeaVeiculo mapper) {
        this.veiculoRepository = veiculoRepository;
        this.mapeaVeiculo = mapper;
    }

    public VeiculoSalvo save(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = mapeaVeiculo.toEntityVeiculo(veiculo);
        veiculoEntity = veiculoRepository.save(veiculoEntity);
        VeiculoSalvo salvo = mapeaVeiculo.toVeiculoReponse(veiculoEntity);
        return salvo;
    }

    public void atualizaVeiculo(Long id, VeiculoPatch veiculoPatch) {

        if (veiculoRepository.findById(id).isPresent()) {

            veiculoRepository.atualizaVeiculo(veiculoPatch.getVeiculo(),
                    veiculoPatch.getMarca(),
                    veiculoPatch.getVendido(),
                    veiculoPatch.getId());
        } else {
            throw new NotFoundException("Recurso com ID " + id + " não encontrado.");
        }
    }

    public VeiculoSalvo atualizarVeiculoPorId(Long id, VeiculoSalvo veiculoSalvo) {

        var entidadeComId = mapeaVeiculo.toEntityComVeiculoId(veiculoSalvo);

        var entidadeSalva = veiculoRepository.save(entidadeComId);

        return mapeaVeiculo.toVeiculoReponse(entidadeSalva);
    }

    public void deletarVeiculoPorId(Long id) {
        veiculoRepository.findById(id).ifPresentOrElse(
                a -> veiculoRepository.deleteById(a.getId()),
                () -> {
                    throw new NotFoundException("Recurso com ID " + id + " não encontrado.");
                }
        );

    }

    public List<VeiculoSalvo> findAll(String marca, Integer ano, String cor) {

        marca = validaStringENuloOuVazio(marca);
        cor = validaStringENuloOuVazio(cor);

        var result = veiculoRepository.findAll(marca, ano, cor);

        return result.stream()
                .map(MapeaVeiculo::toVeiculoReponse)
                .collect(Collectors.toList());

    }


    public TodosVeiculosPaginado buscarTodosVeiculosPaginado(Integer pagina, Integer tamanho) {
        int i = pagina == null ? 0 : pagina;
        int x = tamanho == null ? 10 : pagina;
        Pageable pageable = PageRequest.of(i, x);

        Page result = veiculoRepository.findAll(pageable);
        var response = MapeaVeiculo.toPageableResponse(result);
        return response;

    }

    public VeiculoSalvo findById(Long id) {
        var veiculoEncontrado = veiculoRepository.findById(id);
        return mapeaVeiculo.toVeiculoReponse(veiculoEncontrado.get());
    }
}
