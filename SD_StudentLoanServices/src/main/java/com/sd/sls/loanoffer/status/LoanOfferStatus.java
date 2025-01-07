package com.sd.sls.loanoffer.status;

/*
 * @Author: Nikunj Panchal
 */

public enum LoanOfferStatus {
    GENERATED("GEN"),
    ACCEPTED("ACC"),
    REJECTED("REJ"),
    DISBURSED("DIS");

    private final String loanOfferStatus;

    LoanOfferStatus(String loanOfferStatus) {
        this.loanOfferStatus = loanOfferStatus;
    }

    public String getStatus() {
        return loanOfferStatus;
    }
}
