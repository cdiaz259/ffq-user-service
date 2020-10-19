package edu.fiu.ffqr.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.fiu.ffqr.FFQUserApplication;
import edu.fiu.ffqr.models.SysUser;
import edu.fiu.ffqr.repositories.ParentRepository;
import edu.fiu.ffqr.service.SysUserService;
//import edu.fiu.ffqr.service.UserService;
import edu.fiu.ffqr.models.Parent;
import edu.fiu.ffqr.service.ClinicianService;
import edu.fiu.ffqr.service.ParentService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parents")
public class ParentController{

    @Autowired
    private ParentService parentService;
    @Autowired
    private ParentRepository parentRepository;

    public ParentController() {
    }
    
    @GetMapping("/all")
    public List<Parent> allClinicians() throws JsonProcessingException {
        
        List<Parent> users = parentService.getAll();
        return users;
    }  

    @GetMapping("/{userID}")
	public Parent getParent(@PathVariable("userID") String userId) {
		return parentService.getParentByUserId(userId);
	}
    
    @PostMapping("/createparent")
    public Parent createUser(@RequestBody Parent user) throws JsonProcessingException {

      if (parentService.getParentByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("A user with Username " + user.getUsername() + " already exists");
      }  
	  return parentService.create(user);
	  
  }

  @PutMapping("/updateparent")
    public void updateUser(@RequestBody Parent user) throws JsonProcessingException {
        
        if (parentService.getParentByUserId(user.getUserId()) == null) {
            throw new IllegalArgumentException("A user with Username " + user.getUsername() + " doesn't exist");
        }

        Parent currentUser = parentService.getParentByUserId(user.getUserId());
        
        currentUser.setUsername(user.getUsername());
        currentUser.setUserpassword(user.getUserpassword());
        currentUser.setFirstname(user.getFirstname());
        currentUser.setLastname(user.getLastname());
        currentUser.setUsertype(user.getUsertype());

        currentUser.setAssignedclinic(user.getAssignedclinic());
        currentUser.setAssignedclinician(user.getAssignedclinician()); 
        currentUser.setChildrennames(user.getChildrennames());            

        parentRepository.save(currentUser);    
    }


    @PostMapping("/create")
    public Parent create(@RequestBody Parent item) throws JsonProcessingException {
        
        if (parentService.getParentByUsername(item.getUsername()) != null) {
            throw new IllegalArgumentException("A parent with Username " + item.getUsername() + " already exists");
        }

        return parentService.create(item);
    }

    
    
   
	
	@PostMapping("/createMany")
	public ArrayList<Parent> create(@RequestBody ArrayList<Parent> users) {
		Parent user = null;
		
		for(Parent s : users)
		{
			user = parentService.create(s);
		}
		
		return users;
	}
	
	  
	  
	  @DeleteMapping("/delete")
	  public String delete(@RequestParam String userId) {
        parentService.deleteById(userId);
	  	  return "Deleted " + userId;
	  }
	
}
