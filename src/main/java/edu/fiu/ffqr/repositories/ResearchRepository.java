package edu.fiu.ffqr.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.fiu.ffqr.models.Admin;
import edu.fiu.ffqr.models.Researcher;

@Repository
public interface ResearchRepository extends MongoRepository<Researcher, String> {

  Researcher getUserBy_id(ObjectId _id);

  Researcher getByUserId(String userId);
	
  Researcher findByUsername(String username);
  
    
}