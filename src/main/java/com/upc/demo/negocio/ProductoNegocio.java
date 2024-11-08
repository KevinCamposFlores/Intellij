package com.upc.demo.negocio;

import com.upc.demo.entidades.Producto;
import com.upc.demo.repositorio.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoNegocio  implements IProductoNegocio {

    @Autowired
    IProductoRepositorio iProductoRepositorio;

    @Override
    public Producto registrar(Producto producto) {
        return iProductoRepositorio.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) throws Exception {

       buscar(producto.getCodigo());

        return iProductoRepositorio.save(producto);
    }

    @Override
    public Producto buscar(Long codigo) throws Exception{
        return iProductoRepositorio.findById(codigo).orElseThrow( () -> new Exception(
                "No se encontro el producto con el codigo buscado"
        ));
    }

    @Override
    public List<Producto> listado() {
        return iProductoRepositorio.findAll();
    }

    @Override
    public double calcularIGV(Producto producto) {

        double igv = 0.0;
        if(producto != null) {
            igv = 0.18 * producto.getPrecio();
        }

        return igv;
    }

    @Override
    public double calcularDescuente(Producto producto) {

        double descuento = 0.0;
        if(producto != null) {
            if(producto.getStock() > 20){
                descuento =0.10 * producto.getPrecio();
            }

        }

        return descuento;
    }

    @Override
    public double calcularPrecioventa(Producto producto) {
        return producto.getPrecio() + calcularIGV(producto) - calcularDescuente(producto);
    }

    @Override
    public double calcularPrecioVenta(Long codigo) throws Exception {


        return calcularPrecioventa(buscar(codigo));
    }

    @Override
    public List<Producto> listasdoTotal() {

        List<Producto> listado = iProductoRepositorio.findAll();
        for(Producto producto : listado) {

            producto.setVenta(calcularPrecioventa(producto));
        }

        return listado;
    }

    @Override
    public double eliminar(Long Codigo) throws Exception {
        return 0;
    }

    @Override
    public List<Producto> listadoporDescripcion(String descripcion) throws Exception {
        return iProductoRepositorio.findByDescripcionStartingWith(descripcion);
    }


}
