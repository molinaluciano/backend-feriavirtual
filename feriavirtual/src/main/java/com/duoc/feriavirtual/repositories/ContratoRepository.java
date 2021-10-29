package com.duoc.feriavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Map;

import com.duoc.feriavirtual.entities.ContratoEntity;

public interface ContratoRepository extends JpaRepository<ContratoEntity, Long> {

    @Procedure(name = "Contrato.create")
    Map<String, Object> createContract(
        @Param("DESCRIPCION_IN") String descripcion, 
        @Param("FIRMAS_IN") String firmas, 
        @Param("ESTADO_CONTRATO_IN") Integer estadoContrato    
    );
    
   
}
