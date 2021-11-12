package com.duoc.feriavirtual.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;

@Entity(name = "DETALLE_SOLICITUD")
@NamedStoredProcedureQueries({})
public class DetalleSolicitudEntity implements Serializable {
  @Id
  @Column(name = "ID_DETALLE_SOLICITUD")
  private Integer idDetalleSolicitud;

  @Column(name = "ID_SOLICITUD")
  private Integer idSolicitud;

  @Column(name = "ID_FRUTA")
  private Integer idFruta;

  @Column(name = "ID_CALIDAD")
  private Integer idCalidad;

  @Column(name = "KILOS")
  private String kilos;

  public Integer getIdDetalleSolicitud() {
    return idDetalleSolicitud;
  }

  public void setIdDetalleSolicitud(Integer idDetalleSolicitud) {
    this.idDetalleSolicitud = idDetalleSolicitud;
  }

  public Integer getIdSolicitud() {
    return idSolicitud;
  }

  public void setIdSolicitud(Integer idSolicitud) {
    this.idSolicitud = idSolicitud;
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

  public String getKilos() {
    return kilos;
  }

  public void setKilos(String kilos) {
    this.kilos = kilos;
  }
}
