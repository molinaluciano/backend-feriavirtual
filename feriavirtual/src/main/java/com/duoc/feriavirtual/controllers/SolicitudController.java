package com.duoc.feriavirtual.controllers;

import com.duoc.feriavirtual.entities.DetalleSolicitudEntity;
import com.duoc.feriavirtual.entities.SolicitudEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.models.GeneralRequestAndDetail;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.services.SolicitudService;
import java.util.List;
import java.util.Optional;

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
public class SolicitudController {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    SolicitudController.class
  );

  @Autowired
  SolicitudService solicitudService;

  @GetMapping(value = "/requests")
  public ResponseEntity<?> getAll() {
    try {
      List<SolicitudEntity> requests = solicitudService.findAllRequest();
      return new ResponseEntity<List<SolicitudEntity>>(requests, HttpStatus.OK);
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

  @GetMapping(value = "/get-requests/{id}")
  public ResponseEntity<?> getRequestById(@PathVariable Integer id) {
    LOGGER.debug("CONTROLLER ID:" + id);
    try {
      List<SolicitudEntity> requests = solicitudService.findRequestById(id);
      return new ResponseEntity<List<SolicitudEntity>>(requests, HttpStatus.OK);
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

  @GetMapping(value = "/requests/{id}")
  public ResponseEntity<?> getAllRequestByIdStatus(@PathVariable Integer id) {
    LOGGER.debug("CONTROLLER ID:" + id);
    try {
      List<SolicitudEntity> requests = solicitudService.selectRequestsByidStatus(
        id
      );
      return new ResponseEntity<List<SolicitudEntity>>(requests, HttpStatus.OK);
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
  
  @GetMapping(value = "/requests-by-client/{id}")
  public ResponseEntity<?> getRequestByIdClient(@PathVariable Integer id) {
    LOGGER.debug("CONTROLLER ID:" + id);
    try {
      List<SolicitudEntity> requests = solicitudService.findRequestByIdClient(
        id
      );
      return new ResponseEntity<List<SolicitudEntity>>(requests, HttpStatus.OK);
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

  @GetMapping(value = "/detail-requests")
  public ResponseEntity<?> getAllDetailrequests() {
    try {
      LOGGER.debug("VER TODOS LOS DETALLES DE SOLICITUD");

      List<DetalleSolicitudEntity> requests = solicitudService.findAllDetailRequests();
      return new ResponseEntity<List<DetalleSolicitudEntity>>(
        requests,
        HttpStatus.OK
      );
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

  @GetMapping(value = "/detail-requests/{id}")
  public ResponseEntity<?> getAllDetailrequestsByRequest(
    @PathVariable Integer id
  ) {
    try {
      LOGGER.debug("VER DETALLES DE SOLICITUD POR SOLICITUD");

      List<DetalleSolicitudEntity> requests = solicitudService.findAllDetailRequestsByIdRequests(
        id
      );
      return new ResponseEntity<List<DetalleSolicitudEntity>>(
        requests,
        HttpStatus.OK
      );
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

  @PutMapping(value = "/update-status-request")
  public ResponseEntity<?> updateStatusRequest(
    @RequestBody SolicitudEntity solicitud
  ) {
    try {
      Boolean resultUpdate = solicitudService.updateStatusRequest(solicitud);
      return new ResponseEntity<Boolean>(resultUpdate, HttpStatus.OK);
    } catch (NotFoundComponentFeriaVirtualException exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.NOT_FOUND
      );
    } catch (InvalidModelException exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.BAD_REQUEST
      );
    } catch (Exception exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }

  @PostMapping(value = "/create-request-and-detail")
  public ResponseEntity<?> postNewUser(
    @RequestBody GeneralRequestAndDetail generalRequestAndDetail
  ) {
    try {
      IdResponse idResultCreation = null;
      idResultCreation =
        solicitudService.createRequestAndDetail(generalRequestAndDetail);
      LOGGER.debug("idResultCreation:" + idResultCreation);
      return new ResponseEntity<IdResponse>(
        idResultCreation,
        HttpStatus.CREATED
      );
    } catch (NotFoundComponentFeriaVirtualException exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.NOT_FOUND
      );
    } catch (InvalidModelException exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    } catch (Exception exception) {
      return new ResponseEntity<ErrorDetail>(
        new ErrorDetail(exception.getMessage()),
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
  }
}
