package edu.fiu.ffqr.service;

import edu.fiu.ffqr.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public abstract class UserService<U extends User, A extends MongoRepository<U, String>> {
    protected A repository;

    protected String encodePassword(String userpassword) {
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.encode(userpassword);
    }

    public U create(U user) {
        String encodedPassword = encodePassword(user.getUserpassword());
        user.setUserpassword(encodedPassword);
        return this.repository.save(user);
    }
}
