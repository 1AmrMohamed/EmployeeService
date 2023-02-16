package EmloyeeSystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
 
    @ManyToOne
    @JoinColumn(name = "department_id")
    private departmentEntity department;

    public EmployeeEntity() {}

    public EmployeeEntity(String name, departmentEntity department) {
        this.name = name;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public departmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(departmentEntity department) {
        this.department = department;
    }
}
