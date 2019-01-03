package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Video {

	@NotEmpty
	private long id;
	
	@NotEmpty
	@Size(min=4, max=150)
	private String nombre;
	
	@NotEmpty
	@Size(min=11,max=11)
	private String codigo;


	public Video() {
		super();
		this.id = -1;
		this.nombre = "Surf Search Spot 2 0 video promo";
		this.codigo = "LPDhuthFD98";
	}
	
	public Video(String nombre) {
		this();
		setNombre( nombre);
	}
	
	public Video(String nombre, String codigo) {
		this();
		setNombre( nombre);
		setCodigo( codigo);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}
	



}
