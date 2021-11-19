package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "PAIS")
public class PaisEntity implements Serializable {
    @Id
    @Column(name = "ID_PAIS")
    private Integer idPais;
    @Column(name = "NOMBRE")
    private String nombre;
    public Integer getIdPais() {
        return idPais;
    }
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    
   
}
