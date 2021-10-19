package com.duoc.feriavirtual.services;

import java.util.List;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.ProductorEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.exceptions.UserNotFoundException;
import com.duoc.feriavirtual.repositories.ProductorRepository;
import com.duoc.feriavirtual.validators.UsuarioValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductorService.class);

    @Autowired
    ProductorRepository productorRepository;
    @Autowired
    CommonConverter commonConverter;
    @Autowired
    UsuarioValidator usuarioValidator;

 
    public List<ProductorEntity>  selectProducers() throws  NotFoundComponentFeriaVirtualException{
        try {
           
            List<ProductorEntity>  resultSelectProducer = ( List<ProductorEntity> )  productorRepository.findAll();
            usuarioValidator.validateSelectUser(resultSelectProducer);
            return resultSelectProducer;
            
        } catch (UserNotFoundException exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
    }
}
