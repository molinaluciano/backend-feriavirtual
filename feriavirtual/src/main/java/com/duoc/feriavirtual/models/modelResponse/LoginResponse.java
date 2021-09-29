package com.duoc.feriavirtual.models.modelResponse;

public class LoginResponse {
    private Integer status_out;
    private String tipo_usuario_out;
    private Integer id_usuario_out;

    public Integer getStatus_out() {
        return status_out;
    }

    public void setStatus_out(Integer status_out) {
        this.status_out = status_out;
    }

    public String getTipo_usuario_out() {
        return tipo_usuario_out;
    }

    public void setTipo_usuario_out(String tipo_usuario_out) {
        this.tipo_usuario_out = tipo_usuario_out;
    }

    public Integer getId_usuario_out() {
        return id_usuario_out;
    }

    public void setId_usuario_out(Integer id_usuario_out) {
        this.id_usuario_out = id_usuario_out;
    }

}
