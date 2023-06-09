package com.bonnie.veterinaria.virtualvet.dao;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "identificacion")
public class Identificacion {

	@Id
	private String id;
	private String nombre;
	private String urlFoto;
	private String especie;
	private LocalDate fechaNacimiento;
	private String raza;
	private String color;
	private String genero;
	private Renian renian;
	private Long hc;
	private Propietario propietario;

}
