package edu.icet.controller;

import edu.icet.dto.Employee;
import edu.icet.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    final EmployeeService employeeService;

    @PostMapping("/add")
    public void addEmployee(@Valid @RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }
    @GetMapping("/get-all")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable Integer id) {
        return employeeService.searchByID(id);
    }

    @GetMapping("/get-by-name/{name}")
    public List<Employee> getByName(@PathVariable String name) {
        return employeeService.searchByName(name);
    }

    @PutMapping("/update")
    public void updateEmployee(@Valid @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
    }


}
