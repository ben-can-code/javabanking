package com.coding.exercise.bankapp.domain;

import java.util.Date;

public class AccountInformation {

    private Long accountNumber;
    private BankInformation bankInformation;
    private String accountStatus;
    private String accountType;
    private Double accountBalance;
    private Date accountCreated;

    public AccountInformation() {}

    public AccountInformation(Long accountNumber, BankInformation bankInformation, String accountStatus,
                              String accountType, Double accountBalance, Date accountCreated) {
        this.accountNumber = accountNumber; this.bankInformation = bankInformation;
        this.accountStatus = accountStatus; this.accountType = accountType;
        this.accountBalance = accountBalance; this.accountCreated = accountCreated;
    }

    public Long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }
    public BankInformation getBankInformation() { return bankInformation; }
    public void setBankInformation(BankInformation bankInformation) { this.bankInformation = bankInformation; }
    public String getAccountStatus() { return accountStatus; }
    public void setAccountStatus(String accountStatus) { this.accountStatus = accountStatus; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    public Double getAccountBalance() { return accountBalance; }
    public void setAccountBalance(Double accountBalance) { this.accountBalance = accountBalance; }
    public Date getAccountCreated() { return accountCreated; }
    public void setAccountCreated(Date accountCreated) { this.accountCreated = accountCreated; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long accountNumber; private BankInformation bankInformation; private String accountStatus;
        private String accountType; private Double accountBalance; private Date accountCreated;
        public Builder accountNumber(Long accountNumber) { this.accountNumber = accountNumber; return this; }
        public Builder bankInformation(BankInformation bankInformation) { this.bankInformation = bankInformation; return this; }
        public Builder accountStatus(String accountStatus) { this.accountStatus = accountStatus; return this; }
        public Builder accountType(String accountType) { this.accountType = accountType; return this; }
        public Builder accountBalance(Double accountBalance) { this.accountBalance = accountBalance; return this; }
        public Builder accountCreated(Date accountCreated) { this.accountCreated = accountCreated; return this; }
        public AccountInformation build() {
            return new AccountInformation(accountNumber, bankInformation, accountStatus, accountType, accountBalance, accountCreated);
        }
    }
}
