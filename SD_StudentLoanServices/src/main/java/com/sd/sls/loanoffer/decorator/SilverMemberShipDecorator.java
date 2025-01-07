package com.sd.sls.loanoffer.decorator;

public class SilverMemberShipDecorator extends InterestRateDecorator{
	
	public SilverMemberShipDecorator(IInterestRate decoratedInterestRate)
	{
		super(decoratedInterestRate);
	}
	
	public double getRate()
	{
		//return decoratedInterestRate.getRate() - 1.0;
		return super.getRate() - 1.0;
	}
}
