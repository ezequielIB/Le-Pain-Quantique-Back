package com.project.panaderia.controllers;

import com.project.panaderia.entity.DetallePedido;
import com.project.panaderia.entity.Pedido;
import com.project.panaderia.services.IDetallePedidoService;
import com.project.panaderia.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalles")
public class DetallePedidoController {

    @Autowired
    private IDetallePedidoService detallePedidoService;

    @GetMapping("/listar")
    public List<DetallePedido> listar() {
        return detallePedidoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<DetallePedido> porId(@PathVariable Long id) {
        return detallePedidoService.porId(id);
    }

    @PostMapping("/guardar")
    public DetallePedido guardar(@RequestBody DetallePedido detallePedido) {
        return detallePedidoService.guardar(detallePedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        detallePedidoService.eliminar(id);
    }
}
