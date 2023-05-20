package com.bonnie.veterinaria.virtualvet.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "propietario")
public class Propietario {
	
	@Id
	private String id;
	private String nombre;
	private String apellido;
	private String correo;
	private String numeroCelular;
	private String domicilio;
}
