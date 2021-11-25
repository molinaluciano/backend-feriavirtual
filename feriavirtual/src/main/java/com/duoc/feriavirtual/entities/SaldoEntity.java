package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "SALDO")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "Saldo.createBalance", procedureName = "FV_ADM_CREATE_BALANCE", parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_FRUTA_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_CALIDAD_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_CLIENTE_COMPRADOR_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "DISPONIBLE_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "KILOS_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "PRECIO_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ID_RESULT_OUT", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
    @NamedStoredProcedureQuery(name = "Saldo.updateBalance", procedureName = "FV_ADM_UPDATE_BALANCE", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SALDO_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_FRUTA_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_CALIDAD_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_CLIENTE_COMPRADOR_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "DISPONIBLE_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "KILOS_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "PRECIO_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
    @NamedStoredProcedureQuery(name = "Saldo.deleteBalance", procedureName = "FV_ADM_DELETE_BALANCE", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SALDO_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
})
public class SaldoEntity implements Serializable {
    @Id
    @Column(name = "ID_SALDO")
    private Integer idSaldo;
    @Column(name = "KILOS")
    private Integer kilos;
    @Column(name = "DISPONIBLE")
    private Integer disponible;
    @Column(name = "ID_CLIENTE_COMPRADOR")
    private Integer idCliente;
    @Column(name = "ID_FRUTA")
    private Integer idFruta;
    @Column(name = "ID_CALIDAD")
    private Integer idCalidad;
    @Column(name = "PRECIO")
    private Integer precio;

    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Integer getIdSaldo() {
        return idSaldo;
    }
    public void setIdSaldo(Integer idSaldo) {
        this.idSaldo = idSaldo;
    }
    public Integer getKilos() {
        return kilos;
    }
    public void setKilos(Integer kilos) {
        this.kilos = kilos;
    }
    public Integer getDisponible() {
        return disponible;
    }
    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Integer getIdFruta() {
        return idFruta;
    }
    public void setIdFruta(Integer idFruta) {
        this.idFruta = idFruta;
    }
    public Integer getIdCalidad() {
        return idCalidad;
    }
    public void setIdCalidad(Integer idCalidad) {
        this.idCalidad = idCalidad;
    }

    
        
}
