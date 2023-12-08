package com.example.Bazar.Service;

import com.example.Bazar.Model.Cliente;
import com.example.Bazar.Repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clieRepo;
    
    @Override
    public void guardarCliente(Cliente cli) {
       clieRepo.save(cli);
    }

    @Override
    public List<Cliente> listaClientes() {
      return  clieRepo.findAll();        
    }

    @Override
    public void borrarCliente(Long id) {
        clieRepo.deleteById(id);
    }

    @Override
    public Cliente buscarCliente(Long id) {
       return clieRepo.findById(id).orElse(null);       
    }

    @Override
    public void modificarCliente(Cliente cli) {
        clieRepo.save(cli);
    }
    
}
