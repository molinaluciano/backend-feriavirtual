package com.duoc.feriavirtual.services;

import java.util.List;
import java.util.Map;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.UsuarioEntity;
import com.duoc.feriavirtual.entities.VentaEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.InvalidModelUsuario;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.exceptions.UserNotFoundException;
import com.duoc.feriavirtual.models.GeneralUsers;
import com.duoc.feriavirtual.models.UsuarioModel;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.models.modelResponse.LoginResponse;
import com.duoc.feriavirtual.repositories.UsuarioRepository;
import com.duoc.feriavirtual.repositories.VentaRepository;
import com.duoc.feriavirtual.validators.UsuarioValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    VentaRepository ventaRepository;
    @Autowired
    CommonConverter commonConverter;
    @Autowired
    UsuarioValidator usuarioValidator;

    public LoginResponse loginUser(UsuarioModel usuario) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        try {
            UsuarioEntity newUsuarioEntity = commonConverter.convertUsuarioModelToEntity(usuario);

            Map<String, Object> resultLoginProcedure = usuarioRepository.loginUser(newUsuarioEntity.getCorreo(),
                    newUsuarioEntity.getContrasena());
            LoginResponse loginResponse = commonConverter.converterResponsePLToLoginResponse(resultLoginProcedure);

            if (loginResponse.getStatus_out() == 0) {
                throw new UserNotFoundException("USER NOT FOUND");
            } else {
                return loginResponse;
            }

        } catch (UserNotFoundException exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
    }

    public List<UsuarioEntity>  selectUsersByIdType(Integer idType) throws  NotFoundComponentFeriaVirtualException, InvalidModelException{
        try {
            if (idType < 1 || idType > 5){
                LOGGER.debug("Id de usuario invalido");
                throw new InvalidModelUsuario("El id ingresado es invalido");
            }
            
            List<UsuarioEntity>  resultSelectFindByIdTipoUsuario = ( List<UsuarioEntity> ) usuarioRepository.findByidTipoUsuario(idType);
            usuarioValidator.validateSelectUser(resultSelectFindByIdTipoUsuario);
            return resultSelectFindByIdTipoUsuario;
            
        } catch (UserNotFoundException exception) {
            throw new NotFoundComponentFeriaVirtualException(exception.getMessage());
        }
        catch (InvalidModelUsuario exception) {
            throw new InvalidModelException(exception.getMessage());
        }
    }
    
    public IdResponse createUser(GeneralUsers usuario) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        
            LOGGER.debug("CREANDO UN USUARIO");
            IdResponse id = new IdResponse();

            Map<String, Object> resultCreateUser = usuarioRepository.createUser(
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

            Integer statusResultOut = (Integer) resultCreateUser.get("STATUS_RESULT_OUT");
            Integer idResultOut = (Integer) resultCreateUser.get("ID_RESULT_OUT");

            LOGGER.debug("statusResultOut: " + statusResultOut);
            LOGGER.debug("idResultOut: " + idResultOut);

            if(statusResultOut == -1){
                throw new InvalidModelException("El modelo ingresado es invalido");
            }
            if(statusResultOut == -2){
                throw new InvalidModelException("El servicio con el pl ha fallado");
            }

            if(statusResultOut == 0){
                throw new NotFoundComponentFeriaVirtualException("El usuario ya se encuentra registrado");
            }

            if(statusResultOut == 1){
                id.setId(idResultOut);
            }

            return id;
    }

    public Boolean deleteUser(GeneralUsers usuario) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        
        LOGGER.debug("ELIMINANDO UN USUARIO");
      
        Integer resultDeleteUser = usuarioRepository.deleteUser(
            usuario.getIdTipoUsuario(),
            usuario.getIdUsuario().intValue()
        );

       

        LOGGER.debug("resultDeleteUser: " + resultDeleteUser);
        if(resultDeleteUser == 1){
            return true;
        }else  if(resultDeleteUser == -1){
            throw new InvalidModelException("El tipo de usuario ingresado no es valido");
        }else  if(resultDeleteUser == 0){
            throw new NotFoundComponentFeriaVirtualException("El usuario no se encuentra registrado");
        } else{
            throw new InvalidModelException("Error - PL - FV_ADM_DELETE_USER");
        }

}
    // PETICIONES COMO CLINTE
  
    // PETICIONES COMO ADMINISTRADOR
    public Boolean updateStatusSale(VentaEntity venta) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        
        LOGGER.debug("AACTUALIZANDO EL ESTADO DE UNA VENTA");
      
        Integer resultUpdateSale = ventaRepository.updateStateSale(venta.getIdVenta(), venta.getIdEstadoVenta());       
        LOGGER.debug("resultUpdateSale: " + resultUpdateSale);

        if(resultUpdateSale == 1){
            return true;
        }else  if(resultUpdateSale == -1){
            throw new InvalidModelException("El estado de la venta es invalido");
        }else  if(resultUpdateSale == 0){
            throw new NotFoundComponentFeriaVirtualException("La venta no se ha encontrado ");
        } else{
            throw new InvalidModelException("Error - PL - FV_ADM_UPDATE_SALE_STATES");
        }

}

}
