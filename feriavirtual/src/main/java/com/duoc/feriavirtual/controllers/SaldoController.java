package com.duoc.feriavirtual.controllers;

import java.util.List;

import com.duoc.feriavirtual.entities.SaldoEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.services.SaldoService;
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
public class SaldoController {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    SaldoController.class
  );

  @Autowired
  SaldoService saldoService;

  @GetMapping(value = "/balance")
  public ResponseEntity<?> getAllBalance() {
    try {
      List<SaldoEntity> balance = saldoService.findAllBalance();
      return new ResponseEntity<List<SaldoEntity>>(balance, HttpStatus.OK);
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
  
  @GetMapping(value = "/balance-availability")
  public ResponseEntity<?> getAllBalanceAvailability() {
    try {
      List<SaldoEntity> balance = saldoService.findAllBalanceAvailability();
      return new ResponseEntity<List<SaldoEntity>>(balance, HttpStatus.OK);
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
  
  @GetMapping(value = "/balance-not-availability")
  public ResponseEntity<?> getAllNotBalanceAvailability() {
    try {
      List<SaldoEntity> balance = saldoService.findAllBalanceNotAvailability();
      return new ResponseEntity<List<SaldoEntity>>(balance, HttpStatus.OK);
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

  @PostMapping(value = "/create-balance")
  public ResponseEntity<?> createBalance(@RequestBody SaldoEntity saldo) {
    try {
      IdResponse idResultCreation = null;
      idResultCreation = saldoService.createBalance(saldo);
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


  @PutMapping(value = "/update-balance")
  public ResponseEntity<?> updateBalance(@RequestBody SaldoEntity saldo) {
    try {
      Boolean idResultUpdate = saldoService.updateBalance(saldo);
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

  @DeleteMapping(value = "/delete-balance/{id}")
  public ResponseEntity<?> deleteBalance(@PathVariable Integer id) {
    try {
      Boolean idResultUpdate = saldoService.deleteBalance(id);
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

}