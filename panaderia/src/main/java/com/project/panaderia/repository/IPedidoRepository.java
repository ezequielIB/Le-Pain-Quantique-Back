package com.project.panaderia.repository;

import com.project.panaderia.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IPedidoRepository extends CrudRepository<Pedido, Long> {

}
