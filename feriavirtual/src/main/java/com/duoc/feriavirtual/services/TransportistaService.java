package com.duoc.feriavirtual.services;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.CamionEntity;
import com.duoc.feriavirtual.entities.DetalleSubastaEntity;
import com.duoc.feriavirtual.entities.TransportistaEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.exceptions.UserNotFoundException;
import com.duoc.feriavirtual.models.GeneralUsers;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.repositories.CamionRepository;
import com.duoc.feriavirtual.repositories.DetalleSubastaRepository;
import com.duoc.feriavirtual.repositories.TransportistaRepository;
import com.duoc.feriavirtual.validators.UsuarioValidator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportistaService {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    TransportistaService.class
  );

  @Autowired
  TransportistaRepository transportistaRepository;

  @Autowired
  CamionRepository camionRepository;

  @Autowired
  DetalleSubastaRepository detalleSubastaRepository;

  @Autowired
  CommonConverter commonConverter;

  @Autowired
  UsuarioValidator usuarioValidator;

  public List<TransportistaEntity> selectCarrier()
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<TransportistaEntity> resultSelectCarrier = (List<TransportistaEntity>) transportistaRepository.findAll();
      usuarioValidator.validateSelectUser(resultSelectCarrier);
      return resultSelectCarrier;
    } catch (UserNotFoundException exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public IdResponse createUser(GeneralUsers usuario)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("CREANDO UN TRANSPORTISTA");
    IdResponse id = new IdResponse();

    Map<String, Object> resultCreateUser = transportistaRepository.createUser(
      usuario.getIdTipoUsuario(),
      usuario.getIdPais(),
      usuario.getNombre(),
      usuario.getApellidoPaterno(),
      usuario.getApellidoMaterno(),
      usuario.getCorreo(),
      usuario.getContrasena(),
      usuario.getRut(),
      usuario.getNumeroIdentificador(),
      usuario.getDireccion(),
      usuario.getCodigoPostal(),
      usuario.getTelefono(),
      null
    );

    Integer statusResultOut = (Integer) resultCreateUser.get(
      "STATUS_RESULT_OUT"
    );
    Integer idResultOut = (Integer) resultCreateUser.get("ID_RESULT_OUT");

    LOGGER.debug("statusResultOut: " + statusResultOut);
    LOGGER.debug("idResultOut: " + idResultOut);

    if (statusResultOut == -1) {
      throw new InvalidModelException("El modelo ingresado es invalido");
    }
    if (statusResultOut == -2) {
      throw new InvalidModelException("El servicio con el pl ha fallado");
    }

    if (statusResultOut == 0) {
      throw new NotFoundComponentFeriaVirtualException(
        "El transportista ya se encuentra registrado"
      );
    }

    if (statusResultOut == 1) {
      id.setId(idResultOut);
    }

    return id;
  }

  public IdResponse createTruck(CamionEntity truck)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("CREANDO UN CAMION");
    IdResponse id = new IdResponse();

    Map<String, Object> resultCreateTruck = camionRepository.createTruck(
      truck.getPatente(),
      truck.getModelo(),
      truck.getMarca(),
      truck.getRevisionTecnica(),
      truck.getDisponibilidad(),
      truck.getIdTipoCamion(),
      truck.getIdTamanoCamion(),
      truck.getIdTransportista()
    );

    Integer statusResultOut = (Integer) resultCreateTruck.get(
      "STATUS_RESULT_OUT"
    );
    Integer idResultOut = (Integer) resultCreateTruck.get("ID_RESULT_OUT");

    LOGGER.debug("statusResultOut: " + statusResultOut);
    LOGGER.debug("idResultOut: " + idResultOut);

    if (statusResultOut == -4) {
      throw new InvalidModelException("Patente ya registrada");
    } else if (statusResultOut == -3) {
      throw new NotFoundComponentFeriaVirtualException(
        "Transportista no se ha encontrado"
      );
    } else if (statusResultOut == -2) {
      throw new NotFoundComponentFeriaVirtualException(
        "Tipo de camion invalido"
      );
    } else if (statusResultOut == -1) {
      throw new NotFoundComponentFeriaVirtualException(
        "Tamaño de camion invalido"
      );
    } else if (statusResultOut == 0) {
      throw new InvalidModelException("Modelo ingresado invalido");
    } else if (statusResultOut == 1) {
      id.setId(idResultOut);
    } else {
      throw new InvalidModelException("Error - PL - FV_TRA_CREATE_TRUCK");
    }

    return id;
  }

  public Boolean updateTruck(CamionEntity truck)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("ACTUALIZANDO UN CAMION");

    Integer resultUpdateTruck = camionRepository.updateTruck(
      truck.getPatente(),
      truck.getModelo(),
      truck.getMarca(),
      truck.getRevisionTecnica(),
      truck.getDisponibilidad(),
      truck.getIdTipoCamion(),
      truck.getIdTamanoCamion(),
      truck.getIdTransportista()
    );

    LOGGER.debug("resultUpdateTruck=" + resultUpdateTruck);

    if (resultUpdateTruck == 1) {
      return true;
    } else if (resultUpdateTruck == -1) {
      throw new NotFoundComponentFeriaVirtualException(
        "Tamaño de camion invalido"
      );
    } else if (resultUpdateTruck == -2) {
      throw new NotFoundComponentFeriaVirtualException("Camion no encontrado");
    } else if (resultUpdateTruck == -3) {
      throw new NotFoundComponentFeriaVirtualException(
        "Tipo de camion invalido"
      );
    } else if (resultUpdateTruck == -4) {
      throw new NotFoundComponentFeriaVirtualException(
        "Transportista no encontrado"
      );
    } else {
      throw new InvalidModelException("Error - PL - FV_TRA_UPDATE_TRUCK");
    }
  }

  public Boolean deleteTruck(Integer id)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("ELIMINANDO UN CAMION");

    Integer resultDeleteTruck = camionRepository.deleteTruck(id);

    LOGGER.debug("resultDeleteTruck=" + resultDeleteTruck);

    if (resultDeleteTruck == 1) {
      return true;
    } else if (resultDeleteTruck == 0) {
      throw new NotFoundComponentFeriaVirtualException(
        "El camion no se ha encontrado"
      );
    } else {
      throw new InvalidModelException(
        "No se puede eliminar el camion debido a que es utilizado en otra seccion"
      );
    }
  }

  public IdResponse auctionParticipate(DetalleSubastaEntity detalleSubasta)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    LOGGER.debug("PARTICIPANDO EN UNA SUBASTA");
    IdResponse id = new IdResponse();

    Map<String, Object> resultParticipate = detalleSubastaRepository.auctionParticipate(
      detalleSubasta.getIdSubasta(),
      detalleSubasta.getIdCamion(),
      detalleSubasta.getPrecio()
    );

    Integer statusResultOut = (Integer) resultParticipate.get(
      "STATUS_RESULT_OUT"
    );
    Integer idResultOut = (Integer) resultParticipate.get("ID_RESULT_OUT");

    LOGGER.debug("statusResultOut: " + statusResultOut);
    LOGGER.debug("idResultOut: " + idResultOut);

    if (statusResultOut == -2) {
      throw new InvalidModelException("La subasta fue realizada previamente");
    } else if (statusResultOut == -1) {
      throw new NotFoundComponentFeriaVirtualException(
        "Subasta no se ha encontrado"
      );
    } else if (statusResultOut == 0) {
      throw new NotFoundComponentFeriaVirtualException(
        "Camion no se ha encontrado"
      );
    } else if (statusResultOut == 1) {
      id.setId(idResultOut);
    } else {
      throw new InvalidModelException(
        "Error - PL - FV_TRA_AUCTION_PARTICIPATION"
      );
    }

    return id;
  }

  public List<CamionEntity> getTruckByIdCarrier(Integer id)
    throws NotFoundComponentFeriaVirtualException, InvalidModelException {
    return camionRepository.findByIdTransportista(id);
  }
}
