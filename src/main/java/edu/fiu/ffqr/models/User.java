package edu.fiu.ffqr.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class User {
    @JsonProperty("userpassword")
    protected String userpassword;


    public void setUserpassword(String userpassword){
        this.userpassword = userpassword;
    }

    public String getUserpassword() {
        return this.userpassword;
    }
}
