package com.project.panaderia.DTO;

import java.util.List;

public class PedidoDTO {
    private String fecha;
    private Long usuarioId;
    private List<DetallePedidoDTO> detallePedidos;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<DetallePedidoDTO> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedidoDTO> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
}