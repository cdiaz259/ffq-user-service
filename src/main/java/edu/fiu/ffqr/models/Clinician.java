package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="clinicians")
public class Clinician extends User implements Serializable{

    @Id
    private ObjectId _id;  
	@JsonProperty("userId")
	private String userId; 
	@JsonProperty("username")
	private String username;
    @JsonProperty("usertype")
    private String usertype;
    @JsonProperty("abbreviation")
    private String abbreviation;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
	private String lastname;
    @JsonProperty("assignedclinic")
    private String assignedclinic;
    @JsonProperty("previousclinics")
    private ArrayList<String> previousclinics = new ArrayList<String>();
    @JsonProperty("isactive")
    private boolean isactive;
    


	public Clinician() {}
	
    public Clinician(String userId, String username, String abbreviation, String firstname, String lastname, String userpassword, String usertype, 
                    String assignedclinic, ArrayList<String> previousclinics, boolean isactive){
        this.userId = userId;
		this.username = username;
        this.userpassword = userpassword;
        this.usertype = usertype;
        this.firstname = firstname;
        this.lastname = lastname;
        this.assignedclinic = assignedclinic;
        this.abbreviation = abbreviation;
        this.previousclinics = previousclinics;
        this.isactive = isactive;

    }


    public ObjectId getId() {
        return this._id;
    }
	/*public void setId(ObjectId id) {
        this._id = id;
    }*/
      
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
    }

    public String getAbbreviation(){
        return this.abbreviation;
    }
    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getUsertype(){
        return this.usertype;
    }
    public void setUsertype(String usertype){
        this.usertype = usertype;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public String getAssignedclinic() {
        return this.assignedclinic;
    }
    public void setAssignedclinic(String assignedclinic) {
        this.assignedclinic = assignedclinic;     
    }

	public void setUsername(String username) {
		this.username = username;
	}

    public ArrayList<String> getPreviousclinics() {
        return this.previousclinics;
    }
    public void setPreviousclinic(ArrayList<String> previousclinics) {
        this.previousclinics = previousclinics;   
    }

    public void setIsactive(boolean isactive){
        this.isactive = isactive;
    }

    public boolean getIsactive(){
        return this.isactive;
    }





}
