package com.example.Bazar.Repository;

import com.example.Bazar.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    
}
