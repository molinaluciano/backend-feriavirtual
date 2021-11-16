package com.duoc.feriavirtual.repositories.tiposYestados;

import com.duoc.feriavirtual.entities.tiposYestados.EstadoSolicitudEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoSolicitudRepository extends JpaRepository<EstadoSolicitudEntity, Integer> {
  
}
