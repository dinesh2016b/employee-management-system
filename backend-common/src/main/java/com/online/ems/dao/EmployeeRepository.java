/**
 * 
 */
package com.online.ems.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.online.ems.model.Employees;

/**
 * @author dinesh
 *
 */

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employees, Long> {

	Page<Employees> findAll(Pageable pageable);

	Page<Employees> findByFirstName(String firstName, Pageable pageable);

	Slice<Employees> findByFirstNameAndLastName(String firstName, String lastName, Pageable pageable);

}
