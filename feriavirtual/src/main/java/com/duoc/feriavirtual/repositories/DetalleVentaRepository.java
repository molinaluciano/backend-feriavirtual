package com.duoc.feriavirtual.repositories;

import java.util.Optional;

import com.duoc.feriavirtual.entities.DetalleVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {
    Optional<DetalleVentaEntity> findByIdVenta(Integer idVenta);
}
