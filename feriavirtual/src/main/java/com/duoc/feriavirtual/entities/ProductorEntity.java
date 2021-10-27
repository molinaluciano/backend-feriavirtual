package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "PRODUCTOR")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "Productor.create", procedureName = "FV_ADM_CREATE_USER", parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TIPO_USUARIO_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PAIS_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBRE_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "APELLIDO_PATERNO_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "APELLIDO_MATERNO_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "CORREO_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "CONTRASENA_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "RUT_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "NUMER_IDENTIFICADOR_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "DIRECCION_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIGO_POSTAL_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "TELEFONO_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_CONTRATO_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ID_RESULT_OUT", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class)
    }),
    @NamedStoredProcedureQuery(name = "Productor.update", procedureName = "FV_ADM_UPDATE_USER", parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "NOMBRE_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "APELLIDO_PATERNO_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "APELLIDO_MATERNO_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "CORREO_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "CONTRASENA_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "RUT_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "NUMERO_IDENTIFICADOR_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "DIRECCION_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "CODIGO_POSTAL_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "TELEFONO_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_CONTRATO_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class)
    }),
})
public class ProductorEntity implements Serializable {
    @Id
    @Column(name = "ID_PRODUCTOR")
    private Long idUsuario;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name = "RUT")
    private Integer rut;
    @Column(name = "NUMERO_IDENTIFICADOR")
    private String numeroIdentificador;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "CODIGO_POSTAL")
    private Integer codigoPostal;
    @Column(name = "TELEFONO")
    private Integer telefono;
    @Column(name = "ID_CONTRATO")
    private Integer idContrato;

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNumeroIdentificador() {
        return numeroIdentificador;
    }

    public void setNumeroIdentificador(String numeroIdentificador) {
        this.numeroIdentificador = numeroIdentificador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

}
