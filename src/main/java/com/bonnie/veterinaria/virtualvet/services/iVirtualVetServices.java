package com.bonnie.veterinaria.virtualvet.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.bonnie.veterinaria.virtualvet.dao.VirtualVet;

public interface iVirtualVetServices {

	Page<VirtualVet> findAll(Pageable pageable);

	VirtualVet findById(String id);

	VirtualVet guardarVirtualVet(VirtualVet virtualVet);

	VirtualVet actualizarVirtualVet(VirtualVet virtualVet);
}
