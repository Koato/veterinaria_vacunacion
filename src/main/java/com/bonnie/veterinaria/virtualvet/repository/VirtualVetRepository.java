package com.bonnie.veterinaria.virtualvet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.bonnie.veterinaria.virtualvet.dao.VirtualVet;

@Repository
public interface VirtualVetRepository extends MongoRepository<VirtualVet, String> {

}
