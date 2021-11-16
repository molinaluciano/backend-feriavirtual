package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "CALIDAD")
@NamedStoredProcedureQueries({})
public class CalidadEntity implements Serializable{
    @Id
    @Column(name = "ID_CALIDAD")
    private Integer idCalidad;
    @Column(name = "CALIDAD")
    private String calidad;
    public Integer getIdCalidad() {
        return idCalidad;
    }
    public void setIdCalidad(Integer idCalidad) {
        this.idCalidad = idCalidad;
    }
    public String getCalidad() {
        return calidad;
    }
    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
    
    
}
