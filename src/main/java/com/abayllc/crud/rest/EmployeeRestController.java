package com.abayllc.crud.rest;

import com.abayllc.crud.dao.EmployeDAO;
import com.abayllc.crud.dao.EmployeeDAOImpl;
import com.abayllc.crud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeDAO employeeDAO;

    public EmployeeRestController(EmployeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }


}
