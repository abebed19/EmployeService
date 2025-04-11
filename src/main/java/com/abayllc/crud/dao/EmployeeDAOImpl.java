package com.abayllc.crud.dao;

import com.abayllc.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeDAO{
    private EntityManager entityManager;


    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("Select s from Employee  s", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findByid(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if(employee == null) {
            throw new RuntimeException("Employee with id" + id + " not found");
        }
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = entityManager.merge(theEmployee);
        return employee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);

    }
}
