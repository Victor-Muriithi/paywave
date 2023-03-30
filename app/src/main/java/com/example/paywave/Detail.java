package com.example.paywave;
import com.google.firebase.firestore.DocumentId;

public class Detail {
    @DocumentId
    private String id;
    private String category;
    private String entity;
    private String payBill;
    private String accountNumber;
    private String phoneNumber;


    public Detail() {}

    public Detail(String id, String category, String entity, String payBill, String accountNumber, String phoneNumber) {
        this.id = id;
        this.category = category;
        this.entity = entity;
        this.payBill = payBill;
        this.accountNumber = accountNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getPayBill() {
        return payBill;
    }

    public void setPayBill(String payBill) {
        this.payBill = payBill;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
