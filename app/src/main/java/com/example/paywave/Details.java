package com.example.paywave;

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

