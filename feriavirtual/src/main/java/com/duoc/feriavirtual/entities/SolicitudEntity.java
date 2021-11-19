package com.duoc.feriavirtual.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

@Entity(name = "SOLICITUD")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "Solicitud.cambiar_estado", procedureName = "FV_ADM_UPDATE_REQUEST_STATE", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_SOLICITUD_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_ESTADO_SOLICITUD_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class)
}),
    @NamedStoredProcedureQuery(name = "Solicitud.crear_solicitud_y_detalle", procedureName = "FV_CREATE_PURCHASE_REQUEST", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_USUARIO_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_TIPO_SOLICITUD_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "KILOS_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ID_FRUTA_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "CALIDAD_IN", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ID_RESULT_OUT", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ID_REQUEST_DETAIL_RESULT_OUT", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "STATUS_RESULT_OUT", type = Integer.class)
}),
})
public class SolicitudEntity implements Serializable {
    @Id
    @Column(name = "ID_SOLICITUD")
    private Long idSolicitud;
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Column(name = "ID_ESTADO_SOLICITUD")
    private Integer idEstadoSolicitud;
    @Column(name = "ID_TIPO_SOLICITUD")
    private Integer idTipoSolicitud;
    @Column(name = "PRODUCTOR_SELECCIONADO")
    private Integer productorSeleccionado;
    @Column(name = "FECHA_PUBLICACION")
    private Date fechaPublicacion;

    @OneToMany
    @JoinColumn(name = "ID_SOLICITUD")
    private List<DetalleSolicitudEntity> detallesSolicitud;

    public List<DetalleSolicitudEntity> getDetallesSolicitud() {
        return detallesSolicitud;
    }
    public void setDetallesSolicitud(List<DetalleSolicitudEntity> detallesSolicitud) {
        this.detallesSolicitud = detallesSolicitud;
    }
    public Integer getIdTipoSolicitud() {
        return idTipoSolicitud;
    }
    public void setIdTipoSolicitud(Integer idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }
    public Long getIdSolicitud() {
        return idSolicitud;
    }
    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Integer getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }
    public void setIdEstadoSolicitud(Integer idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }
    public Integer getProductorSeleccionado() {
        return productorSeleccionado;
    }
    public void setProductorSeleccionado(Integer productorSeleccionado) {
        this.productorSeleccionado = productorSeleccionado;
    }
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
   
}
