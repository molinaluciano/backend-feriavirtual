package com.duoc.feriavirtual.repositories;

import com.duoc.feriavirtual.entities.DetalleSolicitudEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleSolicitudRepository
  extends JpaRepository<DetalleSolicitudEntity, Integer> {
  List<DetalleSolicitudEntity> findByIdSolicitud(Integer idSolicitud);
}
