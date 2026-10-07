package com.coding.exercise.bankapp.domain;

public class TransferDetails {

    private Long fromAccountNumber;
    private Long toAccountNumber;
    private Double transferAmount;

    public TransferDetails() {}

    public TransferDetails(Long fromAccountNumber, Long toAccountNumber, Double transferAmount) {
        this.fromAccountNumber = fromAccountNumber; this.toAccountNumber = toAccountNumber;
        this.transferAmount = transferAmount;
    }

    public Long getFromAccountNumber() { return fromAccountNumber; }
    public void setFromAccountNumber(Long fromAccountNumber) { this.fromAccountNumber = fromAccountNumber; }
    public Long getToAccountNumber() { return toAccountNumber; }
    public void setToAccountNumber(Long toAccountNumber) { this.toAccountNumber = toAccountNumber; }
    public Double getTransferAmount() { return transferAmount; }
    public void setTransferAmount(Double transferAmount) { this.transferAmount = transferAmount; }
}
