package com.project.panaderia.services;

import com.project.panaderia.entity.Pedido;
import com.project.panaderia.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> listar() {
        return (List<Pedido>) pedidoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> porId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    @Transactional
    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> listarPorIds(Iterable<Long> ids) {
        return (List<Pedido>) pedidoRepository.findAllById(ids);
    }

    @Override
    public List<Pedido> listarPorEstado(String estado) {
        return List.of();
    }

    @Override
    public List<Pedido> listarPorRangoFechas(String fechaInicio, String fechaFin) {
        return List.of();
    }
}
