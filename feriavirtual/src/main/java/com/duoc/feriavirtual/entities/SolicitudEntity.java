package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

@Entity(name = "SOLICITUD")
public class SolicitudEntity implements Serializable {
    @Id
    @Column(name = "ID_SOLICITUD")
    private Long idSolicitud;
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Column(name = "ID_ESTADO_SOLICITUD")
    private Integer idEstadoSolicitud;
    @Column(name = "PRODUCTOR_SELECCIONADO")
    private Integer productorSeleccionado;
    @Column(name = "FECHA_PUBLICACION")
    private Date fechaPublicacion;
    public Long getIdSolicitud() {
        return idSolicitud;
    }
    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Integer getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }
    public void setIdEstadoSolicitud(Integer idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }
    public Integer getProductorSeleccionado() {
        return productorSeleccionado;
    }
    public void setProductorSeleccionado(Integer productorSeleccionado) {
        this.productorSeleccionado = productorSeleccionado;
    }
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
   
}
