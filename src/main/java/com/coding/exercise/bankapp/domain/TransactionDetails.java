package com.coding.exercise.bankapp.domain;

import java.util.Date;

public class TransactionDetails {

    private Long accountNumber;
    private Date txDateTime;
    private String txType;
    private Double txAmount;

    public TransactionDetails() {}

    public TransactionDetails(Long accountNumber, Date txDateTime, String txType, Double txAmount) {
        this.accountNumber = accountNumber; this.txDateTime = txDateTime;
        this.txType = txType; this.txAmount = txAmount;
    }

    public Long getAccountNumber() { return accountNumber; }
    public void setAccountNumber(Long accountNumber) { this.accountNumber = accountNumber; }
    public Date getTxDateTime() { return txDateTime; }
    public void setTxDateTime(Date txDateTime) { this.txDateTime = txDateTime; }
    public String getTxType() { return txType; }
    public void setTxType(String txType) { this.txType = txType; }
    public Double getTxAmount() { return txAmount; }
    public void setTxAmount(Double txAmount) { this.txAmount = txAmount; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long accountNumber; private Date txDateTime; private String txType; private Double txAmount;
        public Builder accountNumber(Long accountNumber) { this.accountNumber = accountNumber; return this; }
        public Builder txDateTime(Date txDateTime) { this.txDateTime = txDateTime; return this; }
        public Builder txType(String txType) { this.txType = txType; return this; }
        public Builder txAmount(Double txAmount) { this.txAmount = txAmount; return this; }
        public TransactionDetails build() { return new TransactionDetails(accountNumber, txDateTime, txType, txAmount); }
    }
}
