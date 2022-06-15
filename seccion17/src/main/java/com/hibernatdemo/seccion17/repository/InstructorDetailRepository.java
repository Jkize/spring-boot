package com.hibernatdemo.seccion17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernatdemo.seccion17.entity.InstructorDetailEntity; 

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetailEntity, Integer> {
    
}
