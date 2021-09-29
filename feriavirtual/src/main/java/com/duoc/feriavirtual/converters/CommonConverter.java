package com.duoc.feriavirtual.converters;

import java.util.Map;

import com.duoc.feriavirtual.entities.UsuarioEntity;
import com.duoc.feriavirtual.models.UsuarioModel;
import com.duoc.feriavirtual.models.modelResponse.LoginResponse;

import org.springframework.stereotype.Component;

@Component
public class CommonConverter {

    public LoginResponse converterResponsePLToLoginResponse(Map<String, Object> response) {
        LoginResponse newResponse = new LoginResponse();
        Integer statusOut = (Integer) response.get("STATUS_OUT");
        String tipoUsuarioOut = (String) response.get("TIPO_USUARIO_OUT");
        Integer idUsuarioOut = (Integer) response.get("ID_USUARIO_OUT");

        newResponse.setId_usuario_out(idUsuarioOut);
        newResponse.setStatus_out(statusOut);
        newResponse.setTipo_usuario_out(tipoUsuarioOut);

        return newResponse;
    }

    public UsuarioEntity convertUsuarioModelToEntity(UsuarioModel usuario) {
        UsuarioEntity newUsuarioEntity = new UsuarioEntity();
        newUsuarioEntity.setCorreo(usuario.getCorreo());
        newUsuarioEntity.setContrasena(usuario.getContrasena());
        newUsuarioEntity.setIdTipoUsuario(usuario.getIdTipoUsuario());
        return newUsuarioEntity;
    }

}
