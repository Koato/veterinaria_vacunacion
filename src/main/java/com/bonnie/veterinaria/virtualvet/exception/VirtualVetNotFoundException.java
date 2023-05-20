package com.bonnie.veterinaria.virtualvet.exception;

import org.springframework.core.NestedRuntimeException;

public class VirtualVetNotFoundException extends NestedRuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VirtualVetNotFoundException(String id) {
		super("El Registro de Vacunación con ID '" + id + "' no ha sido encontrado");
	}

}
