package com.abayllc.crud.service;

import com.abayllc.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);
    Employee save(Employee theEmployee);
    void deleteById(int id);


}
