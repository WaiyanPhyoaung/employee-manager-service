package com.wypa.employee_manager.service;

import com.wypa.employee_manager.model.Employee;
import com.wypa.employee_manager.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }
    public Employee getEmployeeById(long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("No such employee"));
    }

    public Employee saveEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repo.save(employee);

    }
    public Employee updateEmployee(Employee employee){
        return repo.save(employee);
    }
    public void deleteEmployee(long id){
        var e1 = getEmployeeById(id);
        repo.delete(e1);
    }
}
