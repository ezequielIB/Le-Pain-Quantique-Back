package com.project.panaderia.services;

import com.project.panaderia.entity.Tipo;
import java.util.List;
import java.util.Optional;

public interface ITipoService {
    List<Tipo> listar();
    Optional<Tipo> porId(Long id);
    Tipo guardar(Tipo tipo);
    void eliminar(Long id);
    List<Tipo> listarPorIds(Iterable<Long> ids);

    Optional<Tipo> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
