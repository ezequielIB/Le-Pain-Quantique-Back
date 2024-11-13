package com.project.panaderia.repository;

import com.project.panaderia.entity.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITipoRepository extends CrudRepository<Tipo, Long> {
    Optional<Tipo> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
