package com.fiveExceptions.repository;

import com.fiveExceptions.entity.Department;
import com.fiveExceptions.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

//    @Query("select e from Employee e where e.status = ?1 and e.department = ?2")
//    List<Employee> findActiveEmployees(Boolean status, Optional<Department> depart);

    @Query("select e from Employee e where e.status = :status and e.department = :depart")
    List<Employee> findActiveEmployees(
            @Param("status") Boolean status,
            @Param("depart") Optional<Department> depart
    );


    @Modifying
    @Query("update Employee e set e.status = :status where e.firstName = :firstName")
    Employee updateEmployeeSetStatusForName(
            @Param("status") Boolean status,
            @Param("firstName") String firstName
    );

    List<Employee> findByStatusIsFalse();

//
//    @Query(
//            value = "select * from EMPLOYEE e where e.status = false",
//            nativeQuery = true
//    )
//    List<Employee> findActiveEmployeesNative(Sort first);

}
