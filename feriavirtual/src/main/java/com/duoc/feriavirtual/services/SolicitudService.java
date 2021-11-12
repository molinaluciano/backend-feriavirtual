package com.duoc.feriavirtual.services;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.DetalleSolicitudEntity;
import com.duoc.feriavirtual.entities.SolicitudEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.GeneralRequestAndDetail;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.repositories.DetalleSolicitudRepository;
import com.duoc.feriavirtual.repositories.SolicitudRepository;
import com.duoc.feriavirtual.validators.UsuarioValidator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudService {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    SolicitudService.class
  );

  @Autowired
  SolicitudRepository solicitudRepository;

  @Autowired
  DetalleSolicitudRepository detalleSolicitudRepository;

  @Autowired
  CommonConverter commonConverter;

  @Autowired
  UsuarioValidator usuarioValidator;

  public List<SolicitudEntity> selectRequestsByidStatus(
    Integer idEstadoSolicitud
  )
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<SolicitudEntity> resultRequests = (List<SolicitudEntity>) solicitudRepository.findByIdEstadoSolicitud(
        idEstadoSolicitud
      );
      return resultRequests;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public Boolean updateStatusRequest(SolicitudEntity solicitud)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    Integer resultUpdate = solicitudRepository.updateStatusRequest(
      solicitud.getIdSolicitud().intValue(),
      solicitud.getIdEstadoSolicitud()
    );
    LOGGER.debug("resultUpdate: " + resultUpdate);

    if (resultUpdate == 1) {
      return true;
    } else if (resultUpdate == -1) {
      throw new InvalidModelException("El estado de solicitud es invalido");
    } else if (resultUpdate == 0) {
      throw new NotFoundComponentFeriaVirtualException(
        "Solicitud no encontrada"
      );
    } else {
      throw new InvalidModelException("Error - PL - FV_ADM_DELETE_USER");
    }
  }

  public IdResponse createRequestAndDetail(
    GeneralRequestAndDetail generalRequestAndDetail
  )
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("CREANDO UNA SOLICITUD");
    IdResponse id = new IdResponse();

    Map<String, Object> resultCreateRequest = solicitudRepository.createRequestAndDetail(
      generalRequestAndDetail.getIdUsuario(),
      generalRequestAndDetail.getIdTipoSolicitud(),
      generalRequestAndDetail.getKilos(),
      generalRequestAndDetail.getIdFruta(),
      generalRequestAndDetail.getIdCalidad()
    );

    Integer statusResultOut = (Integer) resultCreateRequest.get(
      "STATUS_RESULT_OUT"
    );
    Integer idRequestDetailResultOut = (Integer) resultCreateRequest.get(
      "ID_REQUEST_DETAIL_RESULT_OUT"
    );
    Integer idResultOut = (Integer) resultCreateRequest.get("ID_RESULT_OUT");

    LOGGER.debug("statusResultOut: " + statusResultOut);
    LOGGER.debug("idRequestDetailResultOut: " + idRequestDetailResultOut);
    LOGGER.debug("idResultOut: " + idResultOut);

    if (statusResultOut == 1) {
      id.setId(idResultOut);
    } else if (statusResultOut == 0) {
      throw new InvalidModelException("El modelo ingresado es invalido");
    } else if (statusResultOut == -1) {
      throw new NotFoundComponentFeriaVirtualException(
        "Tipo de solicitud no encontrada"
      );
    } else if (statusResultOut == -2) {
      throw new NotFoundComponentFeriaVirtualException("Usuario no encontrado");
    } else if (statusResultOut == -3) {
      throw new NotFoundComponentFeriaVirtualException("Fruta no encontrada");
    } else if (statusResultOut == -4) {
      throw new NotFoundComponentFeriaVirtualException("Calidad no encontrada");
    } else {
      throw new InvalidModelException(
        "Error - PL - FV_CREATE_PURCHASE_REQUEST"
      );
    }

    return id;
  }

  public List<DetalleSolicitudEntity> findAllRequests()
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<DetalleSolicitudEntity> resultRequests = (List<DetalleSolicitudEntity>) detalleSolicitudRepository.findAll();
      return resultRequests;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public List<DetalleSolicitudEntity> findAllRequestsByIdRequests(
    Integer idSolicitud
  )
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<DetalleSolicitudEntity> resultRequests = (List<DetalleSolicitudEntity>) detalleSolicitudRepository.findByIdSolicitud(
        idSolicitud
      );
      return resultRequests;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }
}
