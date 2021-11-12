package com.duoc.feriavirtual.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;

@Entity(name = "DETALLE_RUTA")
@NamedStoredProcedureQueries({})
public class DetalleRutaEntity implements Serializable {
  @Id
  @Column(name = "ID_DETALLE_RUTA")
  private Integer idDetalleRuta;

  @Column(name = "ID_RUTA")
  private Integer idRuta;

  @Column(name = "DIRECCION_PARTIDA")
  private String direccionPartida;

  @Column(name = "DIRECCION_DESTINO")
  private String direccionDestino;

  @Column(name = "FECHA_RETIRO")
  private Date fechaRetiro;

  @Column(name = "OBSERVACION")
  private String observacion;

  public Integer getIdDetalleRuta() {
    return idDetalleRuta;
  }

  public void setIdDetalleRuta(Integer idDetalleRuta) {
    this.idDetalleRuta = idDetalleRuta;
  }

  public Integer getIdRuta() {
    return idRuta;
  }

  public void setIdRuta(Integer idRuta) {
    this.idRuta = idRuta;
  }

  public String getDireccionPartida() {
    return direccionPartida;
  }

  public void setDireccionPartida(String direccionPartida) {
    this.direccionPartida = direccionPartida;
  }

  public String getDireccionDestino() {
    return direccionDestino;
  }

  public void setDireccionDestino(String direccionDestino) {
    this.direccionDestino = direccionDestino;
  }

  public Date getFechaRetiro() {
    return fechaRetiro;
  }

  public void setFechaRetiro(Date fechaRetiro) {
    this.fechaRetiro = fechaRetiro;
  }

  public String getObservacion() {
    return observacion;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }
}
