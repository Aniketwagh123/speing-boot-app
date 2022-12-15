package com.example.springProject.model.HomeAtomation;

import com.example.springProject.model.users.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeAtomationRepository extends CrudRepository<HomeAtomation,Integer> {

}
