package com.bonnie.veterinaria.virtualvet.dao;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "desparacitacion")
public class Desparacitacion {

	@Id
	private String id;
	private LocalDate fechaAplicacion;
	private Double peso;
	private String producto;
	private LocalDate fechaProxAplicacion;
	
}
