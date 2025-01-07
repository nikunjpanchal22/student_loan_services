package com.sd.sls.observer.dp;
/*
 * @Author: Ranatosh Sarkar
 */
import java.util.Map;

public interface Subject 
{
	public void addObserver(Observer observer);
	
	public void removeObserver(Observer observer);
	
	public void notifyObserver(Map<String, Object> values);
}
