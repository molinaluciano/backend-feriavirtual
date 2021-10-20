package com.duoc.feriavirtual.services;

import java.util.List;
import java.util.Map;

import com.duoc.feriavirtual.converters.CommonConverter;
import com.duoc.feriavirtual.entities.UsuarioEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.InvalidModelUsuario;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.exceptions.UserNotFoundException;
import com.duoc.feriavirtual.models.GeneralUsers;
import com.duoc.feriavirtual.models.UsuarioModel;
import com.duoc.feriavirtual.models.modelResponse.LoginResponse;
import com.duoc.feriavirtual.repositories.UsuarioRepository;
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
    
    public Boolean createUser(GeneralUsers usuario) throws NotFoundComponentFeriaVirtualException, InvalidModelException {
        

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

            System.out.println(resultCreateUser);

            return true;
           

        
    }

}
