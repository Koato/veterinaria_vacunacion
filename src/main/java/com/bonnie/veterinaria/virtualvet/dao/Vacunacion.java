package com.bonnie.veterinaria.virtualvet.dao;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vacunacion {
	
	private LocalDate fechaProgramada;
	private LocalDate fechaAplicacion;
	private String firma;
	private Boolean parvovirus;
	private Boolean coronavirus;
	private Boolean distemper;
	private Boolean hepatitis;
	private Boolean parainfluenza;
	private Boolean leptospirosisCanicola;
	private Boolean leptospirosisIcterohaemorrhagiae;
	private Boolean leptospirosisGrippotyphosa;
	private Boolean leptospirosisPomona;
	private Boolean rabia;
	private Boolean rinotraqueitis;
	private Boolean panleucopenia;
	private Boolean calicivirus;
	private Frasco etiquetaFrasco;

}
