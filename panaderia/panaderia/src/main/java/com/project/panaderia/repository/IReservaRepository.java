package com.project.panaderia.repository;

import com.project.panaderia.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IReservaRepository extends CrudRepository<Reserva, Long> {
    List<Reserva> findByFechaReserva(String fecha);
    List<Reserva> findByClienteId(Long clienteId);
}
