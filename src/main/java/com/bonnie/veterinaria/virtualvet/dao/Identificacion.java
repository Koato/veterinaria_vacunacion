package com.bonnie.veterinaria.virtualvet.dao;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Identificacion {

	private String nombre;
	private String urlFoto;
	private String especie;
	private LocalDate fechaNacimiento;
	private String raza;
	private String color;
	private String genero;
	private Long microchip;
	private Long hc;
	private String Propietario;
	
}
