package com.upc.demo.repositorio;

import com.upc.demo.entidades.Producto;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductoRepositorio  extends JpaRepository<Producto, Long>  {

    public List<Producto> findByDescripcionStartingWith(String prefix);

    @Query("SELECT p From Producto p WHERE p.descripcion like %:prefijo%")
    public List<Producto> obtenerReportePorDescripcion(@Param("prefijo") String prefijo);

}
