package edu.icet.service;

import edu.icet.dto.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    List<Employee> getAll();
    Employee searchByName(String name);
    Employee searchByID(Integer id);
    void updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
}
