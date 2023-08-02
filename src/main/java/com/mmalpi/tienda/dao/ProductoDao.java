package com.mmalpi.tienda.dao;

import javax.persistence.EntityManager;

import com.mmalpi.tienda.modelo.Producto;

public class ProductoDao {

	private EntityManager em;

	public ProductoDao(EntityManager em) {
		this.em = em;
	}
	
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
}
