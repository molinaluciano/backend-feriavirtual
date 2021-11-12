package com.duoc.feriavirtual.repositories;

import com.duoc.feriavirtual.entities.SubastaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubastaRepository
  extends JpaRepository<SubastaEntity, Integer> {
  List<SubastaEntity> findByIdEstadoSubasta(Integer idEstadoSubasta);
  List<SubastaEntity> findByIdSolicitud(Integer idSolicitud);
  List<SubastaEntity> findByIdSubasta(Integer idSubasta);
}
