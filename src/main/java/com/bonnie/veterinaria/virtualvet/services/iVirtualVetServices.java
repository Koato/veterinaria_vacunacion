package com.bonnie.veterinaria.virtualvet.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.bonnie.veterinaria.virtualvet.dao.RegistroVacuna;

public interface iVirtualVetServices {

	Page<RegistroVacuna> findAll(Pageable pageable);

	RegistroVacuna findById(String id);

	RegistroVacuna guardarVirtualVet(RegistroVacuna virtualVet);

	RegistroVacuna actualizarVirtualVet(RegistroVacuna virtualVet);
}
