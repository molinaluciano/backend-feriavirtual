package com.duoc.feriavirtual.repositories;




import java.util.List;

import com.duoc.feriavirtual.entities.SolicitudEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface SolicitudRepository extends JpaRepository<SolicitudEntity, Long> {
    @Procedure(name = "Solicitud.cambiar_estado")
    Integer updateStatusRequest(
        @Param("ID_SOLICITUD_IN") Integer idSolicitud, 
        @Param("ID_ESTADO_SOLICITUD_IN") Integer idEstadoSolicitud
    );

    List<SolicitudEntity> findByIdEstadoSolicitud (Integer idEstadoSolicitud);

}
