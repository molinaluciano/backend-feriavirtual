package com.duoc.feriavirtual.services;

import com.duoc.feriavirtual.entities.SaldoEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.repositories.SaldoRepository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    SaldoService.class
  );

  @Autowired
  SaldoRepository saldoRepository;

  
  public IdResponse createBalance(SaldoEntity saldo)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("CREANDO UN SALDO");
    IdResponse id = new IdResponse();

    Map<String, Object> resultCreateBalance= saldoRepository.createBalance(
      saldo.getIdFruta(), 
      saldo.getIdCalidad(), 
      saldo.getIdCliente(), 
      saldo.getDisponible(), 
      saldo.getKilos(),
      saldo.getPrecio()
    );

    Integer statusResultOut = (Integer) resultCreateBalance.get(
      "STATUS_RESULT_OUT"
    );
    Integer idResultOut = (Integer) resultCreateBalance.get("ID_RESULT_OUT");

    LOGGER.debug("statusResultOut: " + statusResultOut);
    LOGGER.debug("idResultOut: " + idResultOut);

    if (statusResultOut == -3) {
      throw new NotFoundComponentFeriaVirtualException(
        "Disponibilidad invalida"
      );
    } else if (statusResultOut == -2) {
      throw new NotFoundComponentFeriaVirtualException(
        "Calidad invalida"
      );
    } else if (statusResultOut == -1) {
      throw new NotFoundComponentFeriaVirtualException(
        "Fruta invalida"
      );
    } else if (statusResultOut == 0) {
      throw new NotFoundComponentFeriaVirtualException("Cliente invalido");
    } else if (statusResultOut == 1) {
      id.setId(idResultOut);
    } else {
      throw new InvalidModelException("Error - PL - FV_ADM_CREATE_BALANCE");
    }

    return id;
  }

  public Boolean updateBalance(SaldoEntity saldo)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("ACTUALIZANDO UN SALDO");

    Integer resultUpdateBalance= saldoRepository.updateBalance(
      saldo.getIdSaldo(),
      saldo.getIdFruta(), 
      saldo.getIdCalidad(), 
      saldo.getIdCliente(), 
      saldo.getDisponible(), 
      saldo.getKilos(),
      saldo.getPrecio()
    );

    LOGGER.debug("resultUpdateBalance=" + resultUpdateBalance);

    if (resultUpdateBalance == 1) {
      return true;
    } else if (resultUpdateBalance == 0) {
      throw new NotFoundComponentFeriaVirtualException(
        "Usuario Invalido"
      );
    } else if (resultUpdateBalance == -1) {
      throw new NotFoundComponentFeriaVirtualException(
        "Fruta Invalida"
      );
    } else if (resultUpdateBalance == -2) {
      throw new NotFoundComponentFeriaVirtualException("Calidad Invalida");
    } else if (resultUpdateBalance == -3) {
      throw new NotFoundComponentFeriaVirtualException(
        "Disponibilidad Invalida"
      );
    } else if (resultUpdateBalance == -4) {
      throw new NotFoundComponentFeriaVirtualException(
        "Saldo Invalido"
      );
    } else {
      throw new InvalidModelException("Error - PL - FV_ADM_UPDATE_BALANCE");
    }
  }

  public Boolean deleteBalance(Integer id)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("ELIMINANDO UN SALDO");

    Integer resultDeleteBalance = saldoRepository.deleteBalance(id);

    LOGGER.debug("resultDeleteBalance=" + resultDeleteBalance);

    if (resultDeleteBalance == 1) {
      return true;
    } else if (resultDeleteBalance == 0) {
      throw new NotFoundComponentFeriaVirtualException(
        "Saldo invalido"
      );
    } else {
      throw new InvalidModelException(
        "No se puede eliminar el saldo debido a que es utilizado en otra seccion"
      );
    }
  }

  public List<SaldoEntity> findAllBalance()
  throws NotFoundComponentFeriaVirtualException {
  try {
    List<SaldoEntity> resultBalance = saldoRepository.findAll();
    return resultBalance;
  } catch (Exception exception) {
    throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
  }
}

  public List<SaldoEntity> findAllBalanceAvailability()
  throws NotFoundComponentFeriaVirtualException {
  try {
    List<SaldoEntity> resultBalance = saldoRepository.findByDisponible(1);
    return resultBalance;
  } catch (Exception exception) {
    throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
  }
  }

  public List<SaldoEntity> findAllBalanceNotAvailability()
  throws NotFoundComponentFeriaVirtualException {
  try {
    List<SaldoEntity> resultBalance = saldoRepository.findByDisponible(0);
    return resultBalance;
  } catch (Exception exception) {
    throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
  }
  }

}
