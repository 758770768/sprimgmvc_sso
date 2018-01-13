package org.test.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.test.utils.DateFormat;

@Aspect
@Component
public class TimeOverAspect {

	@Value("${time}")
	private String time;

	@Pointcut("execution(* org.test.controller.*.*(..))")
	public void fn() {

	}

	/**
	 * oliver 2018年1月13日 springmvc_sso
	 * 
	 * @return
	 * 
	 * @throws Throwable
	 */
	@Around("fn()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知!");
		Date begin = new Date();
		Date end = DateFormat.format(time);
		if (!begin.after(end)) {
			Object result = pjp.proceed();
			return result;
		}
		return "unlock";
	}
}
