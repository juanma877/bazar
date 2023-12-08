package com.example.Bazar.Controller;

import com.example.Bazar.Dto.VentaMasAltaDTO;
import com.example.Bazar.Dto.VentasDTO;
import com.example.Bazar.Model.Producto;
import com.example.Bazar.Model.Venta;
import com.example.Bazar.Service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventServ;

    @PostMapping("/ventas/crear")
    public void crearVenta(@RequestBody Venta ven) {
        ventServ.guardarVenta(ven);
    }

    @GetMapping("/ventas")
    public List<Venta> listarVentas() {
        return ventServ.listaVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerVenta(@PathVariable Long codigo_venta) {
        return ventServ.buscarVenta(codigo_venta);
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void borrarVenta(@PathVariable Long codigo_venta) {
        Venta ven = ventServ.buscarVenta(codigo_venta);
        ventServ.modificarVenta(ven);
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public void editarVenta(@PathVariable Long codigo_venta) {
        Venta ven = ventServ.buscarVenta(codigo_venta);
        ventServ.modificarVenta(ven);
        System.out.println(ven);
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> listarProductos(@PathVariable Long codigo_venta) {
        Venta ven = ventServ.buscarVenta(codigo_venta);
        List<Producto> listaPro = ven.getListaProductos();
        return listaPro;
    }

    @GetMapping("/ventas/totales/{fecha_venta}")
    public VentasDTO obtenerVentasTotalesPorFecha(@PathVariable LocalDate fecha_venta) {
        return ventServ.obtenerVentasTotalesPorFecha(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public VentaMasAltaDTO obtenerVentaMasAlta() {
        return ventServ.ventaMayorValor();
    }
}
