package codegym.casestudy.model;

import javax.persistence.*;

@Entity
public class Education_degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEducation;
    private String nameEducation;
//    @OneToMany(mappedBy = "education_dergee")

    public Education_degree() {
    }
}
