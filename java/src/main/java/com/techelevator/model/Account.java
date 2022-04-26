package com.techelevator.model;

public class Account {
    private Long applicantId;
    private String username;
    private String password_hash;
    private String fullname;
    private String email;
    private Long phoneNumber;

    public Account(){

    }
    public Account(long id, String username, String password_hash, String fullname, String email, Long phoneNumber){
        this.applicantId = id;
        this.username = username;
        this.password_hash = password_hash;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Account(String username, String password_hash, String fullname, String email, Long phoneNumber){
        this.username = username;
        this.password_hash = password_hash;
        this.fullname = fullname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Long getId() {
        return applicantId;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public String getUsername() {
        return username;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setId(Long id) {
        this.applicantId = id;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
