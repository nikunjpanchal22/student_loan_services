package com.sd.sls.loanoffer.controller;

/*
 * @Author: Nikunj Panchal
 */

import com.sd.sls.loanoffer.bs.ILoanOfferBS;
import com.sd.sls.loanoffer.model.LoanOffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/loanOffer")
@RestController
public class LoanOfferController
{
    @Autowired
    private ILoanOfferBS loanOfferBS;

    @GetMapping("/getAllOffers")
    public ResponseEntity<List<LoanOffer>> getAllOffers () {
        List<LoanOffer> loanOfferList = loanOfferBS.getAllOffers();
        if (!loanOfferList.isEmpty()) {
            return ResponseEntity.ok(loanOfferList);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
