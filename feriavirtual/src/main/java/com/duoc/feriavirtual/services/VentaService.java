package com.duoc.feriavirtual.services;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.VentaEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.repositories.VentaRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    VentaService.class
  );

  @Autowired
  VentaRepository ventaRepository;

  @Autowired
  CommonConverter commonConverter;

  public List<VentaEntity> getAllSales()
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<VentaEntity> resultSales = (List<VentaEntity>) ventaRepository.findAll();
      return resultSales;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public List<VentaEntity> getAllSalesByStatus(Integer idEstado)
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<VentaEntity> resultSales = (List<VentaEntity>) ventaRepository.findByIdEstadoVenta(
        idEstado
      );
      return resultSales;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public List<VentaEntity> getAllSalesByType(Integer idTipo)
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<VentaEntity> resultSales = (List<VentaEntity>) ventaRepository.findByIdTipoPago(
        idTipo
      );
      return resultSales;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public List<VentaEntity> getAllSalesByRequests(Integer idSolicitud)
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<VentaEntity> resultSales = (List<VentaEntity>) ventaRepository.findByIdSolicitud(
        idSolicitud
      );
      return resultSales;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }
}
