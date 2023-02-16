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
import EmloyeeSystem.models.departmentEntity;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/alldeparts")
    public List<departmentEntity> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("department/{id}")
    public departmentEntity getDepartmentById(@PathVariable long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/newdepartment")
    public departmentEntity addDepartment(@RequestBody departmentEntity department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping("updatedepart/{id}")
    public departmentEntity updateDepartment(@PathVariable long id, @RequestBody departmentEntity department) {
        department.setId(id);
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("deletedepart/{id}")
    public void deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
    }
}



