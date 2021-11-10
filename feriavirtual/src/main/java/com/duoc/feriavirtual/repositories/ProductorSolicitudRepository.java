package com.duoc.feriavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Map;

import com.duoc.feriavirtual.entities.ProductorSolicitudEntity;

public interface ProductorSolicitudRepository extends JpaRepository<ProductorSolicitudEntity, Integer> {
   
    @Procedure(name = "ProductorSolicitud.create")
    Integer requestParticipation(
        @Param("ID_SOLICITUD_IN") Integer idSolicitud,
        @Param("ID_PRODUCTOR_IN") Integer idProductor,
        @Param("PRODUCTOR_PRICE_IN") Integer precio
    );
    
   
}
