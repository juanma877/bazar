package com.example.Bazar.Service;

import com.example.Bazar.Model.Cliente;
import java.util.List;

public interface IClienteService {
    
    public void guardarCliente(Cliente cli);
    
    public List<Cliente> listaClientes();
    
    public void borrarCliente(Long id);
    
    public Cliente buscarCliente(Long id);
    
    public void modificarCliente(Cliente cli);
    
    
}
