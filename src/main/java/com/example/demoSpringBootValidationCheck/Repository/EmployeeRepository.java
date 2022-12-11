package com.example.demoSpringBootValidationCheck.Repository;

import com.example.demoSpringBootValidationCheck.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
