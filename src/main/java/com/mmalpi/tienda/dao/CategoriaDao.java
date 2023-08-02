package com.mmalpi.tienda.dao;

import javax.persistence.EntityManager;

import com.mmalpi.tienda.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	
	public void guardar(Categoria categoria) {
		this.em.persist(categoria);
	}
}
