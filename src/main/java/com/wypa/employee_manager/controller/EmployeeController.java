package com.wypa.employee_manager.controller;

import com.wypa.employee_manager.model.Employee;
import com.wypa.employee_manager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> lists = service.getAllEmployees();
        return new ResponseEntity<>(lists, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") long id ){
        Employee e1 ;
        try{
             e1 = service.getEmployeeById(id);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(e1,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        Employee e1 = service.saveEmployee(employee);
        return new ResponseEntity<>(e1,HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id")long id,@RequestBody Employee employee){
       Employee e1 = service.updateEmployee(id ,employee);
        return new ResponseEntity<>(e1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
         service.deleteEmployee(id);
         return new ResponseEntity(HttpStatus.OK);
    }

}
