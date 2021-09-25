package com.duoc.feriavirtual.services;

import java.util.Map;

import com.duoc.feriavirtual.entities.UsuarioEntity;
import com.duoc.feriavirtual.models.UsuarioModel;
import com.duoc.feriavirtual.repositories.UsuarioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    UsuarioRepository usuarioRepository;

    public Integer loginUser(UsuarioModel usuario) {
        UsuarioEntity newUsuarioEntity = new UsuarioEntity();
        newUsuarioEntity.setCorreo(usuario.getCorreo());
        newUsuarioEntity.setContrasena(usuario.getContrasena());
        newUsuarioEntity.setIdTipoUsuario(usuario.getIdTipoUsuario());
        LOGGER.debug("UsuarioService correo: " + newUsuarioEntity.getCorreo());
        LOGGER.debug("UsuarioService contrasena: " + newUsuarioEntity.getContrasena());
        LOGGER.debug("UsuarioService idTipoUsuario: " + newUsuarioEntity.getIdTipoUsuario());

        Map<String, Object> resultLoginProcedure = usuarioRepository.loginUser(newUsuarioEntity.getIdTipoUsuario());
        // Integer statusOut = (Integer) resultLoginProcedure.get("STATUS_OUT");

        LOGGER.debug("UsuarioService resultLoginProcedure: " + resultLoginProcedure);

        return null;
    }
}
