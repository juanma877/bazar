package com.example.Bazar.Service;

import com.example.Bazar.Model.Producto;
import com.example.Bazar.Repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository produRep;

    @Override
    public void guardarProducto(Producto pro) {
        produRep.save(pro);
    }

    @Override
    public List<Producto> listaProducto() {
        return produRep.findAll();
    }

    @Override
    public void eliminarProducto(Long codigo_producto) {
        produRep.deleteById(codigo_producto);
    }

    @Override
    public Producto buscarProducto(Long codigo_producto) {
        return produRep.findById(codigo_producto).orElse(null);
    }

    @Override
    public void modificarProducto(Producto pro) {
        produRep.save(pro);
       
    }

    @Override
    public List<Producto> sinStock() {
        List<Producto> todos = listaProducto();
        List<Producto> sinStock = new ArrayList<>();
        for(Producto pro : todos){
         if(pro.getCantidad_disponible() < 5 ){
            sinStock.add(pro);
         }   
        }
        return sinStock; 
    }

    

    

}
