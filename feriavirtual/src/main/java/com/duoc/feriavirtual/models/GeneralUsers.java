package com.duoc.feriavirtual.models;

public class GeneralUsers {
    private Long idUsuario;
    private Integer idTipoUsuario;
    private Integer idPais;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String contrasena;
    private Integer rut;
    private String numeroIdentificador;
    private String direccion;
    private Integer codigoPostal;
    private Integer telefono;
    private Integer idContrato;

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
    public Integer getIdContrato() {
        return idContrato;
    }
    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }
    
}
