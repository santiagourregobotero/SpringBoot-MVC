package com.project.test.demo.db.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.test.demo.db.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    List<User> findAll();

    Optional<User> findById(Integer id);

    Optional<User> findByName(String name);

    <S extends User> S save(S user);

    void deleteById(Integer id);
}
