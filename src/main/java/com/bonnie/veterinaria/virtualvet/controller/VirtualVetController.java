package com.bonnie.veterinaria.virtualvet.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bonnie.veterinaria.virtualvet.dao.VirtualVet;
import com.bonnie.veterinaria.virtualvet.exception.VirtualVetNotFoundException;
import com.bonnie.veterinaria.virtualvet.services.iVirtualVetServices;

@RestController
@RequestMapping(value = "/veterinaria")
public class VirtualVetController {

	@Autowired
	private iVirtualVetServices services;

	private static final String RESPONSE_ERROR = "error";
	private static final String RESPONSE_MENSAJE = "mensaje";

	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAll(@Param(value = "page") Pageable pageable) {
		return ResponseEntity.ok(services.findAll(pageable));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> viaje(@PathVariable(required = true) String id) {
		Map<String, Object> response = new HashMap<>();
		try {
			return ResponseEntity.ok(services.findById(id));
		} catch (VirtualVetNotFoundException e) {
			response.put(RESPONSE_ERROR, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} catch (DataAccessException e) {
			response.put(RESPONSE_MENSAJE, "Error al realizar la consulta en la base de datos");
			response.put(RESPONSE_ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<Object> insertarRegistro(@RequestBody(required = true) VirtualVet virtualVet) {
		Map<String, Object> response = new HashMap<>();
		try {
			VirtualVet viajesNuevo = services.guardarVirtualVet(virtualVet);
			response.put(RESPONSE_MENSAJE, "Ha sido insertado con éxito");
			response.put("registro", viajesNuevo);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put(RESPONSE_MENSAJE, "Error al insertarlo en la base de datos");
			response.put(RESPONSE_ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> actualizarRegistro(@PathVariable(required = true) String id,
			@RequestBody(required = true) VirtualVet virtualVet) {
		Map<String, Object> response = new HashMap<>();
		try {
			virtualVet.setId(id);
			services.actualizarVirtualVet(virtualVet);
			response.put(RESPONSE_MENSAJE, "Ha sido actualizado con éxito");
			response.put("registro", virtualVet);
			return ResponseEntity.ok(response);
		} catch (VirtualVetNotFoundException e) {
			response.put(RESPONSE_ERROR, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		} catch (DataAccessException e) {
			response.put(RESPONSE_MENSAJE, "Error al actualizarlo en la base de datos");
			response.put(RESPONSE_ERROR, e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
