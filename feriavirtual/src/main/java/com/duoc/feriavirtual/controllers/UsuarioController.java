package com.duoc.feriavirtual.controllers;

import java.util.List;

import com.duoc.feriavirtual.entities.UsuarioEntity;
import com.duoc.feriavirtual.entities.VentaEntity;
import com.duoc.feriavirtual.exceptions.InvalidModelException;
import com.duoc.feriavirtual.exceptions.NotFoundComponentFeriaVirtualException;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.models.GeneralUsers;
import com.duoc.feriavirtual.models.UsuarioModel;
import com.duoc.feriavirtual.models.modelResponse.IdResponse;
import com.duoc.feriavirtual.models.modelResponse.LoginResponse;
import com.duoc.feriavirtual.services.ProductorService;
import com.duoc.feriavirtual.services.TransportistaService;
import com.duoc.feriavirtual.services.UsuarioService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ProductorService productorService;
    @Autowired
    TransportistaService transportistaService;
   
    @PostMapping(value = "/login")
    public ResponseEntity<?> postMethodName(@RequestBody UsuarioModel usuario) {
        try {

            LoginResponse loginResponse = usuarioService.loginUser(usuario);

            return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.ACCEPTED);
        } catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/select-user/{id}")
    public ResponseEntity<?> postMethodName(@PathVariable Integer id) {
        LOGGER.debug("CONTROLLER ID:" + id);
        try {
            
            List<UsuarioEntity>  users = usuarioService.selectUsersByIdType(id);
            return new ResponseEntity<List<UsuarioEntity> >(users, HttpStatus.OK);
        } catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        
        } catch (InvalidModelException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create-user")
    public ResponseEntity<?> postNewUser(@RequestBody GeneralUsers newUser) {
        try {
            System.out.println("ID TIPO USUARIO: "+ newUser.getIdTipoUsuario());
            System.out.println(newUser.getIdContrato());
            Integer idTypeUser = newUser.getIdTipoUsuario();

            IdResponse idResultCreation = null;
            

            if(idTypeUser >= 1 && idTypeUser <= 5){
                idResultCreation = usuarioService.createUser(newUser);
            }else if(idTypeUser == 6 ){
                idResultCreation = productorService.createUser(newUser);
            }else if(idTypeUser == 7 ){
                idResultCreation = transportistaService.createUser(newUser);
            }else{
                throw new InvalidModelException("El id del tipo de usuario a crear es invalido");
            }

            LOGGER.debug("idResultCreation:" + idResultCreation);
            return new ResponseEntity<IdResponse>(idResultCreation, HttpStatus.ACCEPTED);
        }catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        }catch(InvalidModelException exception){
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // catch (Exception exception) {
        //     return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
        //             HttpStatus.INTERNAL_SERVER_ERROR);
        // }

    }
    
    @PutMapping(value = "/update-user")
    public ResponseEntity<?> updateUser(@RequestBody GeneralUsers user) {
        try {
            
            Boolean resultUpdate = productorService.updateUser(user);
            
            return new ResponseEntity<Boolean>(resultUpdate, HttpStatus.OK);
        }catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        }catch(InvalidModelException exception){
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @DeleteMapping(value = "/delete-user")
    public ResponseEntity<?> deleteUser(@RequestBody GeneralUsers user) {
        try {
            
            Boolean resultDelete= usuarioService.deleteUser(user);
            
            return new ResponseEntity<Boolean>(resultDelete, HttpStatus.OK);
        }catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        }catch(InvalidModelException exception){
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    // PETICIONES COMO ADMINISTRADOR
    @PutMapping(value = "/update-state-sale")
    public ResponseEntity<?> updateStateSale(@RequestBody VentaEntity venta) {
        try {
            System.out.println("Actualizando estado de una venta");
  
            Boolean resultUpdated = usuarioService.updateStatusSale(venta);          
            return new ResponseEntity<Boolean>(resultUpdated, HttpStatus.CREATED);
            
        }catch (NotFoundComponentFeriaVirtualException exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()), HttpStatus.NOT_FOUND);
        }catch(InvalidModelException exception){
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
}
