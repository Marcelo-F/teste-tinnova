package com.tinnova.api.mapper;

import com.tinnova.api.entity.VeiculoEntity;
import com.tinnova.model.TodosVeiculosPaginado;
import com.tinnova.model.Veiculo;
import com.tinnova.model.VeiculoSalvo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MapeaVeiculo {

    public VeiculoEntity toEntityVeiculo(Veiculo v) {

        VeiculoEntity veiculoEntity = new VeiculoEntity();
        if (v == null) {
            return new VeiculoEntity();
        }

        veiculoEntity.setVeiculo(v.getVeiculo());
        veiculoEntity.setMarca(v.getMarca());
        veiculoEntity.setCor(v.getCor());
        veiculoEntity.setAno(v.getAno());
        veiculoEntity.setDescricao(v.getDescricao());
        veiculoEntity.setVendido(v.getVendido());
        veiculoEntity.setCreated(v.getCreated());
        veiculoEntity.setUpdate(v.getUpdate());
        return veiculoEntity;
    }

    public static VeiculoSalvo toVeiculoReponse(VeiculoEntity v) {
        VeiculoSalvo veiculoSalvo = new VeiculoSalvo();
        if (v == null) {
            return veiculoSalvo;
        }

        veiculoSalvo.setId(v.getId());
        veiculoSalvo.setVeiculo(v.getVeiculo());
        veiculoSalvo.setMarca(v.getMarca());
        veiculoSalvo.setAno(v.getAno());
        veiculoSalvo.setDescricao(v.getDescricao());
        veiculoSalvo.setVendido(v.getVendido());
        veiculoSalvo.setCreated(v.getCreated());
        veiculoSalvo.setUpdate(v.getUpdate());
        veiculoSalvo.setCor(v.getCor());

        return veiculoSalvo;
    }

    public VeiculoEntity toEntityComVeiculoId(VeiculoSalvo v) {

        VeiculoEntity veiculoEntity = new VeiculoEntity();

        if (v == null) {
            return veiculoEntity;
        }

        veiculoEntity.setId(v.getId());
        veiculoEntity.setVeiculo(v.getVeiculo());
        veiculoEntity.setMarca(v.getMarca());
        veiculoEntity.setAno(v.getAno());
        veiculoEntity.setDescricao(v.getDescricao());
        veiculoEntity.setVendido(v.getVendido());
        veiculoEntity.setCreated(v.getCreated());
        veiculoEntity.setUpdate(v.getUpdate());
        veiculoEntity.setCor(v.getCor());
        return veiculoEntity;
    }

    public static TodosVeiculosPaginado toPageableResponse(Page pageable) {

        TodosVeiculosPaginado todosVeiculosPaginado = new TodosVeiculosPaginado();
        todosVeiculosPaginado.setPagina(pageable.getTotalPages());
        todosVeiculosPaginado.setSchema(pageable.getContent());
        todosVeiculosPaginado.setTamanho(pageable.getSize());

        return todosVeiculosPaginado;
    }
}
