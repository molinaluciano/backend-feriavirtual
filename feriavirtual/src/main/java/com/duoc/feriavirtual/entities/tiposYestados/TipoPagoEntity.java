package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "TIPO_PAGO")
@NamedStoredProcedureQueries({})
public class TipoPagoEntity implements Serializable{
    @Id
    @Column(name = "ID_TIPO_PAGO")
    private Integer idTipoPago;
    @Column(name = "TIPO_PAGO")
    private String tipoPago;
    public Integer getIdTipoPago() {
        return idTipoPago;
    }
    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
    public String getTipoPago() {
        return tipoPago;
    }
    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    
}
