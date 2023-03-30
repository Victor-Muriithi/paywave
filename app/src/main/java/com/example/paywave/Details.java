package com.example.paywave;
import com.google.firebase.firestore.DocumentId;

public class Details {
    @DocumentId
    private String id;
    private String category;
    private String entity;
    private String payBill;
    private String accountNumber;
    private String phoneNumber;


    public Details() {}

    public Details(String id, String category, String entity, String payBill, String accountNumber, String phoneNumber) {
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
=======

public class Details {

    public String entity;
    public String transactionDetail1;
    public String transactionDetail2;
    public boolean isVisible;

    public Details(String entity, String transactionDetail1, String transactionDetail2, boolean isVisible) {
        this.entity = entity;
        this.transactionDetail1 = transactionDetail1;
        this.transactionDetail2 = transactionDetail2;
        this.isVisible = isVisible;
    }


//    private String callerDisplayName;
//    private String handleSchemeSpecificPart;
//
//    public Details(String callerDisplayName, String handleSchemeSpecificPart) {
//        this.callerDisplayName = callerDisplayName;
//        this.handleSchemeSpecificPart = handleSchemeSpecificPart;
//    }
//
//    public String getCallerDisplayName() {
//        return callerDisplayName;
//    }
//
//    public String getHandleSchemeSpecificPart() {
//        return handleSchemeSpecificPart;
//    }
//
//    public void setCallerDisplayName(String callerDisplayName) {
//        this.callerDisplayName = callerDisplayName;
//    }
//
//    public void setHandleSchemeSpecificPart(String handleSchemeSpecificPart) {
//        this.handleSchemeSpecificPart = handleSchemeSpecificPart;
//    }
}

