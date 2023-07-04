package com.infosys.gcp.AOP;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ErrorHandler {
    
    @Around("execution(* com.infosys.gcp..*(..))")
	public Object aroundController(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();

		// log the input
		Map<String, Object> message = new HashMap<>();
		message.put("event", "Repository Start");
		message.put("method", point.getSignature().toString());
		message.put("args", point.getArgs());

		// execute the method
		Object result = point.proceed();

		// log the response
		message = new HashMap<>();
		message.put("event", "Repository Response");
		message.put("method", point.getSignature().toString());
		message.put("response", result);

		// log the time taken
		message = new HashMap<>();
		message.put("event", "Repository End");
		message.put("method", point.getSignature().toString());
		message.put("time", System.currentTimeMillis() - start);

		return result;

    }

}
