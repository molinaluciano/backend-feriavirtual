package com.duoc.feriavirtual.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.duoc.feriavirtual.entities.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Procedure(name = "Usuario.login")
    Map<String, Object> loginUser(@Param("CORREO_IN") String correo, @Param("CONTRASENA_IN") String contrasena);

    @Procedure(name = "Usuario.create")
    Map<String, Object> createUser(
        @Param("ID_TIPO_USUARIO_IN") Integer idTipoUsuario, 
        @Param("ID_PAIS_IN") Integer idPais, 
        @Param("NOMBRE_IN") String nombre, 
        @Param("APELLIDO_PATERNO_IN") String apellidoPaterno, 
        @Param("APELLIDO_MATERNO_IN") String apellidoMaterno, 
        @Param("CORREO_IN") String correo,    
        @Param("CONTRASENA_IN") String contrasena,    
        @Param("RUT_IN") Integer rut,    
        @Param("NUMER_IDENTIFICADOR_IN") String numeroIdentificador,    
        @Param("DIRECCION_IN") String direccion,    
        @Param("CODIGO_POSTAL_IN") Integer codigoPostal,    
        @Param("TELEFONO_IN") Integer telefono,    
        @Param("ID_CONTRATO_IN") Integer idContrato    
    );

    @Procedure(name = "Usuario.delete")
    Integer deleteUser(
        @Param("ID_TIPO_USUARIO_IN") Integer idTipoUsuario, 
        @Param("ID_USUARIO_IN") Integer idUsuario
    );

    List<UsuarioEntity> findByidTipoUsuario (Integer idTipoUsuario);

    Optional<UsuarioEntity> findByIdUsuario (Long idTipoUsuario);
}
