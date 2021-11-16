package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "TIPO_CAMION")
@NamedStoredProcedureQueries({})
public class TipoCamionEntity implements Serializable{
    @Id
    @Column(name = "ID_TIPO_CAMION")
    private Integer idTipoCamion;
    @Column(name = "REFRIGERACION")
    private String refrigeracion;
    @Column(name = "CAPACIDAD_KG")
    private Integer capacidad;
    public Integer getIdTipoCamion() {
        return idTipoCamion;
    }
    public void setIdTipoCamion(Integer idTipoCamion) {
        this.idTipoCamion = idTipoCamion;
    }
    public String getRefrigeracion() {
        return refrigeracion;
    }
    public void setRefrigeracion(String refrigeracion) {
        this.refrigeracion = refrigeracion;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
