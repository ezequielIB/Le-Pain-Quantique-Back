package com.project.panaderia.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;

    // Getters y Setters
    // ...
}
