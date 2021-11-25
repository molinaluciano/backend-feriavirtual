package com.duoc.feriavirtual.controllers;

import java.util.List;

import com.duoc.feriavirtual.entities.ContratoEntity;
import com.duoc.feriavirtual.entities.ProductorEntity;
import com.duoc.feriavirtual.entities.ProductorSolicitudEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.services.ProductorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductorController.class);

    @Autowired
    ProductorService productorService;

 

    @GetMapping(value = "/select-producer")
    public ResponseEntity<?> postMethodName() {
        try {
            
            List<ProductorEntity>  users = productorService.selectProducers();
            return new ResponseEntity<List<ProductorEntity>  >(users, HttpStatus.OK);
        } catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-producer-request")
    public ResponseEntity<?> findAllProducerRequest() {
        try {
            
            List<ProductorSolicitudEntity>  users = productorService.findAllProducerRequest();
            return new ResponseEntity<List<ProductorSolicitudEntity>  >(users, HttpStatus.OK);
        } catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @PostMapping(value = "/create-contract")
    public ResponseEntity<?> postNewContract(@RequestBody ContratoEntity contract) {
        try {

            IdResponse idResultCreation = null;
            idResultCreation = productorService.createContract(contract);
            return new ResponseEntity<IdResponse>(idResultCreation, HttpStatus.CREATED);
        }catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        }catch(InvalidModelException exception){
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @PostMapping(value = "/participate-in-request")
    public ResponseEntity<?> participateInRequest(@RequestBody ProductorSolicitudEntity productorSolicitudEntity) {
        try {

            Boolean idResultCreation = productorService.participateInRequest(productorSolicitudEntity);
            return new ResponseEntity<Boolean>(idResultCreation, HttpStatus.CREATED);
        }catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        }catch(InvalidModelException exception){
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
}
