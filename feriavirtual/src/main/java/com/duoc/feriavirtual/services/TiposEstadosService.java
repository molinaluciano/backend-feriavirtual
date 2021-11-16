package com.duoc.feriavirtual.services;

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
import com.duoc.feriavirtual.repositories.tiposYestados.CalidadRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.CategoriaFrutaRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.EstadoContratoRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.EstadoSolicitudRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.EstadoSubastaRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.EstadoVentaRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.FrutaRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.TamanoCamionRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.TipoCamionRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.TipoPagoRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.TipoSolicitudRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.TipoUsuarioRepository;
import com.duoc.feriavirtual.repositories.tiposYestados.ValoresEstaticosRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiposEstadosService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TiposEstadosService.class);

    @Autowired
    CalidadRepository calidadRepository;
    @Autowired
    CategoriaFrutaRepository categoriaFrutaRepository;
    @Autowired
    EstadoContratoRepository estadoContratoRepository;
    @Autowired
    EstadoSolicitudRepository estadoSolicitudRepository;
    @Autowired
    EstadoSubastaRepository estadoSubastaRepository;
    @Autowired
    EstadoVentaRepository estadoVentaRepository;
    @Autowired
    FrutaRepository frutaRepository;
    @Autowired
    TamanoCamionRepository tamanoCamionRepository;
    @Autowired
    TipoCamionRepository tipoCamionRepository;
    @Autowired
    TipoPagoRepository tipoPagoRepository;
    @Autowired
    TipoSolicitudRepository tipoSolicitudRepository;
    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;
    @Autowired
    ValoresEstaticosRepository valoresEstaticosRepository;

    //  CALIDAD
    public List<CalidadEntity>  selectAllQualitys() {
        List<CalidadEntity> result  = calidadRepository.findAll();
        LOGGER.debug("ALL QUALITY" + result);
        return result;
    }
    public Optional<CalidadEntity>  selectQualityById(Integer id) {
        return calidadRepository.findById(id);
    }

    // CATEGORIA FRUTA
    public List<CategoriaFrutaEntity>  selectAllCategoryFruit() {
        return categoriaFrutaRepository.findAll();
    }
    public Optional<CategoriaFrutaEntity>  selectCategoryFruitById(Integer id) {
        return categoriaFrutaRepository.findById(id);
    }

    // ESTADO CONTRATO
    public List<EstadoContratoEntity>  selectAllStatusContract() {
        return estadoContratoRepository.findAll();
    }
    public Optional<EstadoContratoEntity>  selectStatusContractById(Integer id) {
        return estadoContratoRepository.findById(id);
    }

    // ESTADO SOLICITUD
    public List<EstadoSolicitudEntity>  selectAllStatusRequest() {
        return estadoSolicitudRepository.findAll();
    }
    public Optional<EstadoSolicitudEntity>  selectStatusRequestById(Integer id) {
        return estadoSolicitudRepository.findById(id);
    }

    // ESTADO SUBASTA
    public List<EstadoSubastaEntity>  selectAllStatusAuction() {
        return estadoSubastaRepository.findAll();
    }
    public Optional<EstadoSubastaEntity>  selectStatusAuctionById(Integer id) {
        return estadoSubastaRepository.findById(id);
    }

    // ESTADO VENTA
    public List<EstadoVentaEntity>  selectAllStatusSale() {
        return estadoVentaRepository.findAll();
    }
    public Optional<EstadoVentaEntity>  selectStatusSaleById(Integer id) {
        return estadoVentaRepository.findById(id);
    }

    // FRUTA
    public List<FrutaEntity>  selectAllFruit() {
        return frutaRepository.findAll();
    }
    public Optional<FrutaEntity>  selectFruitById(Integer id) {
        return frutaRepository.findById(id);
    }

    // TAMANO CAMION
    public List<TamanoCamionEntity>  selectAllTruckSize() {
        return tamanoCamionRepository.findAll();
    }
    public Optional<TamanoCamionEntity>  selectTruckSizeById(Integer id) {
        return tamanoCamionRepository.findById(id);
    }

    // TIPO CAMION
    public List<TipoCamionEntity>  selectAllTruckType() {
        return tipoCamionRepository.findAll();
    }
    public Optional<TipoCamionEntity>  selectTruckTypeById(Integer id) {
        return tipoCamionRepository.findById(id);
    }

    // TIPO PAGO
    public List<TipoPagoEntity>  selectAllPayType() {
        return tipoPagoRepository.findAll();
    }
    public Optional<TipoPagoEntity>  selectPayTypeById(Integer id) {
        return tipoPagoRepository.findById(id);
    }

    // TIPO SOLICITUD
    public List<TipoSolicitudEntity>  selectAllRequestType() {
        return tipoSolicitudRepository.findAll();
    }
    public Optional<TipoSolicitudEntity>  selectRequestTypeById(Integer id) {
        return tipoSolicitudRepository.findById(id);
    }

    // TIPO USUARIO
    public List<TipoUsuarioEntity>  selectAllUsersType() {
        return tipoUsuarioRepository.findAll();
    }
    public Optional<TipoUsuarioEntity>  selectUserTypeById(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }
    
    // VALORES ESTATICOS
    public List<ValoresEstaticosEntity>  selectAllStaticValues() {
        return valoresEstaticosRepository.findAll();
    }
    public Optional<ValoresEstaticosEntity>  selectStaticValuesById(Integer id) {
        return valoresEstaticosRepository.findById(id);
    }
}
