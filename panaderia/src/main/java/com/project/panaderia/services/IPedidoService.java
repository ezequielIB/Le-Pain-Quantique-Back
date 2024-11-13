package com.project.panaderia.services;

import com.project.panaderia.entity.Pedido;
import java.util.List;
import java.util.Optional;

public interface IPedidoService {
    List<Pedido> listar();
    Optional<Pedido> porId(Long id);
    Pedido guardar(Pedido pedido);
    void eliminar(Long id);
    List<Pedido> listarPorIds(Iterable<Long> ids);

    List<Pedido> listarPorEstado(String estado);
    List<Pedido> listarPorRangoFechas(String fechaInicio, String fechaFin);
}
