package com.abayllc.crud.rest;

import com.abayllc.crud.dao.EmployeDAO;
import com.abayllc.crud.dao.EmployeeDAOImpl;
import com.abayllc.crud.entity.Employee;
import com.abayllc.crud.service.EmployeeService;
import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }
    @PostMapping("/employees")
    public Employee addEmployee( @RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEMP = employeeService.save(theEmployee);
        return dbEMP;

    }


}
