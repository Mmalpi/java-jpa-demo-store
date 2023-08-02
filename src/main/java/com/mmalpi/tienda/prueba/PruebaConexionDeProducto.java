package com.mmalpi.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.mmalpi.tienda.dao.CategoriaDao;
import com.mmalpi.tienda.dao.ProductoDao;
import com.mmalpi.tienda.modelo.Categoria;
import com.mmalpi.tienda.modelo.Producto;
import com.mmalpi.tienda.utils.JPAUtils;

public class PruebaConexionDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		seleccionarProductoPorId();
		//JPQL
		consultaTablaProductos();
		consultaFiltrada();
	}

	private static void consultaFiltrada() {
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		List<Producto> productos = productoDao.consultaPorNombre("nombre");
		productos.forEach(prod -> System.out.println(prod.getDescripcion()));
	}

	private static void consultaTablaProductos() {
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		List<Producto> productos = productoDao.consultarTablaProductos();
		productos.forEach(prod -> System.out.println(prod.getDescripcion()));
	}

	private static void seleccionarProductoPorId() {
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaId(1l);
		System.out.println(producto.getNombre());
	}

	private static void registrarProducto() {
		Categoria categoriaPrueba = new Categoria("Prueba");
		Producto productoPrueba = new Producto("nombre", "descripcion", new BigDecimal("1000"), categoriaPrueba);
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		//begin the transactions
		em.getTransaction().begin();
		
		categoriaDao.guardar(categoriaPrueba);
		productoDao.guardar(productoPrueba);
		
		em.getTransaction().commit(); //.flush() allows a rollback in the DB
		em.close();
	}

}
