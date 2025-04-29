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
    public Employee searchByName(String name) {
       return null;
    }

    @Override
    public Employee searchByID(Integer id) {
        return repository.searchByID(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if(repository.existsById(employee.getId())){
            repository.save(modelMapper.map(employee,EmployeeEntity.class));
        }

    }

    @Override
    public void deleteEmployee(Integer id) {
        repository.deleteById(id);
    }
}
