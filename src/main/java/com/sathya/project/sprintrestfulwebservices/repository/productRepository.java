package com.sathya.project.sprintrestfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.project.sprintrestfulwebservices.model.Product;

@Repository
public interface productRepository extends JpaRepository<Product,Integer>{

}
