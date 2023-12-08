package com.example.Bazar.Service;

import com.example.Bazar.Dto.VentaMasAltaDTO;
import com.example.Bazar.Dto.VentasDTO;
import com.example.Bazar.Model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public void guardarVenta(Venta ve);

    public List<Venta> listaVentas();

    public void borrarVenta(Long id);

    public Venta buscarVenta(Long id);

    public void modificarVenta(Venta ve);

    public VentasDTO obtenerVentasTotalesPorFecha(LocalDate fecha_venta);

    public VentaMasAltaDTO ventaMayorValor();
}
