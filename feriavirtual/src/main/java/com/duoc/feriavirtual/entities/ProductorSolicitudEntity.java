package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "PRODUCTOR_SOLICITUD")
@NamedStoredProcedureQueries({
   
    @NamedStoredProcedureQuery(name = "ProductorSolicitud.create", procedureName = "FV_PRO_REQUEST_PARTICIPATION", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SOLICITUD_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_PRODUCTOR_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "PRODUCTOR_PRICE_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
})
public class ProductorSolicitudEntity implements Serializable{
    @Id
    @Column(name = "ID_PRODUCTOR_SOLICITUD")
    private Integer idProductorSolicitud;
    @Column(name = "PRECIO")
    private Integer precio;
    @Column(name = "ID_PRODUCTOR")
    private Integer idProductor;
    @Column(name = "ID_SOLICITUD")
    private Integer idSolicitud;
    public Integer getIdProductorSolicitud() {
        return idProductorSolicitud;
    }
    public void setIdProductorSolicitud(Integer idProductorSolicitud) {
        this.idProductorSolicitud = idProductorSolicitud;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Integer getIdProductor() {
        return idProductor;
    }
    public void setIdProductor(Integer idProductor) {
        this.idProductor = idProductor;
    }
    public Integer getIdSolicitud() {
        return idSolicitud;
    }
    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
  
    
}
