package com.duoc.feriavirtual.repositories;




import java.util.List;
import java.util.Map;

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
    @Procedure(name = "Solicitud.crear_solicitud_y_detalle")
    Map<String, Object> createRequestAndDetail(
        @Param("ID_USUARIO_IN") Integer idUsuario, 
        @Param("ID_TIPO_SOLICITUD_IN") Integer idTipoSolicitud, 
        @Param("KILOS_IN") Integer kilos, 
        @Param("ID_FRUTA_IN") Integer idFruta, 
        @Param("CALIDAD_IN") Integer idCalidad 
    );

    List<SolicitudEntity> findByIdEstadoSolicitud (Integer idEstadoSolicitud);

}
