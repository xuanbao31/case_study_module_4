package codegym.casestudy.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTypeCustomer;
    private String nameTypeCustomer;

    @OneToMany(mappedBy = "typeCustomers")
    @JsonManagedReference
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(long idTypeCustomer, String nameTypeCustomer, Set<Customer> customers) {
        this.idTypeCustomer = idTypeCustomer;
        this.nameTypeCustomer = nameTypeCustomer;
        this.customers = customers;
    }

    public long getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(long idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }

    public String getNameTypeCustomer() {
        return nameTypeCustomer;
    }

    public void setNameTypeCustomer(String nameTypeCustomer) {
        this.nameTypeCustomer = nameTypeCustomer;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
