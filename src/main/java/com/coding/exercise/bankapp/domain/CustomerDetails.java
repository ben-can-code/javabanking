package com.coding.exercise.bankapp.domain;

public class CustomerDetails {

    private String firstName;
    private String lastName;
    private String middleName;
    private Long customerNumber;
    private String status;
    private AddressDetails customerAddress;
    private ContactDetails contactDetails;

    public CustomerDetails() {}

    public CustomerDetails(String firstName, String lastName, String middleName, Long customerNumber,
                           String status, AddressDetails customerAddress, ContactDetails contactDetails) {
        this.firstName = firstName; this.lastName = lastName; this.middleName = middleName;
        this.customerNumber = customerNumber; this.status = status;
        this.customerAddress = customerAddress; this.contactDetails = contactDetails;
    }

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
    public AddressDetails getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(AddressDetails customerAddress) { this.customerAddress = customerAddress; }
    public ContactDetails getContactDetails() { return contactDetails; }
    public void setContactDetails(ContactDetails contactDetails) { this.contactDetails = contactDetails; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String firstName; private String lastName; private String middleName;
        private Long customerNumber; private String status;
        private AddressDetails customerAddress; private ContactDetails contactDetails;
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder middleName(String middleName) { this.middleName = middleName; return this; }
        public Builder customerNumber(Long customerNumber) { this.customerNumber = customerNumber; return this; }
        public Builder status(String status) { this.status = status; return this; }
        public Builder customerAddress(AddressDetails customerAddress) { this.customerAddress = customerAddress; return this; }
        public Builder contactDetails(ContactDetails contactDetails) { this.contactDetails = contactDetails; return this; }
        public CustomerDetails build() {
            return new CustomerDetails(firstName, lastName, middleName, customerNumber, status, customerAddress, contactDetails);
        }
    }
}
