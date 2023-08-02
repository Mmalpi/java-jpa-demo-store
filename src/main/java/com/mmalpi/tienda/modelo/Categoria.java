package com.mmalpi.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//limited number of categories in a column that is why we use an enum
//public enum Categoria {
//
//	SOFTWARES,
//	LIBROS,
//	CELULARES
//}

@Entity
@Table(name="categorias")
public class Categoria{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	
	
	public Categoria() {
	}


	public Categoria(String nombre) {
		this.nombre = nombre;
	}
	
	
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}