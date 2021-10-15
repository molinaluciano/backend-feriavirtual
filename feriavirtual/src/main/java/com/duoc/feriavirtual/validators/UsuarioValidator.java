package com.duoc.feriavirtual.validators;

import java.util.List;

import com.duoc.feriavirtual.exceptions.UserNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioValidator.class);

    public void validateSelectUser(List<?> listUsers) throws UserNotFoundException{
        if(listUsers.isEmpty()){
            LOGGER.debug("No se ha encontrado el tipo de usuario");
            throw new UserNotFoundException("Usuarios no encontrados");
        }
    }
}
