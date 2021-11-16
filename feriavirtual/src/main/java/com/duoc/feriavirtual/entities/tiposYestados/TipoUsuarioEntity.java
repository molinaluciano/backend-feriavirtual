package com.duoc.feriavirtual.entities.tiposYestados;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;


import java.io.Serializable;
import javax.persistence.Column;

@Entity(name = "TIPO_USUARIO")
@NamedStoredProcedureQueries({})
public class TipoUsuarioEntity implements Serializable{
    @Id
    @Column(name = "ID_TIPO_USUARIO")
    private Integer idTipoUsuario;
    @Column(name = "CATEGORIA")
    private String categoria;
    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }
    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
