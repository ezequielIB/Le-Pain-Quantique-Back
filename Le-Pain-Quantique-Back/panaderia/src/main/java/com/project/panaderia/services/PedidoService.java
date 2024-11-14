package com.project.panaderia.services;

import com.project.panaderia.DTO.DetallePedidoDTO;
import com.project.panaderia.DTO.EstadoDTO;
import com.project.panaderia.DTO.PedidoDTO;
import com.project.panaderia.entity.DetallePedido;
import com.project.panaderia.entity.Pedido;
import com.project.panaderia.entity.Producto;
import com.project.panaderia.entity.Usuario;
import com.project.panaderia.exeptions.CustomException;
import com.project.panaderia.repository.IDetallePedidoRepository;
import com.project.panaderia.repository.IPedidoRepository;
import com.project.panaderia.repository.IProductoRepository;
import com.project.panaderia.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private IPedidoRepository pedidoRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IProductoRepository productoRepository;
    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;
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
    public List<Pedido> getPedidoByUser(Long id) {
        return pedidoRepository.getPedidosPorUsuario(id);
    }

    @Override
    public boolean cambiarEstado(EstadoDTO estadoDTO) {
        Pedido p = pedidoRepository.findById(estadoDTO.getPedidoId()).orElseThrow(() -> new CustomException("pedido no existe"));
        p.setEstado(estadoDTO.getNuevoEstado());
        pedidoRepository.save(p);
        return true;
    }

    @Override
    @Transactional
    public Pedido crearPedido(PedidoDTO pedido) {
        Pedido pedidoNuevo = new Pedido();
        pedidoNuevo.setFecha(pedido.getFecha());

        Usuario usuario = usuarioRepository.findById(pedido.getUsuarioId()).orElseThrow(() -> new CustomException("Usuario no encontrado"));
        pedidoNuevo.setUsuario(usuario);

        List<DetallePedido> detallePedidos = new ArrayList<>();

        for(DetallePedidoDTO detalleDTO:pedido.getDetallePedidos()){
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setCantidad(detalleDTO.getCantidad());
            detallePedido.setPedido(pedidoNuevo);
            Producto prod = productoRepository.findById(detalleDTO.getProductoId()).orElseThrow(() -> new CustomException("producto no encontrado"));
            detallePedido.setProducto(prod);

            detallePedidos.add(detallePedido);
            detallePedidoRepository.save(detallePedido);

        }
        pedidoNuevo.setDetallePedidos(detallePedidos);

        pedidoRepository.save(pedidoNuevo);

        return pedidoNuevo;
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
