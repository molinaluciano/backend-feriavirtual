package com.duoc.feriavirtual.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.OneToMany;

@Entity(name = "RUTA")
@NamedStoredProcedureQueries({})
public class RutaEntity implements Serializable {
  @Id
  @Column(name = "ID_RUTA")
  private Integer idRuta;

  @Column(name = "ID_SUBASTA")
  private Integer idsubasta;

  @OneToMany
  @JoinColumn(name = "ID_RUTA")
  private List<DetalleRutaEntity> detallesRuta;

  public List<DetalleRutaEntity> getDetallesRuta() {
    return detallesRuta;
  }

  public void setDetallesRuta(List<DetalleRutaEntity> detallesRuta) {
    this.detallesRuta = detallesRuta;
  }

  public Integer getIdRuta() {
    return idRuta;
  }

  public void setIdRuta(Integer idRuta) {
    this.idRuta = idRuta;
  }

  public Integer getIdsubasta() {
    return idsubasta;
  }

  public void setIdsubasta(Integer idsubasta) {
    this.idsubasta = idsubasta;
  }
}
