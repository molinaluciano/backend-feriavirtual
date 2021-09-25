package com.duoc.feriavirtual.controllers;

import com.duoc.feriavirtual.models.UsuarioModel;
import com.duoc.feriavirtual.services.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        LOGGER.debug("Controller getIdTipoUsuario:" + usuario.getIdTipoUsuario());
        LOGGER.debug("Controller getContrasena:" + usuario.getContrasena());

        Integer statusResult = usuarioService.loginUser(usuario);
        LOGGER.debug("Controller statusResult:" + statusResult);

        return new ResponseEntity<String>("ok", HttpStatus.CREATED);
    }
}
