package com.duoc.feriavirtual.services;

import com.duoc.feriavirtual.entities.DetalleSubastaEntity;
import com.duoc.feriavirtual.entities.SubastaEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.repositories.DetalleSubastaRepository;
import com.duoc.feriavirtual.repositories.SubastaRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubastaService {
  private static final Logger LOGGER = LoggerFactory.getLogger(
    SubastaService.class
  );

  @Autowired
  SubastaRepository subastaRepository;
  @Autowired
  DetalleSubastaRepository detalleSubastaRepository;

  public List<SubastaEntity> findAllSubastas()
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<SubastaEntity> resultRequests = subastaRepository.findAll();
      return resultRequests;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public List<SubastaEntity> findAllSubastasByStatus(Integer id)
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<SubastaEntity> resultRequests = subastaRepository.findByIdEstadoSubasta(
        id
      );
      return resultRequests;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public List<SubastaEntity> findAllSubastasByRequest(Integer id)
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<SubastaEntity> resultRequests = subastaRepository.findByIdSolicitud(
        id
      );
      return resultRequests;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }

  public List<SubastaEntity> findByIdSubasta(Integer id)
    throws NotFoundComponentFeriaVirtualException {
    try {
      List<SubastaEntity> resultRequests = subastaRepository.findByIdSubasta(
        id
      );
      return resultRequests;
    } catch (Exception exception) {
      throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
    }
  }
 
  public List<DetalleSubastaEntity> findAllDetailSubastas()
  throws NotFoundComponentFeriaVirtualException {
  try {
    List<DetalleSubastaEntity> resultRequests = detalleSubastaRepository.findAll();
    return resultRequests;
  } catch (Exception exception) {
    throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
  }
}

}
