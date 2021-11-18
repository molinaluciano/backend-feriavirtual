package com.duoc.feriavirtual.repositories;

import com.duoc.feriavirtual.entities.SaldoEntity;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface SaldoRepository extends JpaRepository<SaldoEntity, Integer> {
  @Procedure(name = "Saldo.createBalance")
  Map<String, Object> createBalance(
    @Param("ID_FRUTA_IN") Integer idFruta,
    @Param("ID_CALIDAD_IN") Integer idCalidad,
    @Param("ID_CLIENTE_COMPRADOR_IN") Integer idClienteComprador,
    @Param("DISPONIBLE_IN") Integer disponible,
    @Param("KILOS_IN") Integer kilos
  );

  @Procedure(name = "Saldo.updateBalance")
  Integer updateBalance(
    @Param("ID_SALDO_IN") Integer idSaldo,
    @Param("ID_FRUTA_IN") Integer idFruta,
    @Param("ID_CALIDAD_IN") Integer idCalidad,
    @Param("ID_CLIENTE_COMPRADOR_IN") Integer idClienteComprador,
    @Param("DISPONIBLE_IN") Integer disponible,
    @Param("KILOS_IN") Integer kilos
  );

  @Procedure(name = "Saldo.deleteBalance")
  Integer deleteBalance(@Param("ID_SALDO_IN") Integer idSaldo);

  List<SaldoEntity> findByDisponible(Integer disponible);

}
