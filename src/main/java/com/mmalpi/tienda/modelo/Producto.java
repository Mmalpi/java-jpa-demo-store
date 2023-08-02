package com.mmalpi.tienda.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mapeo de entidades //entity mapping
@Entity
@Table(name="productos") //setting the table name for the mapping //nombre de la tabla en el mapeo
public class Producto {
	//setting variable for the columns in the table, same type as the table
	//setteando variables por cada una de las columbnas en la tabla del mismo tipo que la tabla
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Setting id field witch is autogenerated by the database //setteando el id que es generado automaticamente por la base de datos
	private Long id;
	//@Column(name="nombres") this only in case the column has a different name than the variable // Esto solo en caso de la columna tenga un nombred iferente a la variable
	private String nombre;
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	private String descripcion;
	private BigDecimal precio;
	
	
}