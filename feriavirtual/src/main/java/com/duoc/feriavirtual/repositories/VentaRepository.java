package com.duoc.feriavirtual.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Map;

import com.duoc.feriavirtual.entities.VentaEntity;

public interface VentaRepository extends JpaRepository<VentaEntity, Long> {

    @Procedure(name = "Venta.updateState")
    Integer updateStateSale(
        @Param("ID_VENTA_IN") Integer idVenta, 
        @Param("ID_ESTADO_VENTA_IN") Integer idEstadoVenta
    );

    @Procedure(name = "Venta.finishSale")
    Integer finishSale(
        @Param("ID_VENTA_IN") Integer idVenta, 
        @Param("RESPONSE_CODE_IN") Integer responseCode
    );
    
   
}
