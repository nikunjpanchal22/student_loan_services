package com.sd.sls.interceptor.dp;

/*
 * @Author: Abhishek Vishwakarma
*/

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class InterceptorDispatcher 
{
	private List<Interceptor> interceptors = new ArrayList<>();
	
	public void addInterceptor(Interceptor interceptor) 
	{
        interceptors.add(interceptor);
    }

    public void dispatch(Context context) 
    {
        for (Interceptor interceptor : interceptors) 
        {
            interceptor.eventCallBack(context);
        }
    }
}
