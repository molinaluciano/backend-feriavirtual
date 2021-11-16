package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "ESTADO_CONTRATO")
@NamedStoredProcedureQueries({})
public class EstadoContratoEntity implements Serializable{
    @Id
    @Column(name = "ID_ESTADO_CONTRATO")
    private Integer idEstadoContrato;
    @Column(name = "ESTADO")
    private String estado;
    public Integer getIdEstadoContrato() {
        return idEstadoContrato;
    }
    public void setIdEstadoContrato(Integer idEstadoContrato) {
        this.idEstadoContrato = idEstadoContrato;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
