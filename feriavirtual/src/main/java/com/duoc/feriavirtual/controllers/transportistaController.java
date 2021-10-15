package com.duoc.feriavirtual.controllers;

import java.util.List;

import com.duoc.feriavirtual.entities.TransportistaEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.services.TransportistaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class transportistaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(transportistaController.class);

    @Autowired
    TransportistaService transportistaService;

 

    @GetMapping(value = "/select-carrier")
    public ResponseEntity<?> postMethodName() {
        try {
            
            List<TransportistaEntity>  users = transportistaService.selectCarrier();
            return new ResponseEntity<List<TransportistaEntity>  >(users, HttpStatus.OK);
        } catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
