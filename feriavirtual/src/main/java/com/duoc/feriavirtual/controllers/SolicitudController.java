package com.duoc.feriavirtual.controllers;

import java.util.List;

import com.duoc.feriavirtual.entities.SolicitudEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.services.SolicitudService;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(SolicitudController.class);

    @Autowired
   SolicitudService solicitudService;

   
    @GetMapping(value = "/requests/{id}")
    public ResponseEntity<?> postMethodName(@PathVariable Integer id) {
        LOGGER.debug("CONTROLLER ID:" + id);
        try {
            
            List<SolicitudEntity>  requests = solicitudService.selectRequestsByidStatus(id);
            return new ResponseEntity<List<SolicitudEntity> >(requests, HttpStatus.OK);
        } catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        
        } catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(value = "/update-status-request")
    public ResponseEntity<?> updateStatusRequest(@RequestBody SolicitudEntity solicitud) {
        try {
            
            Boolean  resultUpdate = solicitudService.updateStatusRequest(solicitud);
            return new ResponseEntity<Boolean >(resultUpdate, HttpStatus.OK);
        } catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        
        } catch (InvalidModelException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
