package codegym.casestudy.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDivision;
    private String nameDivision;
    @OneToMany(mappedBy = "division")
    @JsonManagedReference
    private Set<Employee> employees;

    public Division() {
    }

    public Division(int idDivision, String nameDivision, Set<Employee> employees) {
        this.idDivision = idDivision;
        this.nameDivision = nameDivision;
        this.employees = employees;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public String getNameDivision() {
        return nameDivision;
    }

    public void setNameDivision(String nameDivision) {
        this.nameDivision = nameDivision;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
