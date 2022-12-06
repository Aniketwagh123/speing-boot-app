package com.example.springProject.model.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer> {
    public Users findByuserName(String userName);
    public Users findBydeviceId(String deviceId);
}
