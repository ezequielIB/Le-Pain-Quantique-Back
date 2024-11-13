package com.project.panaderia.controllers;

import com.project.panaderia.entity.Pedido;
import com.project.panaderia.entity.Reserva;
import com.project.panaderia.services.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @GetMapping("/listar")
    public List<Reserva> listar() {
        return reservaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> porId(@PathVariable Long id) {
        return reservaService.porId(id);
    }

    @PostMapping("/guardar")
    public Reserva guardar(@RequestBody Pedido reserva) {
        return reservaService.guardar(reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
    }
}
