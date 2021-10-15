package com.duoc.feriavirtual.services;

import java.util.List;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.TransportistaEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.exceptions.UserNotFoundException;
import com.duoc.feriavirtual.repositories.TransportistaRepository;
import com.duoc.feriavirtual.validators.UsuarioValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportistaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransportistaService.class);

    @Autowired
    TransportistaRepository transportistaRepository;
    @Autowired
    CommonConverter commonConverter;
    @Autowired
    UsuarioValidator usuarioValidator;

 
    public List<TransportistaEntity>  selectCarrier() throws  NotFoundComponentFeriaVirtualException{
        try {
           
            List<TransportistaEntity>  resultSelectCarrier = ( List<TransportistaEntity> )  transportistaRepository.findAll();
            usuarioValidator.validateSelectUser(resultSelectCarrier);
            return resultSelectCarrier;
            
        } catch (UserNotFoundException exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
    }
}
