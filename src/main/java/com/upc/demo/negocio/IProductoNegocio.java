package com.upc.demo.negocio;

import com.upc.demo.entidades.Producto;

import java.util.List;

public interface IProductoNegocio {

public Producto registrar(Producto producto);
public Producto actualizar(Producto producto) throws Exception;
public Producto buscar(Long codigo) throws Exception;
public List<Producto> listado();
public double calcularIGV(Producto producto);
public double calcularDescuente(Producto producto);
public double calcularPrecioventa(Producto producto);
public double calcularPrecioVenta(Long codigo) throws Exception;
public List<Producto> listasdoTotal();
public double eliminar(Long Codigo) throws Exception;
public List<Producto> listadoporDescripcion(String descripcion) throws Exception;
    }