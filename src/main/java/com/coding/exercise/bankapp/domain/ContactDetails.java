package com.coding.exercise.bankapp.domain;

public class ContactDetails {

    private String emailId;
    private String homePhone;
    private String workPhone;

    public ContactDetails() {}

    public ContactDetails(String emailId, String homePhone, String workPhone) {
        this.emailId = emailId; this.homePhone = homePhone; this.workPhone = workPhone;
    }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }
    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }
    public String getWorkPhone() { return workPhone; }
    public void setWorkPhone(String workPhone) { this.workPhone = workPhone; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String emailId; private String homePhone; private String workPhone;
        public Builder emailId(String emailId) { this.emailId = emailId; return this; }
        public Builder homePhone(String homePhone) { this.homePhone = homePhone; return this; }
        public Builder workPhone(String workPhone) { this.workPhone = workPhone; return this; }
        public ContactDetails build() { return new ContactDetails(emailId, homePhone, workPhone); }
    }
}
