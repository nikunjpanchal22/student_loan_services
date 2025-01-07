package com.sd.sls.interceptor.dp;
import org.springframework.beans.factory.annotation.Autowired;
/*
 * @Author: Abhishek Vishwakarma
*/
import org.springframework.stereotype.Service;

@Service
public class InterceptorFramework 
{
	@Autowired
	private InterceptorDispatcher dispatcher;

    public void execute(Context context) 
    {
        dispatcher.dispatch(context);
    }
	
	public void registerInterceptor(Interceptor interceptor) 
	{
		dispatcher.addInterceptor(interceptor);
    }
}
