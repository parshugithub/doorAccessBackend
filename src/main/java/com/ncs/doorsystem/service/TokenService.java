package com.ncs.doorsystem.service;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;


public class TokenService extends TimerTask
{
	private static final Integer EXPIRE_MINS = 5;
	public  int  count=0;
	
//	public int timerValue()
//	{
//		
//		Timer timer = new Timer();
//		TimerTask timerTask = new TimerTask() {
//			
//			@Override
//			public void run() 
//			{
//				++count;
//				
//				
//			}
//		};
//		timer.schedule(timerTask, 100000);
//		
//		System.out.println(count);
//		return count;
//		
//	}

	@Override
	public void run() {
		count++;
		
	}

	
	 

	 
//	 Timer t = new Timer(). schedule(tt,1000,1000);
//	 TimerTask tt = new TimerTask() {
//	     @Override
//	     public void run() {
//	         //do something
//	     };
//	 };
//	

	 

}
