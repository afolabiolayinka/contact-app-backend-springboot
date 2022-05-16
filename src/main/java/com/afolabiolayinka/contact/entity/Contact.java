package com.afolabiolayinka.contact.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "first_name", length = 32, nullable = false)
    @NotNull
    @Size(max = 32)
    private String firstName;

    @Column(name = "middle_name", length = 32, nullable = true)
    @NotNull
    @Size(max = 32)
    private String middleName;

    @Column(name = "last_name", length = 32, nullable = false)
    @NotNull
    @Size(max = 32)
    private String lastName;

    @Column(name = "email", length = 128, nullable = false)
    @NotNull
    @Size(max = 128)
    private String email;

    @Column(name = "mobile_number", length = 15, nullable = false)
    @NotNull
    @Size(max = 15)
    private String mobileNumber;

    public Contact() {
    }

    public Contact(Long id, String lastName, String firstName, String middleName, String email, String mobileNumber) {

        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Contact))
            return false;
        Contact contact = (Contact) o;
        return Objects.equals(this.id, contact.id) && Objects.equals(this.firstName, contact.firstName)
                && Objects.equals(this.lastName, contact.lastName)
                && Objects.equals(this.mobileNumber, contact.mobileNumber)
                && Objects.equals(this.email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName, this.mobileNumber, this.email);
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + this.id + "," + "firstName=" + this.firstName + "," + "lastName="
                + this.lastName + ", mobileNumber='" + this.mobileNumber + '\''
                + ", email='"
                + this.email + '\'' + '}';
    }
}