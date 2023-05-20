package com.bonnie.veterinaria.virtualvet.dao;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Frasco {

	private String numeroSerie;
	private LocalDate fechaFabricacion;
	private LocalDate fechaVencimiento;
	
}
