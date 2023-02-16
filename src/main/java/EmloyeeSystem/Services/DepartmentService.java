package EmloyeeSystem.Services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EmloyeeSystem.models.departmentEntity;
import EmloyeeSystem.repos.DepartmentRepository;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public departmentEntity getDepartmentById(long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department not found"));
    }

    public List<departmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public departmentEntity addDepartment(departmentEntity department) {
        return departmentRepository.save(department);
    }

    public departmentEntity updateDepartment(departmentEntity department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }
}


