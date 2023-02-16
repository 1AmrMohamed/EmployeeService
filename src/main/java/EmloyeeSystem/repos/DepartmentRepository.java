package EmloyeeSystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EmloyeeSystem.models.departmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository <departmentEntity, Long> {
}


