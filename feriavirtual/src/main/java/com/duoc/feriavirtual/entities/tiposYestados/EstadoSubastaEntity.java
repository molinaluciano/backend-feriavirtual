package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "ESTADO_SUBASTA")
@NamedStoredProcedureQueries({})
public class EstadoSubastaEntity implements Serializable{
    @Id
    @Column(name = "ID_ESTADO_SUBASTA")
    private Integer idEstadoSubasta;
    @Column(name = "ESTADO")
    private String estado;
    public Integer getIdEstadoSubasta() {
        return idEstadoSubasta;
    }
    public void setIdEstadoSubasta(Integer idEstadoSubasta) {
        this.idEstadoSubasta = idEstadoSubasta;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
