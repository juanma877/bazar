package com.example.Bazar.Service;

import com.example.Bazar.Model.Producto;
import java.util.List;

public interface IProductoService {

    public void guardarProducto(Producto pro);

    public List<Producto> listaProducto();

    public void eliminarProducto(Long id);

    public Producto buscarProducto(Long id);

    public void modificarProducto(Producto pro);

    public List<Producto> sinStock();
}
