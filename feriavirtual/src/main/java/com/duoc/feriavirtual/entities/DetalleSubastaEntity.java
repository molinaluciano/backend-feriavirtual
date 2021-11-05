package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "DETALLE_SUBASTA")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "Detalle_subasta.participar", procedureName = "FV_TRA_AUCTION_PARTICIPATION", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SUBASTA_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_CAMION_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "PRECIO_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ID_RESULT_OUT", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
})
public class DetalleSubastaEntity implements Serializable{
    @Id
    @Column(name = "ID_DETALLE_SUBASTA")
    private Integer idDetalleSubasta;
    @Column(name = "ID_SUBASTA")
    private Integer idSubasta;
    @Column(name = "ID_CAMION")
    private Integer idCamion;
    @Column(name = "PRECIO")
    private Integer precio;
    public Integer getIdDetalleSubasta() {
        return idDetalleSubasta;
    }
    public void setIdDetalleSubasta(Integer idDetalleSubasta) {
        this.idDetalleSubasta = idDetalleSubasta;
    }
    public Integer getIdSubasta() {
        return idSubasta;
    }
    public void setIdSubasta(Integer idSubasta) {
        this.idSubasta = idSubasta;
    }
    public Integer getIdCamion() {
        return idCamion;
    }
    public void setIdCamion(Integer idCamion) {
        this.idCamion = idCamion;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    
       
}
