package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

@Entity(name = "DETALLE_VENTA")
@NamedStoredProcedureQueries({
 
})
public class DetalleVentaEntity implements Serializable {
    @Id
    @Column(name = "ID_DETALLE_VENTA")
    private Integer idDetalleVenta;
    @Column(name = "ID_VENTA")
    private Integer idVenta;
    @Column(name = "PRECIO_BRUTO")
    private Integer precioBruto;
    @Column(name = "PRECIO_NETO")
    private Integer precioNeto;
    @Column(name = "FECHA_INCIO")
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    private Date fechaFin;
    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }
    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }
    public Integer getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Integer getPrecioBruto() {
        return precioBruto;
    }
    public void setPrecioBruto(Integer precioBruto) {
        this.precioBruto = precioBruto;
    }
    public Integer getPrecioNeto() {
        return precioNeto;
    }
    public void setPrecioNeto(Integer precioNeto) {
        this.precioNeto = precioNeto;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

   
    
}
