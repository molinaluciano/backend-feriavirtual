package com.duoc.feriavirtual.services;

import java.util.List;
import java.util.Map;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.UsuarioEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.exceptions.UserNotFoundException;
import com.duoc.feriavirtual.models.UsuarioModel;
import com.duoc.feriavirtual.models.modelResponse.LoginResponse;
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
    @Autowired
    CommonConverter commonConverter;

    public LoginResponse loginUser(UsuarioModel usuario) throws NotFoundComponentFeriaVirtualException {
        try {
            UsuarioEntity newUsuarioEntity = commonConverter.convertUsuarioModelToEntity(usuario);

            Map<String, Object> resultLoginProcedure = usuarioRepository.loginUser(newUsuarioEntity.getCorreo(),
                    newUsuarioEntity.getContrasena());
            LoginResponse loginResponse = commonConverter.converterResponsePLToLoginResponse(resultLoginProcedure);

            if (loginResponse.getStatus_out() == 0) {
                throw new UserNotFoundException("USER NOT FOUND");
            } else {
                return loginResponse;
            }

        } catch (UserNotFoundException exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
    }

    public String selectUsersByIdType(Integer idType) {
        List<UsuarioEntity> resultSelectProcedure = usuarioRepository.selectUserByIdType();
        LOGGER.debug("resultSelectProcedure: " + resultSelectProcedure);
        // LOGGER.debug(
        // "resultSelectProcedure: " +
        // resultSelectProcedure.getOrDefault("STATUS_RESULT_OUT", "defaultValue"));
        // LOGGER.debug("resultSelectProcedure.toString(): " +
        // resultSelectProcedure.toString());

        // Integer statusResultOut = (Integer)
        // resultSelectProcedure.get("STATUS_RESULT_OUT");
        // List<UsuarioEntity> cursor = (List<UsuarioEntity>)
        // resultSelectProcedure.get("STATUS_RESULT_OUT");
        // Integer cursorResultOut = (Integer)
        // resultSelectProcedure.get("CURSOR_RESULT_OUT");
        // LOGGER.debug("USUARIO SERVICE statusResultOut: " + statusResultOut);
        // LOGGER.debug("USUARIO SERVICE cursor: " + cursor);
        // LOGGER.debug("cursorResultOut: " + cursorResultOut);

        return null;
    }
}
