package com.duoc.feriavirtual.services;

import java.util.List;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.SolicitudEntity;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.repositories.SolicitudRepository;
import com.duoc.feriavirtual.validators.UsuarioValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SolicitudService.class);

    @Autowired
    SolicitudRepository solicitudRepository;
    @Autowired
    CommonConverter commonConverter;
    @Autowired
    UsuarioValidator usuarioValidator;

 
    public List<SolicitudEntity>  selectRequestsByidStatus(Integer idEstadoSolicitud) throws  NotFoundComponentFeriaVirtualException{
        try {
           
            List<SolicitudEntity>  resultRequests = ( List<SolicitudEntity> )  solicitudRepository.findByIdEstadoSolicitud(idEstadoSolicitud);
            return resultRequests;
            
        } catch (Exception exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
    }
}
