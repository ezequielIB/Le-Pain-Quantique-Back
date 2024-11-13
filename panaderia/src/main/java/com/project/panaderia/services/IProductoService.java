package com.project.panaderia.services;

import com.project.panaderia.entity.Producto;
import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Iterable<Producto> listar();
    Optional<Producto> porId(Long id);
    Producto guardar(Producto producto);
    void eliminar(Long id);
    List<Producto> listarPorIds(Iterable<Long> ids);

    Optional<Producto> findByCodigoProducto(String codigoProducto);
    boolean existsByCodigoProducto(String codigoProducto);
    List<Producto> listarPorCategoria(String categoria);
}
