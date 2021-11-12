package com.duoc.feriavirtual.controllers;

import com.duoc.feriavirtual.entities.DetalleSolicitudEntity;
import com.duoc.feriavirtual.entities.SolicitudEntity;
import com.duoc.feriavirtual.entities.VentaEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.models.GeneralRequestAndDetail;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.services.SolicitudService;
import com.duoc.feriavirtual.services.VentaService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    VentaController.class
  );

  @Autowired
  VentaService ventaService;

  @GetMapping(value = "/sales")
  public ResponseEntity<?> getAllSales() {
    try {
      List<VentaEntity> sales = ventaService.getAllSales();
      return new ResponseEntity<List<VentaEntity>>(sales, HttpStatus.OK);
    } catch (NotFoundComponentFeriaVirtualException exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.NOT_FOUND
      );
    } catch (Exception exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }

  @GetMapping(value = "/sales-by-status/{id}")
  public ResponseEntity<?> getSalesByStatus(@PathVariable Integer id) {
    try {
      LOGGER.debug("VER TODOS LAS VENTAS POR ESTADO");

      List<VentaEntity> requests = ventaService.getAllSalesByStatus(id);
      return new ResponseEntity<List<VentaEntity>>(requests, HttpStatus.OK);
    } catch (NotFoundComponentFeriaVirtualException exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.NOT_FOUND
      );
    } catch (Exception exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }

  @GetMapping(value = "/sales-by-pay-type/{id}")
  public ResponseEntity<?> getSalesByType(@PathVariable Integer id) {
    try {
      LOGGER.debug("VER VENTAS POR TIPO DE PAGO");

      List<VentaEntity> requests = ventaService.getAllSalesByType(id);
      return new ResponseEntity<List<VentaEntity>>(requests, HttpStatus.OK);
    } catch (NotFoundComponentFeriaVirtualException exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.NOT_FOUND
      );
    } catch (Exception exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }

  @GetMapping(value = "/sales-by-request/{id}")
  public ResponseEntity<?> getSalesByRequest(@PathVariable Integer id) {
    try {
      LOGGER.debug("VER VENTAS POR ID SOLICITUD");

      List<VentaEntity> requests = ventaService.getAllSalesByRequests(id);
      return new ResponseEntity<List<VentaEntity>>(requests, HttpStatus.OK);
    } catch (NotFoundComponentFeriaVirtualException exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.NOT_FOUND
      );
    } catch (Exception exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }
}
