package com.duoc.feriavirtual.repositories;



import java.util.Map;

import com.duoc.feriavirtual.entities.TransportistaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface TransportistaRepository extends JpaRepository<TransportistaEntity, Long> {
    @Procedure(name = "Transportista.create")
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
    
}
