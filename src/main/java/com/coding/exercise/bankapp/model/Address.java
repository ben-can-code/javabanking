package com.coding.exercise.bankapp.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ADDR_ID")
    private UUID id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address() {}

    public Address(UUID id, String address1, String address2, String city, String state, String zip, String country) {
        this.id = id; this.address1 = address1; this.address2 = address2; this.city = city;
        this.state = state; this.zip = zip; this.country = country;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getAddress1() { return address1; }
    public void setAddress1(String address1) { this.address1 = address1; }
    public String getAddress2() { return address2; }
    public void setAddress2(String address2) { this.address2 = address2; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UUID id; private String address1; private String address2; private String city;
        private String state; private String zip; private String country;
        public Builder id(UUID id) { this.id = id; return this; }
        public Builder address1(String address1) { this.address1 = address1; return this; }
        public Builder address2(String address2) { this.address2 = address2; return this; }
        public Builder city(String city) { this.city = city; return this; }
        public Builder state(String state) { this.state = state; return this; }
        public Builder zip(String zip) { this.zip = zip; return this; }
        public Builder country(String country) { this.country = country; return this; }
        public Address build() { return new Address(id, address1, address2, city, state, zip, country); }
    }
}
