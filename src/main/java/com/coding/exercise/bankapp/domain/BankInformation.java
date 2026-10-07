package com.coding.exercise.bankapp.domain;

public class BankInformation {

    private String branchName;
    private Integer branchCode;
    private AddressDetails branchAddress;
    private Integer routingNumber;

    public BankInformation() {}

    public BankInformation(String branchName, Integer branchCode, AddressDetails branchAddress, Integer routingNumber) {
        this.branchName = branchName; this.branchCode = branchCode;
        this.branchAddress = branchAddress; this.routingNumber = routingNumber;
    }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }
    public Integer getBranchCode() { return branchCode; }
    public void setBranchCode(Integer branchCode) { this.branchCode = branchCode; }
    public AddressDetails getBranchAddress() { return branchAddress; }
    public void setBranchAddress(AddressDetails branchAddress) { this.branchAddress = branchAddress; }
    public Integer getRoutingNumber() { return routingNumber; }
    public void setRoutingNumber(Integer routingNumber) { this.routingNumber = routingNumber; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String branchName; private Integer branchCode;
        private AddressDetails branchAddress; private Integer routingNumber;
        public Builder branchName(String branchName) { this.branchName = branchName; return this; }
        public Builder branchCode(Integer branchCode) { this.branchCode = branchCode; return this; }
        public Builder branchAddress(AddressDetails branchAddress) { this.branchAddress = branchAddress; return this; }
        public Builder routingNumber(Integer routingNumber) { this.routingNumber = routingNumber; return this; }
        public BankInformation build() { return new BankInformation(branchName, branchCode, branchAddress, routingNumber); }
    }
}
