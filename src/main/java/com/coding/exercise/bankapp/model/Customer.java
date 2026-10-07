package com.coding.exercise.bankapp.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name="CUST_ID")
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Long customerNumber;
    private String status;
    @ManyToOne(cascade=CascadeType.ALL)
    private Address customerAddress;
    @OneToOne(cascade=CascadeType.ALL)
    private Contact contactDetails;
    @Temporal(TemporalType.TIME)
    private Date createDateTime;
    @Temporal(TemporalType.TIME)
    private Date updateDateTime;

    public Customer() {}

    public Customer(UUID id, String firstName, String lastName, String middleName, Long customerNumber,
                    String status, Address customerAddress, Contact contactDetails,
                    Date createDateTime, Date updateDateTime) {
        this.id = id; this.firstName = firstName; this.lastName = lastName;
        this.middleName = middleName; this.customerNumber = customerNumber; this.status = status;
        this.customerAddress = customerAddress; this.contactDetails = contactDetails;
        this.createDateTime = createDateTime; this.updateDateTime = updateDateTime;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public Long getCustomerNumber() { return customerNumber; }
    public void setCustomerNumber(Long customerNumber) { this.customerNumber = customerNumber; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Address getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(Address customerAddress) { this.customerAddress = customerAddress; }
    public Contact getContactDetails() { return contactDetails; }
    public void setContactDetails(Contact contactDetails) { this.contactDetails = contactDetails; }
    public Date getCreateDateTime() { return createDateTime; }
    public void setCreateDateTime(Date createDateTime) { this.createDateTime = createDateTime; }
    public Date getUpdateDateTime() { return updateDateTime; }
    public void setUpdateDateTime(Date updateDateTime) { this.updateDateTime = updateDateTime; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UUID id; private String firstName; private String lastName; private String middleName;
        private Long customerNumber; private String status; private Address customerAddress;
        private Contact contactDetails; private Date createDateTime; private Date updateDateTime;
        public Builder id(UUID id) { this.id = id; return this; }
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder middleName(String middleName) { this.middleName = middleName; return this; }
        public Builder customerNumber(Long customerNumber) { this.customerNumber = customerNumber; return this; }
        public Builder status(String status) { this.status = status; return this; }
        public Builder customerAddress(Address customerAddress) { this.customerAddress = customerAddress; return this; }
        public Builder contactDetails(Contact contactDetails) { this.contactDetails = contactDetails; return this; }
        public Builder createDateTime(Date createDateTime) { this.createDateTime = createDateTime; return this; }
        public Builder updateDateTime(Date updateDateTime) { this.updateDateTime = updateDateTime; return this; }
        public Customer build() {
            return new Customer(id, firstName, lastName, middleName, customerNumber, status,
                    customerAddress, contactDetails, createDateTime, updateDateTime);
        }
    }
}
