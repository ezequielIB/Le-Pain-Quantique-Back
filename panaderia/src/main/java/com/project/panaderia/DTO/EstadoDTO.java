package com.project.panaderia.DTO;

public class EstadoDTO {
    private Integer nuevoEstado;
    private Long pedidoId;

    public Integer getNuevoEstado() {
        return nuevoEstado;
    }

    public void setNuevoEstado(Integer nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long productoId) {
        this.pedidoId = productoId;
    }
}
