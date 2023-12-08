package com.example.Bazar.Repository;

import com.example.Bazar.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{
    
}
