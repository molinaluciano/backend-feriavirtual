package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "ESTADO_VENTA")
@NamedStoredProcedureQueries({})
public class EstadoVentaEntity implements Serializable{
    @Id
    @Column(name = "ID_ESTADO_VENTA")
    private Integer idEstadoVenta;
    @Column(name = "ESTADO")
    private String estado;
    public Integer getIdEstadoVenta() {
        return idEstadoVenta;
    }
    public void setIdEstadoVenta(Integer idEstadoVenta) {
        this.idEstadoVenta = idEstadoVenta;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
