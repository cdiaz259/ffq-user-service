package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="clinics")
public class Clinic implements Serializable {

	@Id
	private ObjectId _id;
	@JsonProperty("clinicId")
	private String clinicId; 
	@JsonProperty("address")
	private String address;
	@JsonProperty("datebuilt")
	private String datebuilt;
	@JsonProperty("clinicname")
	private String clinicname;
	@JsonProperty("headclinician")
	private String headclinician;
	@JsonProperty("isactive")
	private boolean isactive;
	@JsonProperty("usersLimit")
	private int usersLimit;

	public Clinic() {}
	public Clinic(String clinicId, String address, String datebuilt, String clinicname, String headclinician, boolean isactive, int usersLimit){
        this.clinicId = clinicId;
		this.address = address;
		this.datebuilt = datebuilt;
		this.clinicname = clinicname;
		this.headclinician = headclinician;
		this.isactive = isactive;
		this.usersLimit = usersLimit;
    }
	

	public ObjectId getId() {
        return this._id;
    }
	public void setId(ObjectId id) {
        this._id = id;
	}
	
	public String getClinicId() {
		return clinicId;
	}

	public void setClinicId(String clinicId) {
		this.clinicId = clinicId;
	}

	public String getAddress() {
		return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDatebuilt() {
        return this.datebuilt;
	}
	public void setDatebuilt(String datebuilt) {
        this.datebuilt = datebuilt;
	}

	public String getClinicname() {
		return this.clinicname;
	}   
    public void setClinicname(String clinicname) {
        this.clinicname = clinicname;
    }

	public String getHeadclinician() {
		return this.headclinician;
	}   
    public void setHeadclinician(String headclinician) {
        this.headclinician = headclinician;
	}
	
	public boolean getIsactive() {
		return this.isactive;
	}   
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

	public int getUsersLimit() {
		return usersLimit;
	}

	public void setUsersLimit(int usersLimit) {
		this.usersLimit = usersLimit;
	}

}
