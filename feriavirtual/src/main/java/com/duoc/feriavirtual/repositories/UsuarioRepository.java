package com.duoc.feriavirtual.repositories;

import java.util.List;
import java.util.Map;

import com.duoc.feriavirtual.entities.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Procedure(name = "Usuario.login")
    Map<String, Object> loginUser(@Param("CORREO_IN") String correo, @Param("CONTRASENA_IN") String contrasena);

   
    List<UsuarioEntity> findByidTipoUsuario (Integer idTipoUsuario);
}
