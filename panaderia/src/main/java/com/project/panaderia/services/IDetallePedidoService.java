package com.project.panaderia.services;

import com.project.panaderia.entity.DetallePedido;
import java.util.List;
import java.util.Optional;

public interface IDetallePedidoService {
    List<DetallePedido> listar();
    Optional<DetallePedido> porId(Long id);
    DetallePedido guardar(DetallePedido detallePedido);
    void eliminar(Long id);
    List<DetallePedido> listarPorPedidoId(Long pedidoId);
    List<DetallePedido> listarPorIds(Iterable<Long> ids);
}
