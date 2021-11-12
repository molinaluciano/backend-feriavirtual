package com.duoc.feriavirtual.services;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.DetalleSolicitudEntity;
import com.duoc.feriavirtual.entities.SolicitudEntity;
import com.duoc.feriavirtual.entities.VentaEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.GeneralRequestAndDetail;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.repositories.DetalleSolicitudRepository;
import com.duoc.feriavirtual.repositories.SolicitudRepository;
import com.duoc.feriavirtual.repositories.VentaRepository;
import com.duoc.feriavirtual.validators.UsuarioValidator;
import java.util.List;
import java.util.Map;
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
