package com.technobright.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class LoggingAop{

	

	private final Log log = LogFactory.getLog(this.getClass().getName());
	
	public void methodCallsByUser(JoinPoint joinPoint){
		System.out.println(joinPoint.getKind()+"........................***************");
	}
	

	public void beforeMethod(JoinPoint joinPoint){		
		try{
				System.out.println("Before method="+joinPoint.toLongString());
				log.info("Before method="+joinPoint.toLongString());
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void afterMethod(JoinPoint joinPoint){
		System.out.println("After method="+joinPoint.toShortString());
		log.info("After method="+joinPoint.toShortString());
	}
	
	public void afterThrowing(Exception e){
		try{
		System.out.print("After throwing= ");
		e.printStackTrace();
		}catch (Throwable th) {
			th.printStackTrace();
		}
	}
}
