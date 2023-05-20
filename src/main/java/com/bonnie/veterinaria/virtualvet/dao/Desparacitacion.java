package com.bonnie.veterinaria.virtualvet.dao;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Desparacitacion {

	private LocalDate fechaAplicacion;
	private double peso;
	private String producto;
	private LocalDate fechaProxAplicacion;
	
}
