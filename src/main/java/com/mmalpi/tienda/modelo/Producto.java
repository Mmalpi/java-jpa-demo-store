package com.mmalpi.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private String descripcion;
	private BigDecimal precio;
	private LocalDate fechaDeRegistro = LocalDate.now(); //saving the date with the actual date
	/*
	 * // this is not a very good practice because it is not very flexible for future changes.
	 *@Enumerated(EnumType.STRING) //Enumerate works for saving the word instead of the number or position int the enum class
	 * private Categoria categoria; //limited number of categories in a column that is why we use an enum
	 * */
	@ManyToOne //relation between producto and categoria
	private Categoria categoria;
	
	public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
	}
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

	
}
