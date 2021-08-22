package com.example.week7ems.repository;

import com.example.week7ems.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends CrudRepository<Employee ,Long> {

}
