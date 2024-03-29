package com.online.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.ems.model.Employees;

@Repository
public interface EmployeeRepositoryDAO extends JpaRepository<Employees, Long> {

}