package id.dicka.testcrud.controller;

import id.dicka.testcrud.model.Employee;
import id.dicka.testcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/list-employee")
    public ResponseEntity<List<Employee>> listEmployee(){
        List<Employee> employeesList = employeeService.getEmployees();
        return new ResponseEntity<>(employeesList, HttpStatus.OK);
    }

    @PostMapping(value = "/save/{id}")
    public ResponseEntity<Employee> save(@RequestBody Employee employee,
                                                 @PathVariable("id") int id){
        Employee resultEmployee = employeeService.handleSaveEmployees(id, employee);
        return new ResponseEntity<>(resultEmployee, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id")int id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }
}
