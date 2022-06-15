package com.hibernatdemo.seccion17.repository;

import org.springframework.stereotype.Repository;

import com.hibernatdemo.seccion17.entity.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>   {
    
}
