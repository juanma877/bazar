package com.example.Bazar.Repository;

import com.example.Bazar.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
   
}
