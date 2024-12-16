package com.truelanz.many_to_one.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.truelanz.many_to_one.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //Buscar todos
    @Query(value = "SELECT e FROM Employee e JOIN FETCH e.department")
    List<Employee> searchAll();
    
    ////Busca Paginada
    @Query(value = "SELECT e FROM Employee e JOIN FETCH e.department",
        countQuery = "SELECT COUNT(e) FROM Employee e JOIN e.department")
    Page<Employee> searchAllPageable(Pageable pageable);
}
