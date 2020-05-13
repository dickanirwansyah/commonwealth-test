package id.dicka.testcrud.service;

import id.dicka.testcrud.model.Employee;
import id.dicka.testcrud.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()){
            employees.add(employee);
        }
        log.info("# fetching data "+employees);
        return employees;
    }

    public Employee handleSaveEmployees(int id, Employee employee){
        //save
        if (id == 0){

            Employee entityEmployee = new Employee();
            entityEmployee.setName(employee.getName());
            entityEmployee.setPhone(employee.getPhone());
            Employee result = employeeRepository.save(entityEmployee);
            log.info("# save data "+result);
            return result;

        }else{
            //update
            Optional<Employee> entityEmployee = employeeRepository.findById(id);
            if (!entityEmployee.isPresent()){
                log.info("# data id tidak ada ");
                return null;
            }else{
                entityEmployee.get().setName(employee.getName());
                entityEmployee.get().setPhone(employee.getPhone());
                Employee result = employeeRepository.save(entityEmployee.get());
                log.info("# update data");
                return result;
            }
        }
    }

    public void deleteEmployeeById(int id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()){
            log.info("# data id tidak ada");
        }else{
            employeeRepository.delete(employee.get());
            log.info("# delete data");
        }
    }
}
