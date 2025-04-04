package com.tinnova.api.controller;

import com.tinnova.api.VeiculoApi;
import com.tinnova.api.service.ServiceVeiculo;
import com.tinnova.model.TodosVeiculosPaginado;
import com.tinnova.model.Veiculo;
import com.tinnova.model.VeiculoPatch;
import com.tinnova.model.VeiculoSalvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static com.tinnova.api.util.ValidaString.*;


@RestController
@RequestMapping("/spring")
public class Controller implements VeiculoApi {

    private final ServiceVeiculo service;

    @Autowired
    public Controller(ServiceVeiculo service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<VeiculoSalvo> adicionarCarro(Veiculo veiculo) {
        validaCampoMarca(veiculo.getMarca());
        validaCampoVeiculo(veiculo.getVeiculo());
        validaTamanhoDescricao(veiculo.getDescricao());

        VeiculoSalvo salvo = service.save(veiculo);
        return ResponseEntity.ok(salvo);

    }

    @Override
    public ResponseEntity<Void> atualizaDadosEspecificoDoVeculo(Long id, VeiculoPatch veiculoPatch) {
        validaCampoMarca(veiculoPatch.getMarca());
        validaCampoVeiculo(veiculoPatch.getVeiculo());
        service.atualizaVeiculo(id, veiculoPatch);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<VeiculoSalvo> atualizaVeiculoPorId(Long id, VeiculoSalvo veiculoSalvo) {
        validaCampoMarca(veiculoSalvo.getMarca());
        validaCampoVeiculo(veiculoSalvo.getVeiculo());
        validaTamanhoDescricao(veiculoSalvo.getDescricao());

        var viculoAtualizado = service.atualizarVeiculoPorId(id, veiculoSalvo);
        return ResponseEntity.ok(viculoAtualizado);
    }

    @Override
    public ResponseEntity<Void> deletarVeiculo(Long id) {

        service.deletarVeiculoPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<VeiculoSalvo>> buscarTodosVeiculos(String marca, Integer ano, String cor) {

        return ResponseEntity.ok(service.findAll(marca, ano, cor));

    }

    @Override
    public ResponseEntity<TodosVeiculosPaginado> buscarTodosVeiculosPaginado(Integer pagina, Integer tamanho) {
        TodosVeiculosPaginado todosVeiculosPaginado = service.buscarTodosVeiculosPaginado(pagina, tamanho);
        return ResponseEntity.ok(todosVeiculosPaginado);

    }

    @Override
    public ResponseEntity<VeiculoSalvo> findById(Long id) {

        service.findById(id);

        return ResponseEntity.ok(service.findById(id));

    }

}
