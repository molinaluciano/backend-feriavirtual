package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "Usuario")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Usuario.login", procedureName = "FV_LOGIN", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "CORREO_IN", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "CONTRASENA_IN", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TIPO_USUARIO_IN", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_OUT", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "TIPO_USUARIO_OUT", type = String.class), }) })
public class UsuarioEntity implements Serializable {
    @Id
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Column(name = "ID_TIPO_USUARIO")
    private Integer idTipoUsuario;
    @Column(name = "ID_PAIS")
    private Integer idPais;
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
    private String codigoPostal;
    @Column(name = "TELEFONO")
    private Integer telefono;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

}
