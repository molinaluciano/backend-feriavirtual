package com.duoc.feriavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Map;

import com.duoc.feriavirtual.entities.DetalleSubastaEntity;

public interface DetalleSubastaRepository extends JpaRepository<DetalleSubastaEntity, Integer> {

    @Procedure(name = "Detalle_subasta.participar")
    Map<String, Object> auctionParticipate(
        @Param("ID_SUBASTA_IN") Integer idSubasta,
        @Param("ID_CAMION_IN") Integer idCamion,
        @Param("PRECIO_IN") Integer precio
    );

    
   
}
