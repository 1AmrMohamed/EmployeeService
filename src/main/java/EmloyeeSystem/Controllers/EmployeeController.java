package EmloyeeSystem.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EmloyeeSystem.Services.DepartmentService;
import EmloyeeSystem.Services.EmployeeServices;
import EmloyeeSystem.models.EmployeeEntity;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeServices employeeService;
    private final DepartmentService departmentService;

    @Autowired
    public EmployeeController(EmployeeServices employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/allemployees")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/newemployee")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("updateemployee/{id}")
    public EmployeeEntity updateEmployee(@PathVariable long id, @RequestBody EmployeeEntity employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("deleteemployee/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{employeeId}/department/{departmentId}")
    public void assignDepartmentToEmployee(@PathVariable long employeeId, @PathVariable long departmentId) {
        employeeService.assignDepartmentToEmployee(employeeId, departmentId);
    }

    @DeleteMapping("/{employeeId}/department")
    public void removeDepartmentFromEmployee(@PathVariable long employeeId) {
        employeeService.removeDepartmentFromEmployee(employeeId);
    }
}


