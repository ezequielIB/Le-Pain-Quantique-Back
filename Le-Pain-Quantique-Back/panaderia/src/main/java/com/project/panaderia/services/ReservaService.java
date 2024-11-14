package com.project.panaderia.services;

import com.project.panaderia.entity.Pedido;
import com.project.panaderia.entity.Reserva;
import com.project.panaderia.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaService {

    @Autowired
    private IReservaRepository reservaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> listar() {
        return (List<Reserva>) reservaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reserva> porId(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva guardar(Pedido reserva) {
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> listarPorIds(Iterable<Long> ids) {
        return (List<Reserva>) reservaRepository.findAllById(ids);
    }

    @Override
    public List<Reserva> listarPorFecha(String fecha) {
        return List.of();
    }

    @Override
    public List<Reserva> listarPorClienteId(Long clienteId) {
        return List.of();
    }
}
