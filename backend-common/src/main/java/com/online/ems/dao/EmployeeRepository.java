/**
 * 
 */
package com.online.ems.dao;

import com.online.ems.model.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author dinesh
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {

	Page<Employees> findAll(Pageable pageable);

	Optional<Employees> findByEmpNo(Long empNo);

	Page<Employees> findByFirstName(String firstName, Pageable pageable);

	Slice<Employees> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

}
