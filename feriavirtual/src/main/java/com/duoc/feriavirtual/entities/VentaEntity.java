package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "VENTA")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "Venta.updateState", procedureName = "FV_ADM_UPDATE_SALE_STATES", parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_VENTA_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ESTADO_VENTA_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
    @NamedStoredProcedureQuery(name = "Venta.finishSale", procedureName = "FV_FINISH_SALE", parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_VENTA_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "RESPONSE_CODE_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
})
public class VentaEntity implements Serializable {
    @Id
    @Column(name = "ID_VENTA")
    private Integer idVenta;
    @Column(name = "ID_SOLICITUD")
    private Integer idSolicitud;
    @Column(name = "ID_TIPO_PAGO")
    private Integer idTipoPago;
    @Column(name = "ID_ESTADO_VENTA")
    private Integer idEstadoVenta;

    @JoinColumn(name = "ID_VENTA")
    @OneToOne()
    private DetalleVentaEntity detalleVenta;
    
 
  
 

    public DetalleVentaEntity getDetalleVenta() {
        return detalleVenta;
    }
    public void setDetalleVenta(DetalleVentaEntity detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
    public Integer getIdVenta() {
        return idVenta;
    }
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Integer getIdSolicitud() {
        return idSolicitud;
    }
    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    public Integer getIdTipoPago() {
        return idTipoPago;
    }
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    public Integer getIdEstadoVenta() {
        return idEstadoVenta;
    }
    public void setIdEstadoVenta(Integer idEstadoVenta) {
        this.idEstadoVenta = idEstadoVenta;
    }
    
}
