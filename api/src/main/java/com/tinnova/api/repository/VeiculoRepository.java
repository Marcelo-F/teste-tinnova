package com.tinnova.api.repository;

import com.tinnova.api.entity.VeiculoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE VEICULO_ENTITY " +
            "SET VEICULO = :veiculo, " +
            "MARCA = :marca, " +
            "VENDIDO = :vendido " +
            "WHERE ID = :id", nativeQuery = true)
    void atualizaVeiculo(@Param("veiculo") String veiculo,
                         @Param("marca") String marca,
                         @Param("vendido") boolean vendido,
                         @Param("id") long id);


    @Query(value = "SELECT * FROM VEICULO_ENTITY " +
            "WHERE (:marca IS NULL OR MARCA = :marca) " +
            "OR (:ano IS NULL OR ANO = :ano) " +
            "OR (:cor IS NULL OR COR = :cor)",
            nativeQuery = true)
    List<VeiculoEntity> findAll(@Param("marca") String marca,
                                @Param("ano") Integer ano,
                                @Param("cor") String cor);


}
