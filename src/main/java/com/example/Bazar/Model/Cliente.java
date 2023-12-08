package com.example.Bazar.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, String dni) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
    
}
