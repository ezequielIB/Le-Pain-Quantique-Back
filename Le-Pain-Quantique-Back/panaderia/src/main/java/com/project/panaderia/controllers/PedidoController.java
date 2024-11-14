package com.project.panaderia.controllers;

import com.project.panaderia.DTO.DetallePedidoDTO;
import com.project.panaderia.DTO.EstadoDTO;
import com.project.panaderia.DTO.PedidoDTO;
import com.project.panaderia.entity.Pedido;
import com.project.panaderia.entity.Usuario;
import com.project.panaderia.exeptions.CustomException;
import com.project.panaderia.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping("/listar")
    public List<Pedido> listar() {
        return pedidoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> porId(@PathVariable Long id) {
        return pedidoService.porId(id);
    }

    @PostMapping("/guardar")
    public Pedido guardar(@RequestBody Pedido pedido) {
        return pedidoService.guardar(pedido);
    }

    @PostMapping("/crearPedido")
    public ResponseEntity<?> crearPedido(@RequestBody PedidoDTO pedido) {
        try {
            Pedido pedidoRetorno = pedidoService.crearPedido(pedido);
            return ResponseEntity.ok(pedidoRetorno);
        } catch (CustomException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado");
        }
    }

    @GetMapping("/usuario/{id}")
    public List<Pedido> porIdusUario(@PathVariable Long id) {
        return pedidoService.getPedidoByUser(id);
    }

    @PostMapping("/estado")
    public boolean cambiarEstado(@RequestBody EstadoDTO estadoDTO) {
        return pedidoService.cambiarEstado(estadoDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pedidoService.eliminar(id);
    }
}
