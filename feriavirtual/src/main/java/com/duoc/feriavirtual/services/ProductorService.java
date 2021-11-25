package com.duoc.feriavirtual.services;

import java.util.List;
import java.util.Map;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.ContratoEntity;
import com.duoc.feriavirtual.entities.ProductorEntity;
import com.duoc.feriavirtual.entities.ProductorSolicitudEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.exceptions.UserNotFoundException;
import com.duoc.feriavirtual.models.GeneralUsers;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.repositories.ContratoRepository;
import com.duoc.feriavirtual.repositories.ProductorRepository;
import com.duoc.feriavirtual.repositories.ProductorSolicitudRepository;
import com.duoc.feriavirtual.validators.UsuarioValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductorService.class);

    @Autowired
    ProductorRepository productorRepository;
    @Autowired
    ContratoRepository contratoRepository;
    @Autowired
    ProductorSolicitudRepository productorSolicitudRepository;
    @Autowired
    CommonConverter commonConverter;
    @Autowired
    UsuarioValidator usuarioValidator;

 
    public List<ProductorEntity>  selectProducers() throws  NotFoundComponentFeriaVirtualException{
        try {
           
            List<ProductorEntity>  resultSelectProducer = ( List<ProductorEntity> )  productorRepository.findAll();
            usuarioValidator.validateSelectUser(resultSelectProducer);
            return resultSelectProducer;
            
        } catch (UserNotFoundException exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
    }

    public IdResponse createUser(GeneralUsers usuario) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        
        LOGGER.debug("CREANDO UN PRODUCTOR");
        IdResponse id = new IdResponse();


        Map<String, Object> resultCreateUser = 
        productorRepository.createUser(
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
            usuario.getIdContrato()
        );

        Integer statusResultOut = (Integer) resultCreateUser.get("STATUS_RESULT_OUT");
        Integer idResultOut = (Integer) resultCreateUser.get("ID_RESULT_OUT");

        LOGGER.debug("statusResultOut: " + statusResultOut);
        LOGGER.debug("idResultOut: " + idResultOut);

        if(statusResultOut == -1){
            throw new InvalidModelException("El modelo ingresado es invalido, o el contrato es invalido");
        }
        if(statusResultOut == -2){
            throw new InvalidModelException("El servicio con el pl ha fallado");
        }

        if(statusResultOut == 0){
            throw new NotFoundComponentFeriaVirtualException("El productor ya se encuentra registrado");
        }

        if(statusResultOut == 1){
            id.setId(idResultOut);
        }

        return id;  
}

    public Boolean updateUser(GeneralUsers usuario) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        LOGGER.debug("ACTUALIZANDO UN USUARIO");
        LOGGER.debug("CORREO_IN=" + usuario.getCorreo());

        Integer resultUpdateUser = productorRepository.updateUser(     
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
            usuario.getIdContrato()
        );
        LOGGER.debug("resultUpdateUser=" + resultUpdateUser);

        if(resultUpdateUser == 1){
            return true;
        }else if(resultUpdateUser == -1){
            throw new NotFoundComponentFeriaVirtualException("Usuario a editar no encontrado");
        }else if(resultUpdateUser == 0){
            throw new NotFoundComponentFeriaVirtualException("Contrato ingresado no disponible");
        }else{
            throw new InvalidModelException("Error - PL - FV_ADM_UPDATE_USER");
        }
    }

    public IdResponse createContract(ContratoEntity contrato) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        LOGGER.debug("CREANDO UN CONTRATO");
        IdResponse id = new IdResponse();
        Map<String, Object> resultCreate = contratoRepository.createContract(contrato.getDescripcion(), contrato.getFirmas(), contrato.getIdEstadoContrato());
        
        Integer statusOut = (Integer) resultCreate.get("STATUS_RESULT_OUT");
        Integer idContratoOut = (Integer) resultCreate.get("ID_RESULT_OUT");
        id.setId(idContratoOut);

        if(statusOut == 1){
            return id;
        }else if(statusOut == 0){
            throw new NotFoundComponentFeriaVirtualException("Estado de contrato no disponible o modelo ingresado invalido");
        }else{
            throw new InvalidModelException("Error - PL - FV_ADM_CREATE_CONTRACT");
        }
    }

    public Boolean participateInRequest(ProductorSolicitudEntity productorSolicitudEntity) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        LOGGER.debug("PARTICIPAR EN UN SOLICITUD");
        LOGGER.debug("SOLICITUD=" + productorSolicitudEntity.getIdSolicitud());
        LOGGER.debug("PRODUCTOR=" + productorSolicitudEntity.getIdProductor());
        LOGGER.debug("PRECIO=" + productorSolicitudEntity.getPrecio());

        Integer resultCreateParticipateInRequest = productorSolicitudRepository.requestParticipation
        (productorSolicitudEntity.getIdSolicitud() ,productorSolicitudEntity.getIdProductor(), productorSolicitudEntity.getPrecio());
        LOGGER.debug("resultCreateParticipateInRequest=" + resultCreateParticipateInRequest);

        if(resultCreateParticipateInRequest == 1){
            return true;
        }else if(resultCreateParticipateInRequest == -1){
            throw new NotFoundComponentFeriaVirtualException("Productor no encontrado");
        }else if(resultCreateParticipateInRequest == 0){
            throw new NotFoundComponentFeriaVirtualException("Solicitud no disponible");
        }else{
            throw new InvalidModelException("Error - PL - FV_PRO_REQUEST_PARTICIPATION");
        }
    }
 
    public List<ProductorSolicitudEntity>  findAllProducerRequest() throws  NotFoundComponentFeriaVirtualException{
        try {
           
            List<ProductorSolicitudEntity>  resultSelectProducer = productorSolicitudRepository.findAll();
            return resultSelectProducer;
            
        } catch (Exception exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
    }


}
