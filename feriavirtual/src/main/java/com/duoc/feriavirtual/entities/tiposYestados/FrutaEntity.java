package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "FRUTA")
@NamedStoredProcedureQueries({})
public class FrutaEntity implements Serializable{
    @Id
    @Column(name = "ID_FRUTA")
    private Integer idFruta;
    @Column(name = "ID_CATEGORIA_FRUTA")
    private Integer idCategoriaFruta;
    @Column(name = "NOMBRE_FRUTA")
    private String nombreFruta;
    public Integer getIdFruta() {
        return idFruta;
    }
    public void setIdFruta(Integer idFruta) {
        this.idFruta = idFruta;
    }
    public Integer getIdCategoriaFruta() {
        return idCategoriaFruta;
    }
    public void setIdCategoriaFruta(Integer idCategoriaFruta) {
        this.idCategoriaFruta = idCategoriaFruta;
    }
    public String getNombreFruta() {
        return nombreFruta;
    }
    public void setNombreFruta(String nombreFruta) {
        this.nombreFruta = nombreFruta;
    }
    
    
}
