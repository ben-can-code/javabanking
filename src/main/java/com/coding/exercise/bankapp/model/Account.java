package com.coding.exercise.bankapp.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ACCT_ID")
    private UUID id;
    private Long accountNumber;
    @OneToOne(cascade=CascadeType.ALL)
    private BankInfo bankInformation;
    private String accountStatus;
    private String accountType;
    private Double accountBalance;
    @Temporal(TemporalType.TIME)
    private Date createDateTime;
    @Temporal(TemporalType.TIME)
    private Date updateDateTime;

    public Account() {}

    public Account(UUID id, Long accountNumber, BankInfo bankInformation, String accountStatus,
                   String accountType, Double accountBalance, Date createDateTime, Date updateDateTime) {
        this.id = id; this.accountNumber = accountNumber; this.bankInformation = bankInformation;
        this.accountStatus = accountStatus; this.accountType = accountType;
        this.accountBalance = accountBalance; this.createDateTime = createDateTime; this.updateDateTime = updateDateTime;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }
    public BankInfo getBankInformation() { return bankInformation; }
    public void setBankInformation(BankInfo bankInformation) { this.bankInformation = bankInformation; }
    public String getAccountStatus() { return accountStatus; }
    public void setAccountStatus(String accountStatus) { this.accountStatus = accountStatus; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public Double getAccountBalance() { return accountBalance; }
    public void setAccountBalance(Double accountBalance) { this.accountBalance = accountBalance; }
    public Date getCreateDateTime() { return createDateTime; }
    public void setCreateDateTime(Date createDateTime) { this.createDateTime = createDateTime; }
    public Date getUpdateDateTime() { return updateDateTime; }
    public void setUpdateDateTime(Date updateDateTime) { this.updateDateTime = updateDateTime; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UUID id; private Long accountNumber; private BankInfo bankInformation;
        private String accountStatus; private String accountType; private Double accountBalance;
        private Date createDateTime; private Date updateDateTime;
        public Builder id(UUID id) { this.id = id; return this; }
        public Builder accountNumber(Long accountNumber) { this.accountNumber = accountNumber; return this; }
        public Builder bankInformation(BankInfo bankInformation) { this.bankInformation = bankInformation; return this; }
        public Builder accountStatus(String accountStatus) { this.accountStatus = accountStatus; return this; }
        public Builder accountType(String accountType) { this.accountType = accountType; return this; }
        public Builder accountBalance(Double accountBalance) { this.accountBalance = accountBalance; return this; }
        public Builder createDateTime(Date createDateTime) { this.createDateTime = createDateTime; return this; }
        public Builder updateDateTime(Date updateDateTime) { this.updateDateTime = updateDateTime; return this; }
        public Account build() {
            return new Account(id, accountNumber, bankInformation, accountStatus, accountType,
                    accountBalance, createDateTime, updateDateTime);
        }
    }
}
