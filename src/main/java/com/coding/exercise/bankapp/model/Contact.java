package com.coding.exercise.bankapp.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="CONTACT_ID")
    private UUID id;
    private String emailId;
    private String homePhone;
    private String workPhone;

    public Contact() {}

    public Contact(UUID id, String emailId, String homePhone, String workPhone) {
        this.id = id; this.emailId = emailId; this.homePhone = homePhone; this.workPhone = workPhone;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }
    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }
    public String getWorkPhone() { return workPhone; }
    public void setWorkPhone(String workPhone) { this.workPhone = workPhone; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private UUID id; private String emailId; private String homePhone; private String workPhone;
        public Builder id(UUID id) { this.id = id; return this; }
        public Builder emailId(String emailId) { this.emailId = emailId; return this; }
        public Builder homePhone(String homePhone) { this.homePhone = homePhone; return this; }
        public Builder workPhone(String workPhone) { this.workPhone = workPhone; return this; }
        public Contact build() { return new Contact(id, emailId, homePhone, workPhone); }
    }
}
