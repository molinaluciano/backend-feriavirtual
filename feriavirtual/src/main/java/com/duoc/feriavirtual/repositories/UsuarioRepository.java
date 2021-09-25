package com.duoc.feriavirtual.repositories;

import java.util.Map;

import com.duoc.feriavirtual.entities.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Procedure(name = "Usuario.login")
    Map<String, Object> loginUser(@Param("ID_TIPO_USUARIO_IN") Integer idTipoUsuario);

}
