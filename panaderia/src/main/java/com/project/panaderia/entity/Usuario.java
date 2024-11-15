package com.project.panaderia.entity;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //depende de q la base de datos qusas lo soporte, mysql lo soporta
    private Long id;
    //@Column() // si fuese necesitario cambiar algunas propiedades como el nombre en la tabla o si es unico, etc, va acá

    private String nombre;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}