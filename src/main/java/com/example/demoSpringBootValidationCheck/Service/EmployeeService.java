package com.example.demoSpringBootValidationCheck.Service;

import com.example.demoSpringBootValidationCheck.Entity.EmployeeEntity;
import com.example.demoSpringBootValidationCheck.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity saveRecord(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }


    public List<EmployeeEntity> fetchRecord() {
        return employeeRepository.findAll();
    }

//    public List<EmployeeEntity> fetchRecord() throws UserException {
//        List<EmployeeEntity> employeeEntityList=employeeRepository.findAll();
//        if(employeeEntityList.isEmpty()){
//            throw new UserException();
//        }
//        return employeeEntityList;
//    }

}
