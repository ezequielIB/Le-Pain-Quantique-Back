package com.project.panaderia.services;

import com.project.panaderia.entity.DetallePedido;
import com.project.panaderia.repository.IDetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DetallePedido> listar() {
        return (List<DetallePedido>) detallePedidoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DetallePedido> porId(Long id) {
        return detallePedidoRepository.findById(id);
    }

    @Override
    @Transactional
    public DetallePedido guardar(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        detallePedidoRepository.deleteById(id);
    }

    @Override
    public List<DetallePedido> listarPorPedidoId(Long pedidoId) {
        return List.of();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetallePedido> listarPorIds(Iterable<Long> ids) {
        return (List<DetallePedido>) detallePedidoRepository.findAllById(ids);
    }
}
