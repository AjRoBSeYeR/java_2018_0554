package com.ipartek.formacion.taller.service.exception;

public class RolException extends Exception {

	


	private static final long serialVersionUID = 1L;

	public static final String EXCEPTION_EXIST = "El nombre del combustible ya existe";
	
	public static final String EXCEPTION_CONSTRAINT = "No se puede eliminar si existe un Vehiculo con este combustible asociado";

	
	public RolException(String message) {
		super(message);				
	}
	
}

