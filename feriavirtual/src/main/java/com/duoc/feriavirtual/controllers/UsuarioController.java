package com.duoc.feriavirtual.controllers;

import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.models.UsuarioModel;
import com.duoc.feriavirtual.services.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> postMethodName(@RequestBody UsuarioModel usuario) {
        LOGGER.debug("Bienvenido al login:");
        LOGGER.debug("Controller getCorreo:" + usuario.getCorreo());
        LOGGER.debug("Controller getContrasena:" + usuario.getContrasena());
        try {

            String profileResult = usuarioService.loginUser(usuario);
            LOGGER.debug("Controller profileResult:" + profileResult);
            return new ResponseEntity<String>(profileResult, HttpStatus.ACCEPTED);
        } catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
