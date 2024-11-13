package com.project.panaderia.controllers;

import com.project.panaderia.entity.Usuario;
import com.project.panaderia.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> porId(@PathVariable Long id) {
        return usuarioService.porId(id);
    }

    @PostMapping("/guardar")
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }

    @GetMapping("/buscarPorEmail")
    public Optional<Usuario> buscarPorEmail(@RequestParam String email) {
        return usuarioService.findByEmail(email);
    }
}
