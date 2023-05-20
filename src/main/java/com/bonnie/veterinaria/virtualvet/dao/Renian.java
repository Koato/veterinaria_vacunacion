package com.bonnie.veterinaria.virtualvet.dao;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "renian")
public class Renian {

	@Id
	private String id;
	private String urlFoto;
	private Long microchip;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String genero;
	private String raza;
	private Propietario propietario;
}
