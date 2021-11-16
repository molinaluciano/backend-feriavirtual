package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "TIPO_SOLICITUD")
@NamedStoredProcedureQueries({})
public class TipoSolicitudEntity implements Serializable{
    @Id
    @Column(name = "ID_TIPO_SOLICITUD")
    private Integer idTipoSolicitud;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    public Integer getIdTipoSolicitud() {
        return idTipoSolicitud;
    }
    public void setIdTipoSolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
