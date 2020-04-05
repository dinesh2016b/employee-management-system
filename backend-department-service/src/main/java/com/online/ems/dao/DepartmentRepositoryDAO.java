package com.online.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.ems.model.Departments;

@Repository
public interface DepartmentRepositoryDAO extends JpaRepository<Departments, String> {

}