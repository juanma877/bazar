package com.example.Bazar.Service;

import com.example.Bazar.Dto.VentaMasAltaDTO;
import com.example.Bazar.Dto.VentasDTO;

import java.util.List;
import com.example.Bazar.Model.Venta;
import com.example.Bazar.Repository.IVentaRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRep;

    @Override
    public void guardarVenta(Venta ve) {
        ventaRep.save(ve);
    }

    @Override
    public List<Venta> listaVentas() {
        return ventaRep.findAll();
    }

    @Override
    public void borrarVenta(Long codigo_venta) {
        ventaRep.deleteById(codigo_venta);
    }

    @Override
    public Venta buscarVenta(Long codigo_venta) {
        return ventaRep.findById(codigo_venta).orElse(null);
    }

    @Override
    public void modificarVenta(Venta ve) {
        ventaRep.save(ve);
    }

    @Override
    public VentasDTO obtenerVentasTotalesPorFecha(LocalDate fecha_venta) {
        List<Venta> ventasDelDia = ventaRep.findAll();
        double sumatoriaMonto = ventasDelDia.stream().mapToDouble(Venta::getTotal).sum();
        int cantidadTotalVentas = ventasDelDia.size();

        return new VentasDTO(sumatoriaMonto, cantidadTotalVentas);
    }

    @Override
    public VentaMasAltaDTO ventaMayorValor() {
        List<Venta> listar = listaVentas();
        
        Venta ve = listar.stream().max((v1,v2)-> Double.compare(v1.getTotal(), v2.getTotal())).orElse(null);
        Long codigo_venta = ve.getCodigo_venta();
        double total = ve.getTotal();
        int cantidad = ve.getListaProductos().size();
        String nombre = ve.getUnCliente().getNombre();
        String apellido = ve.getUnCliente().getApellido();

        return new VentaMasAltaDTO(codigo_venta, total, cantidad, nombre, apellido);

    }

}
