package com.duoc.feriavirtual.controllers;

import com.duoc.feriavirtual.entities.SubastaEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.services.SubastaService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubastaController {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    SubastaController.class
  );

  @Autowired
  SubastaService subastaService;

  @GetMapping(value = "/auctions")
  public ResponseEntity<?> getAllAuctions() {
    try {
      List<SubastaEntity> sales = subastaService.findAllSubastas();
      return new ResponseEntity<List<SubastaEntity>>(sales, HttpStatus.OK);
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

  @GetMapping(value = "/auctions-by-status/{id}")
  public ResponseEntity<?> getAllAuctionsBystatus(@PathVariable Integer id) {
    try {
      LOGGER.debug("VER SUBASTAS POR ESTADO");
      List<SubastaEntity> sales = subastaService.findAllSubastasByStatus(id);
      return new ResponseEntity<List<SubastaEntity>>(sales, HttpStatus.OK);
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

  @GetMapping(value = "/auctions-by-requests/{id}")
  public ResponseEntity<?> getAllAuctionsByRequest(@PathVariable Integer id) {
    try {
      LOGGER.debug("VER SUBASTAS POR SOLICITUD");
      List<SubastaEntity> sales = subastaService.findAllSubastasByRequest(id);
      return new ResponseEntity<List<SubastaEntity>>(sales, HttpStatus.OK);
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

  @GetMapping(value = "/auctions-by-id/{id}")
  public ResponseEntity<?> getAllAuctionsById(@PathVariable Integer id) {
    try {
      LOGGER.debug("VER SUBASTAS POR ID");
      List<SubastaEntity> sales = subastaService.findByIdSubasta(id);
      return new ResponseEntity<List<SubastaEntity>>(sales, HttpStatus.OK);
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
