package com.coding.exercise.bankapp.model;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="BANK_ID")
    private UUID id;
    private String branchName;
    private Integer branchCode;
    @OneToOne(cascade=CascadeType.ALL)
    private Address branchAddress;
    private Integer routingNumber;

    public BankInfo() {}

    public BankInfo(UUID id, String branchName, Integer branchCode, Address branchAddress, Integer routingNumber) {
        this.id = id; this.branchName = branchName; this.branchCode = branchCode;
        this.branchAddress = branchAddress; this.routingNumber = routingNumber;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }
    public Integer getBranchCode() { return branchCode; }
    public void setBranchCode(Integer branchCode) { this.branchCode = branchCode; }
    public Address getBranchAddress() { return branchAddress; }
    public void setBranchAddress(Address branchAddress) { this.branchAddress = branchAddress; }
    public Integer getRoutingNumber() { return routingNumber; }
    public void setRoutingNumber(Integer routingNumber) { this.routingNumber = routingNumber; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UUID id; private String branchName; private Integer branchCode;
        private Address branchAddress; private Integer routingNumber;
        public Builder id(UUID id) { this.id = id; return this; }
        public Builder branchName(String branchName) { this.branchName = branchName; return this; }
        public Builder branchCode(Integer branchCode) { this.branchCode = branchCode; return this; }
        public Builder branchAddress(Address branchAddress) { this.branchAddress = branchAddress; return this; }
        public Builder routingNumber(Integer routingNumber) { this.routingNumber = routingNumber; return this; }
        public BankInfo build() { return new BankInfo(id, branchName, branchCode, branchAddress, routingNumber); }
    }
}
