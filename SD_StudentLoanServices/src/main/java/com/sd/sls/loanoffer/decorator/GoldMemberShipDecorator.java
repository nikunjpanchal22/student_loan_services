package com.sd.sls.loanoffer.decorator;

/*
 * Author: Rushabh Botadra
 */
public class GoldMemberShipDecorator extends InterestRateDecorator{
	
	public GoldMemberShipDecorator(IInterestRate decoratedInterestRate)
	{
		super(decoratedInterestRate);
	}
	
	public double getRate()
	{
		return super.getRate() - 2.0;
	}
}
