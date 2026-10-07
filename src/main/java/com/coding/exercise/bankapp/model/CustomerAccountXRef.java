package com.coding.exercise.bankapp.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAccountXRef {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CUST_ACC_XREF_ID")
    private UUID id;
    private Long accountNumber;
    private Long customerNumber;

    public CustomerAccountXRef() {}

    public CustomerAccountXRef(UUID id, Long accountNumber, Long customerNumber) {
        this.id = id; this.accountNumber = accountNumber; this.customerNumber = customerNumber;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }
    public Long getCustomerNumber() { return customerNumber; }
    public void setCustomerNumber(Long customerNumber) { this.customerNumber = customerNumber; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UUID id; private Long accountNumber; private Long customerNumber;
        public Builder id(UUID id) { this.id = id; return this; }
        public Builder accountNumber(Long accountNumber) { this.accountNumber = accountNumber; return this; }
        public Builder customerNumber(Long customerNumber) { this.customerNumber = customerNumber; return this; }
        public CustomerAccountXRef build() { return new CustomerAccountXRef(id, accountNumber, customerNumber); }
    }
}
