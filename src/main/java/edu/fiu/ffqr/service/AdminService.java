package edu.fiu.ffqr.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.fiu.ffqr.models.Admin;
import edu.fiu.ffqr.repositories.AdminRepository;

@Service
@Component
public class AdminService extends UserService<Admin, AdminRepository> {

	@Autowired
	public AdminService(AdminRepository repository) {
		this.repository = repository;
	}

	public List<Admin> getAll()	{
		return repository.findAll();
	}
	
	public Admin getUserByUsername(String username) {
		return repository.findByUsername(username);
	}
	
	public Admin getUserByUserId(String userId) {
		return repository.getByUserId(userId);
	}
	
	public void delete(String userName) {
		Admin fi = repository.findByUsername(userName);
		repository.delete(fi);
	}

	public Admin getAdminBy_id(ObjectId _id) {
		return repository.getUserBy_id(_id);
	}

	public void deleteById(String userId) {
		Admin fi = repository.getByUserId(userId);
		repository.delete(fi);
	}
	/*public List<User> getAllAdmins(boolean admin)	{
		return usersRepository.getAdmins(admin);
	}*/
	
}
