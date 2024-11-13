package com.project.panaderia.services;

import com.project.panaderia.entity.Tipo;
import com.project.panaderia.repository.ITipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService implements ITipoService {

    @Autowired
    private ITipoRepository tipoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Tipo> listar() {
        return (List<Tipo>) tipoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tipo> porId(Long id) {
        return tipoRepository.findById(id);
    }

    @Override
    @Transactional
    public Tipo guardar(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        tipoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tipo> listarPorIds(Iterable<Long> ids) {
        return (List<Tipo>) tipoRepository.findAllById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tipo> findByNombre(String nombre) {
        return tipoRepository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByNombre(String nombre) {
        return tipoRepository.existsByNombre(nombre);
    }
}
