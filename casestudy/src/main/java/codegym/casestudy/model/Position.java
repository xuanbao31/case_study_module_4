package codegym.casestudy.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPosition;
    private String namePosition;

    @OneToMany(mappedBy = "position")
    @JsonManagedReference
    private Set<Employee> employees;

    public Position() {
    }

    public Position(int idPosition, String namePosition, Set<Employee> employees) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
        this.employees = employees;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
