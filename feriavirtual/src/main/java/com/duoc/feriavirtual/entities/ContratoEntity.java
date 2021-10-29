package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "CONTRATO")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "Contrato.create", procedureName = "FV_ADM_CREATE_CONTRACT", parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "DESCRIPCION_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "FIRMAS_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ESTADO_CONTRATO_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ID_RESULT_OUT", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
})
public class ContratoEntity implements Serializable {
    @Id
    @Column(name = "ID_CONTRATO")
    private Integer idContrato;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA_EMISION")
    private String fechaEmision;
    @Column(name = "FECHA_EXPIRACION")
    private String fechaExpiracion;
    @Column(name = "FIRMAS")
    private String firmas;
    @Column(name = "ID_ESTADO_CONTRATO")
    private Integer idEstadoContrato;
    public Integer getIdContrato() {
        return idContrato;
    }
    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    public String getFirmas() {
        return firmas;
    }
    public void setFirmas(String firmas) {
        this.firmas = firmas;
    }
    public Integer getIdEstadoContrato() {
        return idEstadoContrato;
    }
    public void setIdEstadoContrato(Integer idEstadoContrato) {
        this.idEstadoContrato = idEstadoContrato;
    }
   
    
}
