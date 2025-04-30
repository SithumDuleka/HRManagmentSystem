package edu.icet.service.impl;

import edu.icet.dto.Employee;
import edu.icet.entity.EmployeeEntity;
import edu.icet.repository.EmployeeRepository;
import edu.icet.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    final EmployeeRepository repository;
    final ModelMapper modelMapper;
    @Override
    public void addEmployee(Employee employee) {
        if(repository.existsByEmail(employee.getEmail())){
            throw  new RuntimeException("Email is already Exists");
        }
        repository.save(modelMapper.map(employee, EmployeeEntity.class));
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList=new ArrayList<>();
        List<EmployeeEntity> all = repository.findAll();
        all.forEach(employeeEntity -> {
            employeeList.add(modelMapper.map(employeeEntity,Employee.class));
        });
        return employeeList;
    }

    @Override
    public List<Employee> searchByName(String name) {
        try {
            List<EmployeeEntity> result = repository.searchByName(name);
            List<Employee> employeeList = new ArrayList<>();
            if (!result.isEmpty()) {
               result.forEach( employeeEntity -> {
                   employeeList.add(modelMapper.map(employeeEntity,Employee.class));
               });
               return employeeList;
            } else {
                throw new RuntimeException("Employee not found with name: " + name);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error searching employee by name: " + e.getMessage());
        }
    }

    @Override
    public Employee searchByID(Integer id) {
        try {
            EmployeeEntity result = repository.searchByid(id);
            if (result !=null) {
                return modelMapper.map(result, Employee.class);
            } else {
                throw new RuntimeException("Employee not found with ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error searching employee by ID: " + e.getMessage());
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            if (!repository.existsById(employee.getId())) {
                throw new RuntimeException("Employee not found for update");
            }
            EmployeeEntity entity = modelMapper.map(employee, EmployeeEntity.class);
            repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        try {
            if (!repository.existsById(id)) {
                throw new RuntimeException("Employee not found for deletion");
            }

            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting employee: " + e.getMessage());
        }
    }
}
