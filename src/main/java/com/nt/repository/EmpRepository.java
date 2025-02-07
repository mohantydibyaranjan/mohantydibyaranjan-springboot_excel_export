package com.nt.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Serializable> {

}
