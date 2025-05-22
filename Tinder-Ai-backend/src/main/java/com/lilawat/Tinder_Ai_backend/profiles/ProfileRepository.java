package com.lilawat.Tinder_Ai_backend.profiles;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profiles, String> {
//this interface is used to store the profiles in memory
//it extends the mongorepository interface

}
