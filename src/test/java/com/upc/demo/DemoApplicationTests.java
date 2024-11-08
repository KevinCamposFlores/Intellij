package com.upc.demo;

import com.upc.demo.entidades.Producto;
import com.upc.demo.negocio.IProductoNegocio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {


	@Autowired
	private IProductoNegocio productoNegocio;
	@Test
	void contextLoads() {
	}

	@Test
	void testRegistrar (){
		Producto producto = new Producto();
		producto.setDescripcion("Pepsi"
		);

		producto.setPrecio(3);
		producto.setStock(10);
		productoNegocio.registrar(producto);
	}


	@Test
	void testbuscar(){
		Producto producto = new Producto();
		try{
			producto = productoNegocio.buscar(2L);
			System.out.println("El producto es: " + producto);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testActualizar(){

		Producto producto = new Producto();
		producto.setDescripcion("coca cola");
		producto.setPrecio(4);
		producto.setStock(200);
		producto.setCodigo(1L);
        try {
            productoNegocio.actualizar(producto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

@Test
void testListado(){

	List<Producto> productos = productoNegocio.listado();

	System.out.println("Listado de productos: ");

	for (Producto producto : productos) {
		System.out.println(producto+"\n");
	}

}

	@Test
	void testEliminar(){

		List<Producto> productos = productoNegocio.listasdoTotal();
		for (Producto producto : productos) {
			System.out.println(producto);
		}


	}

	@Test
	void testlistadoPorDescripcion(){
        List<Producto> productos = null;
        try {
            productos = productoNegocio.listadoporDescripcion("coca");
			for (Producto producto : productos) {
				System.out.println("Listado de productos: " + producto);
			}

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


	}

	@Test
	void testListadoTotal(){

		List<Producto> productos = productoNegocio.listasdoTotal();
		for (Producto producto : productos) {
			System.out.println(producto);
		}

	}

	@Test
	void terminal(){

			System.out.println("terminal");


	}

}
