package com.sd.sls.loanoffer.model;

/*
 * @Author: Nikunj Panchal
 */

import com.sd.sls.loanapplication.model.LoanApplication;
import com.sd.sls.loanoffer.status.LoanOfferStatus;
import com.sd.sls.bankadmin.model.BankAdmin;

import java.io.Serializable;
import java.sql.Date;

public class LoanOffer implements Serializable {
    private int OfferID;
    private Double sanctionedAmount;
    private Double interestRate;
    private String loanOfferStatus;
    private Date disbursedDate;
    private BankAdmin bankAdmin;
    private LoanApplication loanApplication;

    public LoanOffer(int offerID, Double sanctionedAmount, Double interestRate, String loanOfferStatus,
                     Date disbursedDate, BankAdmin bankAdmin, LoanApplication loanApplication) {
        super();
        this.OfferID = offerID;
        this.sanctionedAmount = sanctionedAmount;
        this.interestRate = interestRate;
        this.loanOfferStatus = loanOfferStatus;
        this.disbursedDate = disbursedDate;
        this.bankAdmin = bankAdmin;
        this.loanApplication = loanApplication;
    }

    public LoanOffer() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "LoanOffer{" +
                "OfferID=" + OfferID +
                ", sanctionedAmount=" + sanctionedAmount +
                ", interestRate=" + interestRate +
                ", loanOfferStatus=" + loanOfferStatus +
                ", disbursedDate=" + disbursedDate +
                ", bankadmin=" + bankAdmin +
                ", loanApplication=" + loanApplication +
                '}';
    }

    public int getOfferID() {
        return OfferID;
    }

    public void setOfferID(int offerID) {
        OfferID = offerID;
    }

    public Double getSanctionedAmount() {
        return sanctionedAmount;
    }

    public void setSanctionedAmount(Double sanctionedAmount) {
        this.sanctionedAmount = sanctionedAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public String getOfferStatus() {
        return loanOfferStatus;
    }

    public void setOfferStatus(String loanOfferStatus) {
        this.loanOfferStatus = loanOfferStatus;
    }

    public Date getDisbursedDate() {
        return disbursedDate;
    }

    public void setDisbursedDate(Date disbursedDate) {
        this.disbursedDate = disbursedDate;
    }

    public BankAdmin getBankAdmin() {
        return bankAdmin;
    }

    public void setBankAdmin(BankAdmin bankAdmin) {
        this.bankAdmin = bankAdmin;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }
}
