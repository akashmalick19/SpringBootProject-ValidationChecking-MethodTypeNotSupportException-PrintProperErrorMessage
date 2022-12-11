package com.example.demoSpringBootValidationCheck.Controller;

import com.example.demoSpringBootValidationCheck.Entity.EmployeeEntity;
import com.example.demoSpringBootValidationCheck.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/storeData",method = RequestMethod.POST)
    //@PostMapping(value = "/storeData")
    public ResponseEntity<EmployeeEntity> saveRecord(@Valid @RequestBody EmployeeEntity employeeEntity){
        EmployeeEntity employee=employeeService.saveRecord(employeeEntity);
        return new ResponseEntity<EmployeeEntity>(employee, HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/fetchAllData",method = RequestMethod.GET)
    public Map<String,Object> fetchRecord(){
        Map<String,Object> map=new HashMap<>();
        List<EmployeeEntity> employeeEntityList=employeeService.fetchRecord();
        try{
            if(employeeEntityList.isEmpty()){
                throw new NullPointerException();
            }
            map.put("Status ",HttpStatus.OK);
            map.put("Message ","Fetch All Records From Employee Data Base.");
            map.put("Objects ",employeeEntityList);
            return map;
        }
        catch (NullPointerException e){
            map.put("Status ",HttpStatus.NO_CONTENT);
            map.put("Message ","Employee Data Base is Empty.");
            map.put("Objects ",employeeEntityList);
            return map;
        }
    }

//    @RequestMapping(value = "/fetchAllData",method = RequestMethod.GET)
//    public ResponseEntity<Object> fetchRecord() throws UserException {
//        Map<String,Object> map=new HashMap<>();
//        List<EmployeeEntity> employeeEntityList=employeeService.fetchRecord();
//        map.put("Status ",HttpStatus.OK);
//        map.put("Message ","Fetch All Records From Employee Data Base.");
//        map.put("Objects ",employeeEntityList);
//        return new ResponseEntity<Object>(map,HttpStatus.OK);
//    }

}
