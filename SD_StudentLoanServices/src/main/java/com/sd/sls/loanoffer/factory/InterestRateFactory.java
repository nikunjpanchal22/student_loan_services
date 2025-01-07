package com.sd.sls.loanoffer.factory;

import org.springframework.stereotype.Component;

/*
 * Author: Rushabh Botadra
 */
import com.sd.sls.loanoffer.decorator.GoldMemberShipDecorator;
import com.sd.sls.loanoffer.decorator.IInterestRate;
import com.sd.sls.loanoffer.decorator.NormalInterestRate;
import com.sd.sls.loanoffer.decorator.SilverMemberShipDecorator;
import com.sd.sls.membershiptype.MembershipType;

@Component
public class InterestRateFactory {
	
	public IInterestRate getInterestRateFactory(String membershipType)
	{
		if(membershipType.equals(MembershipType.GOLD.getMembershipType()))
		{
			return new GoldMemberShipDecorator(new NormalInterestRate());
		}
		else if(membershipType.equals(MembershipType.SILVER.getMembershipType()))
		{
			return new SilverMemberShipDecorator(new NormalInterestRate());
		}
		else if(membershipType.equals(MembershipType.REGULAR.getMembershipType()))
		{
			return new NormalInterestRate();
		}
		else
		{
			throw new IllegalArgumentException("Unexpected value: " + membershipType);
		}
	}

}
