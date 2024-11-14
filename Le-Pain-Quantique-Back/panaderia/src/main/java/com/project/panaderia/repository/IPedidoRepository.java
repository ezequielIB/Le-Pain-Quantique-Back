package com.project.panaderia.repository;

import com.project.panaderia.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPedidoRepository extends CrudRepository<Pedido, Long> {
    @Query("select p from Pedido p where p.usuario.id=?1")
    List<Pedido> getPedidosPorUsuario (Long id);
}
