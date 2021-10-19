package com.duoc.feriavirtual.repositories;




import java.util.List;

import com.duoc.feriavirtual.entities.SolicitudEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<SolicitudEntity, Long> {

    List<SolicitudEntity> findByIdEstadoSolicitud (Integer idEstadoSolicitud);

}
