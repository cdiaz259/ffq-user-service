package edu.fiu.ffqr.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.fiu.ffqr.models.Clinician;
import edu.fiu.ffqr.repositories.ClinicianRepository;

@Service
@Component
public class ClinicianService  extends UserService<Clinician, ClinicianRepository> {

	@Autowired
	public ClinicianService(ClinicianRepository repository) {
		this.repository = repository;
	}

	public List<Clinician> getAll()	{
		return repository.findAll();
	}
	
	public Clinician getClinicianByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public Clinician getClinicianBy_id(ObjectId _id) {
		return repository.getUserBy_id(_id);
	}

	public Clinician getClinicianByUserId(String userId) {
		return repository.getByUserId(userId);
	}

	public Clinician getClinicianByAbbreviation(String abbreviation) {
		return repository.getByAbbreviation(abbreviation);
	}
	
	public void delete(String username) {
		Clinician fi = repository.getByUserId(username);
		repository.delete(fi);
	}

	public void deleteById(String userId) {
		Clinician fi = repository.getByUserId(userId);
		repository.delete(fi);
	}
	
}
