package com.bonnie.veterinaria.virtualvet.dao;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "registro_vacuna")
public class RegistroVacuna {
	
	@Id
	private String id;
	private Identificacion identificacion;
	private List<Vacunacion> vacunaciones;
	private Desparacitacion interna;
	private Desparacitacion externa;

}
