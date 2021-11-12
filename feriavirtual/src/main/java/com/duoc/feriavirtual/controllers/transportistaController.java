package com.duoc.feriavirtual.controllers;

import com.duoc.feriavirtual.entities.CamionEntity;
import com.duoc.feriavirtual.entities.DetalleSubastaEntity;
import com.duoc.feriavirtual.entities.TransportistaEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.services.TransportistaService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class transportistaController {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    transportistaController.class
  );

  @Autowired
  TransportistaService transportistaService;

  @GetMapping(value = "/select-carrier")
  public ResponseEntity<?> postMethodName() {
    try {
      List<TransportistaEntity> users = transportistaService.selectCarrier();
      return new ResponseEntity<List<TransportistaEntity>>(
        users,
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

  @PostMapping(value = "/create-truck")
  public ResponseEntity<?> createTruck(@RequestBody CamionEntity truck) {
    try {
      IdResponse idResultCreation = null;
      idResultCreation = transportistaService.createTruck(truck);
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

  @PutMapping(value = "/update-truck")
  public ResponseEntity<?> updateTruck(@RequestBody CamionEntity truck) {
    try {
      Boolean idResultUpdate = transportistaService.updateTruck(truck);
      return new ResponseEntity<Boolean>(idResultUpdate, HttpStatus.CREATED);
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

  @DeleteMapping(value = "/delete-truck/{id}")
  public ResponseEntity<?> deleteTruck(@PathVariable Integer id) {
    try {
      Boolean idResultUpdate = transportistaService.deleteTruck(id);
      return new ResponseEntity<Boolean>(idResultUpdate, HttpStatus.OK);
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

  @PostMapping(value = "/auction-participate")
  public ResponseEntity<?> createTruck(
    @RequestBody DetalleSubastaEntity detalleSubasta
  ) {
    try {
      IdResponse idResultCreation = null;
      idResultCreation =
        transportistaService.auctionParticipate(detalleSubasta);
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

  @GetMapping(value = "/select-truck-by-carrier/{id}")
  public ResponseEntity<?> selectTruckByCarrier(@PathVariable Integer id) {
    try {
      List<CamionEntity> users = transportistaService.getTruckByIdCarrier(id);
      return new ResponseEntity<List<CamionEntity>>(users, HttpStatus.OK);
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
