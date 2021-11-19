package com.duoc.feriavirtual.services;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.DetalleVentaEntity;
import com.duoc.feriavirtual.entities.VentaEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.repositories.DetalleVentaRepository;
import com.duoc.feriavirtual.repositories.VentaRepository;
import java.util.List;
import java.util.Optional;

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
  DetalleVentaRepository detalleVentaRepository;

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

  // DETALLE VENTAS
  public List<DetalleVentaEntity> getAllDetailSales()
  throws NotFoundComponentFeriaVirtualException {
    try {
      List<DetalleVentaEntity> resultDetailSales = detalleVentaRepository.findAll();
      return resultDetailSales;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public Optional<DetalleVentaEntity> getDetailSalesByIdVenta(Integer idVenta)
  throws NotFoundComponentFeriaVirtualException {
    try {
      Optional<DetalleVentaEntity> resultDetailSales = detalleVentaRepository.findByIdVenta(idVenta);
      return resultDetailSales;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

}
