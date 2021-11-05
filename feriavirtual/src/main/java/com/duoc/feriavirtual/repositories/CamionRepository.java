package com.duoc.feriavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Map;

import com.duoc.feriavirtual.entities.CamionEntity;

public interface CamionRepository extends JpaRepository<CamionEntity, Integer> {

    @Procedure(name = "Camion.create")
    Map<String, Object> createTruck(
        @Param("PATENTE_IN") String patente, 
        @Param("MODELO_IN") String modelo, 
        @Param("MARCA_IN") String marca, 
        @Param("REVISION_TECNICA_IN") Integer revisionTecnica,
        @Param("DISPONIBILIDAD_IN") Integer disponibilidad,
        @Param("ID_TIPO_CAMION_IN") Integer idTipoCamion,
        @Param("ID_TAMANO_CAMION_IN") Integer idTamanoCamion,
        @Param("ID_TRANSPORTISTA_IN") Integer idTransportista
    );

    @Procedure(name = "Camion.update")
    Integer updateTruck(
        @Param("PATENTE_IN") String patente, 
        @Param("MODELO_IN") String modelo, 
        @Param("MARCA_IN") String marca, 
        @Param("REVISION_TECNICA_IN") Integer revisionTecnica,
        @Param("DISPONIBILIDAD_IN") Integer disponibilidad,
        @Param("ID_TIPO_CAMION_IN") Integer idTipoCamion,
        @Param("ID_TAMANO_CAMION_IN") Integer idTamanoCamion,
        @Param("ID_TRANSPORTISTA_IN") Integer idTransportista
    );
    
    @Procedure(name = "Camion.delete")
    Integer deleteTruck(
        @Param("ID_CAMION_IN") Integer idCamion
    );
    
   
}
