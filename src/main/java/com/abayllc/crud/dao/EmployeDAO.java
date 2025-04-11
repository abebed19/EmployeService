package com.abayllc.crud.dao;

import com.abayllc.crud.entity.Employee;

import java.util.List;

public interface EmployeDAO {
    List<Employee> findAll();
    Employee findByid(int id);
    Employee save(Employee theEmployee);
    void deleteById(int id);
}
