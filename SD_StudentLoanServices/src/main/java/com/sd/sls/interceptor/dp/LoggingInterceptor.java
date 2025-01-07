package com.sd.sls.interceptor.dp;

/*
 * @Author: Abhishek Vishwakarma
*/

import java.sql.Timestamp;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Component;

@Component
public class LoggingInterceptor implements Interceptor {
	
	private static final Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());
	
	public LoggingInterceptor() 
	{
		try 
		{
			String fileDir = "C:/Users/abhis/Masters/Modules/Sem 1/CS5721 Software Design/Project/student_loan_services.log";
			
            FileHandler fileHandler = new FileHandler(fileDir, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
            
            logger.info("LoggingInterceptor initialized. Logs will be written to: " + fileDir);
        }
		catch (Exception e) 
		{
            System.err.println("Failed to configure logger: " + e.getMessage());
        }
	}

	@Override
	public void eventCallBack(Context context) 
	{
		String logMessage = "Loan Application ID: " + context.get("applicationDetails") + " Submitted on " + new Timestamp(System.currentTimeMillis());
        logger.info(logMessage);
        System.out.println("Logged to file: " + logMessage);

	}
}