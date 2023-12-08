package com.example.Bazar.Controller;

import com.example.Bazar.Model.Cliente;
import com.example.Bazar.Service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService clienServ;

    @PostMapping("/clientes/crear")
    public void crearCliente(@RequestBody Cliente cli) {
        clienServ.guardarCliente(cli);
    }

    @GetMapping("/clientes")
    public List<Cliente> listaClientes() {
        return clienServ.listaClientes();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable Long id_cliente) {
        return clienServ.buscarCliente(id_cliente);
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void eliminarCliente(@PathVariable Long id_cliente) {
        clienServ.borrarCliente(id_cliente);
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public void modificarCliente(@PathVariable Long id_cliente) {
        Cliente cli = clienServ.buscarCliente(id_cliente);

        clienServ.modificarCliente(cli);

    }
}
