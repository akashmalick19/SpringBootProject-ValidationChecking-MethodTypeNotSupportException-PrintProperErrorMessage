package com.example.demoSpringBootValidationCheck.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    @NotEmpty(message = "Employee First name should not be Null or Empty.")
    @Size(min = 2,message = "Employee First name minimum has at least two characters.")
    private String empFirstName;
    @NotEmpty(message = "Employee Last name should not be Null or Empty.")
    @Size(min = 2,message = "Employee Last name minimum has at least two characters.")
    private String empLastName;
    @NotEmpty(message = "Email should not be NUll or Empty.")
    //** if mo message provide then by default message is provide by the spring boot
    @Email(message = "Provide Proper Email Format.")
    private String empEmailId;

    public EmployeeEntity(String empFirstName, String empLastName, String empEmailId) {
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empEmailId = empEmailId;
    }
}
