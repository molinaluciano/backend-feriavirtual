package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "CATEGORIA_FRUTA")
@NamedStoredProcedureQueries({})
public class CategoriaFrutaEntity implements Serializable{
    @Id
    @Column(name = "ID_CATEGORIA_FRUTA")
    private Integer idCategoriaFruta;
    @Column(name = "CATEGORIA")
    private String categoria;
    public Integer getIdCategoriaFruta() {
        return idCategoriaFruta;
    }
    public void setIdCategoriaFruta(Integer idCategoriaFruta) {
        this.idCategoriaFruta = idCategoriaFruta;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
