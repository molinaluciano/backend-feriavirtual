package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "TAMANO_CAMION")
@NamedStoredProcedureQueries({})
public class TamanoCamionEntity implements Serializable{
    @Id
    @Column(name = "ID_TAMANO_CAMION")
    private Integer idTamanoCamion;
    @Column(name = "TAMANO")
    private String tamano;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    public Integer getIdTamanoCamion() {
        return idTamanoCamion;
    }
    public void setIdTamanoCamion(Integer idTamanoCamion) {
        this.idTamanoCamion = idTamanoCamion;
    }
    public String getTamano() {
        return tamano;
    }
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
