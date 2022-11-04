package codegym.casestudy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCustomer;
    private String nameCustomer;
    private String dayCustomer;
    private int genderCustomer;
    private String citizenCustomer;
    private String phoneCustomer;
    private String emailCustomer;
    private String addressCustomer;
    private int isDelete;

    @ManyToOne
    @JoinColumn(name = "id_typeCustomer", referencedColumnName = "idTypeCustomer")
    @JsonBackReference
    private CustomerType typeCustomers;

    public Customer() {
    }

    public Customer(long idCustomer, String nameCustomer, String dayCustomer, int genderCustomer, String citizenCustomer, String phoneCustomer, String emailCustomer, String addressCustomer, int isDelete, CustomerType typeCustomers) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dayCustomer = dayCustomer;
        this.genderCustomer = genderCustomer;
        this.citizenCustomer = citizenCustomer;
        this.phoneCustomer = phoneCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
        this.isDelete = isDelete;
        this.typeCustomers = typeCustomers;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDayCustomer() {
        return dayCustomer;
    }

    public void setDayCustomer(String dayCustomer) {
        this.dayCustomer = dayCustomer;
    }

    public int getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(int genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getCitizenCustomer() {
        return citizenCustomer;
    }

    public void setCitizenCustomer(String citizenCustomer) {
        this.citizenCustomer = citizenCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public CustomerType getTypeCustomers() {
        return typeCustomers;
    }

    public void setTypeCustomers(CustomerType typeCustomers) {
        this.typeCustomers = typeCustomers;
    }
}
