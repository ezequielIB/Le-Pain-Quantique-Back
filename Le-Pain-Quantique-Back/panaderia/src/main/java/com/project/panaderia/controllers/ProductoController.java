package com.project.panaderia.controllers;

import com.project.panaderia.entity.Pedido;
import com.project.panaderia.entity.Producto;
import com.project.panaderia.services.IPedidoService;
import com.project.panaderia.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public Iterable<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Producto> porId(@PathVariable Long id) {
        return productoService.porId(id);
    }

    @PostMapping("/guardar")
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
