package com.mmalpi.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mmalpi.tienda.modelo.Producto;

public class RegistroDeProducto {

	public static void main(String[] args) {

		Producto productoPrueba = new Producto();
		
		productoPrueba.setNombre("nombre");
		productoPrueba.setDescripcion("descripcion");
		productoPrueba.setPrecio(new BigDecimal("1000"));
		
		//instance the entity using the name created in the persistence.xml //instancia la entidad usando el nombre declarado en el xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
		EntityManager em = factory.createEntityManager();
		
		//begin the transactions
		em.getTransaction().begin();
		em.persist(productoPrueba);
		em.getTransaction().commit();
		em.close();
	}

}
