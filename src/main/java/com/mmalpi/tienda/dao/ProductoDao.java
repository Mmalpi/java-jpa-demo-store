package com.mmalpi.tienda.dao;

import java.util.List;

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
	
	public void actualizar(Producto producto) {
		this.em.merge(producto);
	}
	
	public void remover(Producto producto) {
		producto = this.em.merge(producto);
		this.em.remove(producto);
	}
	
	public Producto consultaId(Long id) {
		
		return em.find(Producto.class, id);
	}
	
	//using JPQL
	public List<Producto> consultarTablaProductos(){
		String jpql = "SELECT P FROM Producto AS P";
		return em.createQuery(jpql, Producto.class).getResultList(); //obtaining the result list
	}
	public List<Producto> consultaPorNombre(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre =: nombre";
		return em.createQuery(jpql).setParameter("nombre", nombre).getResultList();
		
	}
}
