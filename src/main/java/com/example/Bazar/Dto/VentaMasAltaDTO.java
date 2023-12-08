package com.example.Bazar.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaMasAltaDTO {
    private Long codigo_venta;
    private double total;
    private int cantidad;
    private String nombre;
    private String apellido;

    public VentaMasAltaDTO() {
    }

    public VentaMasAltaDTO(Long codigo_venta, double total, int cantidad, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
