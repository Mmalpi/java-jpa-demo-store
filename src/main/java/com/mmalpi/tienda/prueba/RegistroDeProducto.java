package com.mmalpi.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.mmalpi.tienda.dao.CategoriaDao;
import com.mmalpi.tienda.dao.ProductoDao;
import com.mmalpi.tienda.modelo.Categoria;
import com.mmalpi.tienda.modelo.Producto;
import com.mmalpi.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Categoria categoriaPrueba = new Categoria("Prueba");
		Producto productoPrueba = new Producto("nombre", "descripcion", new BigDecimal("1000"), categoriaPrueba);
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		//begin the transactions
		em.getTransaction().begin();
		
		categoriaDao.guardar(categoriaPrueba);
		productoDao.guardar(productoPrueba);
		
		em.getTransaction().commit();
		em.close();
	}

}
