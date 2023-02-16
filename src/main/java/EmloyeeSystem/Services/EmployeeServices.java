package EmloyeeSystem.Services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import EmloyeeSystem.Services.DepartmentService;

import EmloyeeSystem.models.EmployeeEntity;
import EmloyeeSystem.models.departmentEntity;
import EmloyeeSystem.repos.EmployeeRepository;
 
@Service
public class EmployeeServices {
	@Autowired
	DepartmentService departmentService;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public void assignDepartmentToEmployee(long employeeId, long departmentId) {
        EmployeeEntity employee = getEmployeeById(employeeId);
        departmentEntity department = departmentService.getDepartmentById(departmentId);
        employee.setDepartment(department);
        updateEmployee(employee);
    }

    public void removeDepartmentFromEmployee(long employeeId) {
        EmployeeEntity employee = getEmployeeById(employeeId);
        employee.setDepartment(null);
        updateEmployee(employee);
    }
}






