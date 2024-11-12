package com.project.panaderia.repository;

import com.project.panaderia.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoRepository extends CrudRepository<Pedido, Long> {
    List<Pedido> findByFechaPedidoBetween(String fechaInicio, String fechaFin);
    List<Pedido> findByEstado(String estado);
}