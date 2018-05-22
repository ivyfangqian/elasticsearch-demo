package com.fqivy.thymeleaf.example.demo.repository;

import com.fqivy.thymeleaf.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

}
