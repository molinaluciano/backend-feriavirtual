package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;

import javax.persistence.Column;

@Entity(name = "CAMION")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "Camion.create", procedureName = "FV_TRA_CREATE_TRUCK", parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "PATENTE_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "MODELO_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "MARCA_IN", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "REVISION_TECNICA_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "DISPONIBILIDAD_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TIPO_CAMION_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TAMANO_CAMION_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TRANSPORTISTA_IN", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ID_RESULT_OUT", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
    @NamedStoredProcedureQuery(name = "Camion.update", procedureName = "FV_TRA_UPDATE_TRUCK", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "PATENTE_IN", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "MODELO_IN", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "MARCA_IN", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "REVISION_TECNICA_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "DISPONIBILIDAD_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TIPO_CAMION_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TAMANO_CAMION_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TRANSPORTISTA_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
    @NamedStoredProcedureQuery(name = "Camion.delete", procedureName = "FV_TRA_DELETE_TRUCK", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_CAMION_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class),
    }),
})
public class CamionEntity implements Serializable{
    @Id
    @Column(name = "ID_CAMION")
    private Integer idCamion;
    @Column(name = "ID_TIPO_CAMION")
    private Integer idTipoCamion;
    @Column(name = "ID_TAMANO_CAMION")
    private Integer idTamanoCamion;
    @Column(name = "PATENTE")
    private String patente;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "REVISION_TECNICA")
    private Integer revisionTecnica;
    @Column(name = "ID_TRANSPORTISTA")
    private Integer idTransportista;
    @Column(name = "DISPONIBILIDAD")
    private Integer disponibilidad;
    public Integer getIdCamion() {
        return idCamion;
    }
    public void setIdCamion(Integer idCamion) {
        this.idCamion = idCamion;
    }
    public Integer getIdTipoCamion() {
        return idTipoCamion;
    }
    public void setIdTipoCamion(Integer idTipoCamion) {
        this.idTipoCamion = idTipoCamion;
    }
    public Integer getIdTamanoCamion() {
        return idTamanoCamion;
    }
    public void setIdTamanoCamion(Integer idTamanoCamion) {
        this.idTamanoCamion = idTamanoCamion;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Integer getRevisionTecnica() {
        return revisionTecnica;
    }
    public void setRevisionTecnica(Integer revisionTecnica) {
        this.revisionTecnica = revisionTecnica;
    }
    public Integer getIdTransportista() {
        return idTransportista;
    }
    public void setIdTransportista(Integer idTransportista) {
        this.idTransportista = idTransportista;
    }
    public Integer getDisponibilidad() {
        return disponibilidad;
    }
    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    
}
