package com.duoc.feriavirtual.services;

import java.util.Map;

import com.duoc.feriavirtual.entities.UsuarioEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.exceptions.UserNotFoundException;
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

    public String loginUser(UsuarioModel usuario) throws NotFoundComponentFeriaVirtualException {
        try {
            UsuarioEntity newUsuarioEntity = new UsuarioEntity();
            newUsuarioEntity.setCorreo(usuario.getCorreo());
            newUsuarioEntity.setContrasena(usuario.getContrasena());
            newUsuarioEntity.setIdTipoUsuario(usuario.getIdTipoUsuario());
            LOGGER.debug("UsuarioService correo: " + newUsuarioEntity.getCorreo());
            LOGGER.debug("UsuarioService contrasena: " + newUsuarioEntity.getContrasena());
            LOGGER.debug("UsuarioService idTipoUsuario: " + newUsuarioEntity.getIdTipoUsuario());

            Map<String, Object> resultLoginProcedure = usuarioRepository.loginUser(newUsuarioEntity.getIdTipoUsuario(),
                    newUsuarioEntity.getCorreo(), newUsuarioEntity.getContrasena());

            Integer statusOut = (Integer) resultLoginProcedure.get("STATUS_OUT");
            String tipoUsuarioOut = (String) resultLoginProcedure.get("TIPO_USUARIO_OUT");
            LOGGER.debug("UsuarioService resultLoginProcedure: " + resultLoginProcedure);
            LOGGER.debug("UsuarioService statusOut: " + statusOut);
            LOGGER.debug("UsuarioService tipoUsuarioOut: " + tipoUsuarioOut);

            if (statusOut == 0) {
                throw new UserNotFoundException("USER NOT FOUND");
            } else {
                return tipoUsuarioOut;
            }

        } catch (UserNotFoundException exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
    }
}
