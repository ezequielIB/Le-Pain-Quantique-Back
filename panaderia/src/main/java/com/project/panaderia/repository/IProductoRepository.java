package com.project.panaderia.repository;

import com.project.panaderia.entity.Pedido;
import com.project.panaderia.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductoRepository extends CrudRepository<Producto, Long> {

}
