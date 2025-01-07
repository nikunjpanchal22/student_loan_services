package com.sd.sls.loanoffer.factory;

/*
* Author: Nikunj Panchal
*/

import com.sd.sls.loanoffer.status.stateDP.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.sls.loanoffer.status.stateDP.*;

import java.util.Map;
import java.util.Objects;

@Component
public class LoanOfferStatusFactory {
    @Autowired
    private OfferAcceptedState acceptedState;

    @Autowired
    private OfferRejectedState rejectedState;

    @Autowired
    private OfferDisbursedState disburseState;

    @Autowired
    private OfferGeneratedState generatedState;

    public ILoanOfferStatusState getLoanOfferState(Map<String, Object> userValues) {
        return switch (Objects.toString(userValues.get("action"))) {
            case "accepted" -> acceptedState;
            case "rejected" -> rejectedState;
            case "generated" -> generatedState;
            case "disburse" -> disburseState;
            default -> throw new IllegalArgumentException("Unexpected value: " + userValues.get("action"));
        };
    }
}