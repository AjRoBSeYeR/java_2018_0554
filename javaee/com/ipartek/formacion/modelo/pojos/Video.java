package com.ipartek.formacion.modelo.pojos;

public class Video {

	//atributos
	private long id;
	private String nombre;
	private String url;
	
	
	//constructores
	
	public Video() {
		super();
		this.id=-1;
		this.nombre = "Megadeth - Dystopia";
		this.url = "https://www.youtube.com/watch?v=bK95lWHl7js";
	}


	public Video(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	
	//getters and setters
	
	
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


	
	
	//otros metodos =>string
	@Override
	public String toString() {
		return "Video [id=" + id + ", nombre=" + nombre + ", url=" + url + "]";
	}
	
	
}
