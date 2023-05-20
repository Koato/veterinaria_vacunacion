package com.bonnie.veterinaria.virtualvet.dao;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VirtualVet {

	private String id;
	private Identificacion identificacion;
	private List<Vacunacion> vacunaciones;
	private Desparacitacion interna;
	private Desparacitacion externa;
	
}
