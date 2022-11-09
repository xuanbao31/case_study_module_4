package com.example.demo.model.customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class CustomerDto implements Validator {

    private Integer id;
    @NotBlank(message = "Không được để trống nha")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Viết hoa ở mỗi chữ cái đầu")
    private String name;

    @NotBlank(message = "Không được để trống nha")
    private String dateOfBirth;

    @NotBlank(message = "Không được để trống nha")
    private Integer gender;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$",
            message = "Nhập Lại Đi Bạn")
    private String idCard;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "/((09|03|07|08|05)+([0-9]{8})\\b)/g")
    private String phoneNumber;
    private String email;
    private String address;

    private Integer status;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String dateOfBirth, Integer gender, String idCard, String phoneNumber, String email, String address, Integer status, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.customerType = customerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
