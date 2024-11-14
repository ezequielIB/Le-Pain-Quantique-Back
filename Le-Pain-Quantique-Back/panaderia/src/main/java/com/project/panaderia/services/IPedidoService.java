package com.project.panaderia.services;

import com.project.panaderia.DTO.DetallePedidoDTO;
import com.project.panaderia.DTO.EstadoDTO;
import com.project.panaderia.DTO.PedidoDTO;
import com.project.panaderia.entity.Pedido;
import com.project.panaderia.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {
    List<Pedido> listar();
    Optional<Pedido> porId(Long id);
    List<Pedido> getPedidoByUser(Long id);
    boolean cambiarEstado(EstadoDTO estadoDTO);
    Pedido guardar(Pedido pedido);
    Pedido crearPedido(PedidoDTO pedido);

    void eliminar(Long id);
    List<Pedido> listarPorIds(Iterable<Long> ids);

    List<Pedido> listarPorEstado(String estado);
    List<Pedido> listarPorRangoFechas(String fechaInicio, String fechaFin);
}
