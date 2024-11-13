package com.project.panaderia.services;

import com.project.panaderia.entity.Reserva;
import java.util.List;
import java.util.Optional;

public interface IReservaService {
    List<Reserva> listar();
    Optional<Reserva> porId(Long id);
    Reserva guardar(Reserva reserva);
    void eliminar(Long id);
    List<Reserva> listarPorIds(Iterable<Long> ids);

    List<Reserva> listarPorFecha(String fecha);
    List<Reserva> listarPorClienteId(Long clienteId);
}
