package com.project.panaderia.controllers;

import com.project.panaderia.entity.Tipo;
import com.project.panaderia.services.ITipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private ITipoService tipoService;

    @GetMapping("/listar")
    public List<Tipo> listar() {
        return tipoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Tipo> porId(@PathVariable Long id) {
        return tipoService.porId(id);
    }

    @PostMapping("/guardar")
    public Tipo guardar(@RequestBody Tipo tipo) {
        return tipoService.guardar(tipo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tipoService.eliminar(id);
    }
}
