package com.bonnie.veterinaria.virtualvet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.bonnie.veterinaria.virtualvet.dao.RegistroVacuna;

@Repository
public interface VirtualVetRepository extends MongoRepository<RegistroVacuna, String> {

}
