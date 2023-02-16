package EmloyeeSystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EmloyeeSystem.models.EmployeeEntity;

@Repository
public interface EmployeeRepository  extends JpaRepository <EmployeeEntity, Long> {
}


