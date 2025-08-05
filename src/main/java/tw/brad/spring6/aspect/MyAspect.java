package tw.brad.spring6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MyAspect {
	/*
	 * *(..), member*(..)
	 */
	@Pointcut("execution(* tw.brad.spring6.controller..*(..))")
	public void doControllerMethod() {}
	
	@Before("doControllerMethod()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("doBefore......");
		//System.out.println(joinPoint.getSignature().getName());
	}
	
	@After("doControllerMethod()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("doAfter......");
		//System.out.println(joinPoint.getSignature().getName());
	}
	@Around("doControllerMethod()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("doAround1......");
		
		Object[] args = joinPoint.getArgs();
		for (Object arg: args) {
			System.out.println(arg);
		}
		
		Object obj = joinPoint.proceed();
		
		System.out.println("doAround2......");
		
		return obj;
	}
	
}
