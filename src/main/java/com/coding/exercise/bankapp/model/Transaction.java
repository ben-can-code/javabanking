package com.coding.exercise.bankapp.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="TX_ID")
    private UUID id;
    private Long accountNumber;
    @Temporal(TemporalType.TIME)
    private Date txDateTime;
    private String txType;
    private Double txAmount;

    public Transaction() {}

    public Transaction(UUID id, Long accountNumber, Date txDateTime, String txType, Double txAmount) {
        this.id = id; this.accountNumber = accountNumber; this.txDateTime = txDateTime;
        this.txType = txType; this.txAmount = txAmount;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
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
        private UUID id; private Long accountNumber; private Date txDateTime;
        private String txType; private Double txAmount;
        public Builder id(UUID id) { this.id = id; return this; }
        public Builder accountNumber(Long accountNumber) { this.accountNumber = accountNumber; return this; }
        public Builder txDateTime(Date txDateTime) { this.txDateTime = txDateTime; return this; }
        public Builder txType(String txType) { this.txType = txType; return this; }
        public Builder txAmount(Double txAmount) { this.txAmount = txAmount; return this; }
        public Transaction build() { return new Transaction(id, accountNumber, txDateTime, txType, txAmount); }
    }
}
