package com.duoc.feriavirtual.controllers;

import java.util.List;
import java.util.Optional;

import com.duoc.feriavirtual.entities.tiposYestados.CalidadEntity;
import com.duoc.feriavirtual.entities.tiposYestados.CategoriaFrutaEntity;
import com.duoc.feriavirtual.entities.tiposYestados.EstadoContratoEntity;
import com.duoc.feriavirtual.entities.tiposYestados.EstadoSolicitudEntity;
import com.duoc.feriavirtual.entities.tiposYestados.EstadoSubastaEntity;
import com.duoc.feriavirtual.entities.tiposYestados.EstadoVentaEntity;
import com.duoc.feriavirtual.entities.tiposYestados.FrutaEntity;
import com.duoc.feriavirtual.entities.tiposYestados.TamanoCamionEntity;
import com.duoc.feriavirtual.entities.tiposYestados.TipoCamionEntity;
import com.duoc.feriavirtual.entities.tiposYestados.TipoPagoEntity;
import com.duoc.feriavirtual.entities.tiposYestados.TipoSolicitudEntity;
import com.duoc.feriavirtual.entities.tiposYestados.TipoUsuarioEntity;
import com.duoc.feriavirtual.entities.tiposYestados.ValoresEstaticosEntity;
import com.duoc.feriavirtual.models.ErrorDetail;
import com.duoc.feriavirtual.services.TiposEstadosService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TiposEstadosController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TiposEstadosController.class);

    @Autowired
    TiposEstadosService tiposEstadosService;

 
    // CALIDAD
    @GetMapping(value = "/select-quality-fruit")
    public ResponseEntity<?> selectAllQuality() {
        try {
            
            List<CalidadEntity>  quality = tiposEstadosService.selectAllQualitys();
            return new ResponseEntity<List<CalidadEntity>  >(quality, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-quality-fruit/{id}")
    public ResponseEntity<?> selectQualityById(@PathVariable Integer id) {
        try {
            Optional<CalidadEntity>  quality = tiposEstadosService.selectQualityById(id);
            return new ResponseEntity<Optional<CalidadEntity>  >(quality, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // CATEGORIA FRUTA
    @GetMapping(value = "/select-category-fruit")
    public ResponseEntity<?> selectAllCategoryFruit() {
        try {
            
            List<CategoriaFrutaEntity>  result = tiposEstadosService.selectAllCategoryFruit();
            return new ResponseEntity<List<CategoriaFrutaEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-category-fruit/{id}")
    public ResponseEntity<?> selectCategoryFruitById(@PathVariable Integer id) {
        try {
            Optional<CategoriaFrutaEntity>  quality = tiposEstadosService.selectCategoryFruitById(id);
            return new ResponseEntity<Optional<CategoriaFrutaEntity>  >(quality, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // ESTADO CONTRATO
    @GetMapping(value = "/select-status-contract")
    public ResponseEntity<?> selectAllStatusContract() {
        try {
            
            List<EstadoContratoEntity>  result = tiposEstadosService.selectAllStatusContract();
            return new ResponseEntity<List<EstadoContratoEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-status-contract/{id}")
    public ResponseEntity<?> selectStatusContractById(@PathVariable Integer id) {
        try {
            Optional<EstadoContratoEntity>  quality = tiposEstadosService.selectStatusContractById(id);
            return new ResponseEntity<Optional<EstadoContratoEntity>  >(quality, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // ESTADO SOLICITUD
    @GetMapping(value = "/select-status-request")
    public ResponseEntity<?> selectAllStatusRequest() {
        try {
            
            List<EstadoSolicitudEntity>  result = tiposEstadosService.selectAllStatusRequest();
            return new ResponseEntity<List<EstadoSolicitudEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-status-request/{id}")
    public ResponseEntity<?> selectStatusRequestById(@PathVariable Integer id) {
        try {
            Optional<EstadoSolicitudEntity>  quality = tiposEstadosService.selectStatusRequestById(id);
            return new ResponseEntity<Optional<EstadoSolicitudEntity>  >(quality, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // ESTADO SUBASTA
    @GetMapping(value = "/select-status-auction")
    public ResponseEntity<?> selectAllStatusAuction() {
        try {
            
            List<EstadoSubastaEntity>  result = tiposEstadosService.selectAllStatusAuction();
            return new ResponseEntity<List<EstadoSubastaEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-status-auction/{id}")
    public ResponseEntity<?> selectStatusAuctionById(@PathVariable Integer id) {
        try {
            Optional<EstadoSubastaEntity>  result = tiposEstadosService.selectStatusAuctionById(id);
            return new ResponseEntity<Optional<EstadoSubastaEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // ESTADO VENTA
    @GetMapping(value = "/select-status-sale")
    public ResponseEntity<?> selectAllStatusSale() {
        try {
            
            List<EstadoVentaEntity>  result = tiposEstadosService.selectAllStatusSale();
            return new ResponseEntity<List<EstadoVentaEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-status-sale/{id}")
    public ResponseEntity<?> selectStatusSaleById(@PathVariable Integer id) {
        try {
            Optional<EstadoVentaEntity>  result = tiposEstadosService.selectStatusSaleById(id);
            return new ResponseEntity<Optional<EstadoVentaEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // FRUTA
    @GetMapping(value = "/select-fruit")
    public ResponseEntity<?> selectAllFruit() {
        try {
            
            List<FrutaEntity>  result = tiposEstadosService.selectAllFruit();
            return new ResponseEntity<List<FrutaEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-fruit/{id}")
    public ResponseEntity<?> selectFruitById(@PathVariable Integer id) {
        try {
            Optional<FrutaEntity>  result = tiposEstadosService.selectFruitById(id);
            return new ResponseEntity<Optional<FrutaEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // TAMAÑO CAMION
    @GetMapping(value = "/select-truck-size")
    public ResponseEntity<?> selectAllTruckSize() {
        try {
            
            List<TamanoCamionEntity>  result = tiposEstadosService.selectAllTruckSize();
            return new ResponseEntity<List<TamanoCamionEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-truck-size/{id}")
    public ResponseEntity<?> selectTruckSizeById(@PathVariable Integer id) {
        try {
            Optional<TamanoCamionEntity>  result = tiposEstadosService.selectTruckSizeById(id);
            return new ResponseEntity<Optional<TamanoCamionEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // TIPO CAMION
    @GetMapping(value = "/select-truck-type")
    public ResponseEntity<?> selectAllTruckType() {
        try {
            
            List<TipoCamionEntity>  result = tiposEstadosService.selectAllTruckType();
            return new ResponseEntity<List<TipoCamionEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-truck-type/{id}")
    public ResponseEntity<?> selectTruckTypeById(@PathVariable Integer id) {
        try {
            Optional<TipoCamionEntity>  result = tiposEstadosService.selectTruckTypeById(id);
            return new ResponseEntity<Optional<TipoCamionEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // TIPO PAGO
    @GetMapping(value = "/select-pay-type")
    public ResponseEntity<?> selectAllPayType() {
        try {
            
            List<TipoPagoEntity>  result = tiposEstadosService.selectAllPayType();
            return new ResponseEntity<List<TipoPagoEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-pay-type/{id}")
    public ResponseEntity<?> selectPayTypeById(@PathVariable Integer id) {
        try {
            Optional<TipoPagoEntity>  result = tiposEstadosService.selectPayTypeById(id);
            return new ResponseEntity<Optional<TipoPagoEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    
    // TIPO SOLICITUD
    @GetMapping(value = "/select-request-type")
    public ResponseEntity<?> selectAllRequestType() {
        try {
            
            List<TipoSolicitudEntity>  result = tiposEstadosService.selectAllRequestType();
            return new ResponseEntity<List<TipoSolicitudEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-request-type/{id}")
    public ResponseEntity<?> selectRequestTypeById(@PathVariable Integer id) {
        try {
            Optional<TipoSolicitudEntity>  result = tiposEstadosService.selectRequestTypeById(id);
            return new ResponseEntity<Optional<TipoSolicitudEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    
    // TIPO USUARIO
    @GetMapping(value = "/select-user-type")
    public ResponseEntity<?> selectAllUserType() {
        try {
            
            List<TipoUsuarioEntity>  result = tiposEstadosService.selectAllUsersType();
            return new ResponseEntity<List<TipoUsuarioEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-user-type/{id}")
    public ResponseEntity<?> selectUserTypeById(@PathVariable Integer id) {
        try {
            Optional<TipoUsuarioEntity>  result = tiposEstadosService.selectUserTypeById(id);
            return new ResponseEntity<Optional<TipoUsuarioEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    // VALORES ESTATICOS
    @GetMapping(value = "/select-static-values")
    public ResponseEntity<?> selectAllStaticValues() {
        try {
            
            List<ValoresEstaticosEntity>  result = tiposEstadosService.selectAllStaticValues();
            return new ResponseEntity<List<ValoresEstaticosEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(value = "/select-static-values/{id}")
    public ResponseEntity<?> selectStaticValuesById(@PathVariable Integer id) {
        try {
            Optional<ValoresEstaticosEntity>  result = tiposEstadosService.selectStaticValuesById(id);
            return new ResponseEntity<Optional<ValoresEstaticosEntity>  >(result, HttpStatus.OK);
        }catch (Exception exception) {
            return new ResponseEntity<ErrorDetail>(new ErrorDetail(exception.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   

  
}
