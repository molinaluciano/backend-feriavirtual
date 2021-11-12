package com.duoc.feriavirtual.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.OneToMany;

@Entity(name = "SUBASTA")
@NamedStoredProcedureQueries({})
public class SubastaEntity implements Serializable {
  @Id
  @Column(name = "ID_SUBASTA")
  private Integer idSubasta;

  @Column(name = "ID_SOLICITUD")
  private Integer idSolicitud;

  @Column(name = "ID_ESTADO_SUBASTA")
  private Integer idEstadoSubasta;

  @Column(name = "FECHA_PUBLICACION")
  private Date fechaPublicacion;

  @Column(name = "FECHA_TERMINO")
  private Date fechaTermino;

  @Column(name = "CAMION_SELECCIONADO")
  private String camionSeleccionado;

  @OneToMany
  @JoinColumn(name = "ID_SUBASTA")
  private List<RutaEntity> rutas;

  public List<RutaEntity> getRutas() {
    return rutas;
  }

  public void setRutas(List<RutaEntity> rutas) {
    this.rutas = rutas;
  }

  public Integer getIdSubasta() {
    return idSubasta;
  }

  public void setIdSubasta(Integer idSubasta) {
    this.idSubasta = idSubasta;
  }

  public Integer getIdSolicitud() {
    return idSolicitud;
  }

  public void setIdSolicitud(Integer idSolicitud) {
    this.idSolicitud = idSolicitud;
  }

  public Integer getIdEstadoSubasta() {
    return idEstadoSubasta;
  }

  public void setIdEstadoSubasta(Integer idEstadoSubasta) {
    this.idEstadoSubasta = idEstadoSubasta;
  }

  public Date getFechaPublicacion() {
    return fechaPublicacion;
  }

  public void setFechaPublicacion(Date fechaPublicacion) {
    this.fechaPublicacion = fechaPublicacion;
  }

  public Date getFechaTermino() {
    return fechaTermino;
  }

  public void setFechaTermino(Date fechaTermino) {
    this.fechaTermino = fechaTermino;
  }

  public String getCamionSeleccionado() {
    return camionSeleccionado;
  }

  public void setCamionSeleccionado(String camionSeleccionado) {
    this.camionSeleccionado = camionSeleccionado;
  }
}
