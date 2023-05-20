package com.bonnie.veterinaria.virtualvet.dao;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "frasco_vacuna")
public class FrascoVacuna {

	@Id
	private String id;
	private String numeroSerie;
	private LocalDate fechaFabricacion;
	private LocalDate fechaVencimiento;
	
}
