package com.project.panaderia.services;

import com.project.panaderia.entity.Producto;
import com.project.panaderia.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> porId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarPorIds(Iterable<Long> ids) {
        return (List<Producto>) productoRepository.findAllById(ids);
    }

    @Override
    public Optional<Producto> findByCodigoProducto(String codigoProducto) {
        return Optional.empty();
    }

    @Override
    public boolean existsByCodigoProducto(String codigoProducto) {
        return false;
    }

    @Override
    public List<Producto> listarPorCategoria(String categoria) {
        return List.of();
    }

}
