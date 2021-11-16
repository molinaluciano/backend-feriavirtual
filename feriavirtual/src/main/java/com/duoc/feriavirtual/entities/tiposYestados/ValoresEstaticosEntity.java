package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "VALORES_ESTATICO")
@NamedStoredProcedureQueries({})
public class ValoresEstaticosEntity implements Serializable{
    @Id
    @Column(name = "ID_VALOR_ESTATICO")
    private Integer idValorEstatico;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "VALOR")
    private Integer valor;
    public Integer getIdValorEstatico() {
        return idValorEstatico;
    }
    public void setIdValorEstatico(Integer idValorEstatico) {
        this.idValorEstatico = idValorEstatico;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
    
}
