package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "ESTADO_SOLICITUD")
@NamedStoredProcedureQueries({})
public class EstadoSolicitudEntity implements Serializable{
    @Id
    @Column(name = "ID_ESTADO_SOLICITUD")
    private Integer idEstadoSolicitud;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    public Integer getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }
    public void setIdEstadoSolicitud(Integer idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
