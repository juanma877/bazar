package com.example.Bazar.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentasDTO {
    private double sumatoriaMonto;
    private int cantidadVentas;
    
    public VentasDTO(double sumatoriaMonto, int cantidadVentas){
        this.sumatoriaMonto=sumatoriaMonto;
        this.cantidadVentas=cantidadVentas;
    }
}
