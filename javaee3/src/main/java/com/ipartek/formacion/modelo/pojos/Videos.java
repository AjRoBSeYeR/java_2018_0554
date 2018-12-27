package com.ipartek.formacion.modelo.pojos;

public class Videos {

	// Atributos
	private long id;
	private String nombre;
	private String url;

	// Constructores

	public Videos(Long id, String nombre, String url) {
		super();
		setId(id);
		setNombre(nombre);
		setUrl(url);
		
		
		
	}
	
	public Videos() {
		super();
		this.id = -1;
		this.nombre = "";
		this.url = "";
	}

	public Videos(String nombre) {
		this();
		this.nombre = nombre;
	}

	// Getters y Setters

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// Otros metodos => toString

	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}

}