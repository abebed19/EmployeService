package com.abayllc.crud.service;

import com.abayllc.crud.dao.EmployeDAO;
import com.abayllc.crud.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeDAO employeDAO;
    public EmployeeServiceImpl(EmployeDAO employeDAO) {
        this.employeDAO = employeDAO;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeDAO.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
      return   employeDAO.findByid(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {

        return employeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeDAO.deleteById(id);
    }
}
