package codegym.casestudy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

public class Employee {
    @Id
    @GeneratedValue
    private int idEmployee;
    private String nameEmployee;
    private String dateEmployee;
    private String idCard;
    private Double salary;
    private String phoneNumber;
    private String emailEmployee;
    private String addressEmployee;
    @ManyToOne
    @JoinColumn(name = "id_position",referencedColumnName = "idPosition")
    @JsonBackReference
    private Position position;
    @ManyToOne
    @JoinColumn(name = "id_division",referencedColumnName = "idDivision")
    @JsonBackReference
    private Division division;


}
