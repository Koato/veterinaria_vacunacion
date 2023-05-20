package com.bonnie.veterinaria.virtualvet.services.implement;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bonnie.veterinaria.virtualvet.dao.RegistroVacuna;
import com.bonnie.veterinaria.virtualvet.exception.VirtualVetNotFoundException;
import com.bonnie.veterinaria.virtualvet.repository.VirtualVetRepository;
import com.bonnie.veterinaria.virtualvet.services.iVirtualVetServices;
import com.mongodb.client.result.UpdateResult;

@Service("virtualVetServices")
public class VirtualVetServicesImpl implements iVirtualVetServices {

	@Autowired
	private VirtualVetRepository repository;

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	@Transactional(readOnly = true)
	public Page<RegistroVacuna> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public RegistroVacuna findById(String id) {
		Optional<RegistroVacuna> viajes = obtenerVirtualVet(id);
		if (viajes.isPresent()) {
			return viajes.get();
		} else {
			throw new VirtualVetNotFoundException(id);
		}
	}

	@Override
	@Transactional
	public RegistroVacuna guardarVirtualVet(RegistroVacuna virtualVet) {
		repository.save(virtualVet);
		return obtenerVirtualVet(virtualVet.getId()).get();
	}

	@Override
	@Transactional
	public RegistroVacuna actualizarVirtualVet(RegistroVacuna virtualVet) {
		Query query = new Query(Criteria.where("_id").is(virtualVet.getId()));
		Update update = new Update();
//		update.set("start", viaje.getStart());
//		update.set("end", viaje.getEnd());
//		update.set("passenger", viaje.getPassenger());
//		update.set("country", viaje.getCountry());
//		update.set("driver", viaje.getDriver());
//		update.set("city", viaje.getCity());
//		update.set("car", viaje.getCar());
//		update.set("createdAt", viaje.getCreatedAt());
//		update.set("updatedAt", viaje.getUpdatedAt());
//		update.set("status", viaje.getStatus());
//		update.set("price", viaje.getPrice());
//		update.set("driver_location", viaje.getDriver_location());
//		update.set("check_code", viaje.getCheck_code());
		UpdateResult result = mongoOperations.updateFirst(query, update, RegistroVacuna.class);
		if (result.getMatchedCount() == 0) {
			throw new VirtualVetNotFoundException(virtualVet.getId());
		}
		return obtenerVirtualVet(virtualVet.getId()).get();
	}

	private Optional<RegistroVacuna> obtenerVirtualVet(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return Optional.ofNullable(mongoOperations.findOne(query, RegistroVacuna.class));
	}

}
