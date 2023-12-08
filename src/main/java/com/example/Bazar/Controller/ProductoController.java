package com.example.Bazar.Controller;

import com.example.Bazar.Model.Producto;
import com.example.Bazar.Service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService proServ;

    @PostMapping("/productos/crear")
    public void crearProducto(@RequestBody Producto pro) {
        proServ.guardarProducto(pro);
    }

    @GetMapping("/productos")
    public void listarProductos() {
        proServ.listaProducto();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto traerProducto(@PathVariable Long codigo_producto) {
        return proServ.buscarProducto(codigo_producto);
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable Long codigo_producto) {
        proServ.eliminarProducto(codigo_producto);
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public void editarProducto(@PathVariable Long codigo_producto) {
        Producto pro = proServ.buscarProducto(codigo_producto);
        proServ.modificarProducto(pro);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> productosFaltaStock() {
       return proServ.sinStock();
     }
}
