package com.project.panaderia.repository;

import com.project.panaderia.entity.DetallePedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDetallePedidoRepository extends CrudRepository<DetallePedido, Long> {
    List<DetallePedido> listarPorPedidoId(Long pedidoId);

}
