package tw.brad.spring6.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BradAspect {

	@Around("@annotation(tw.brad.spring6.aop.BradAOP)")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("doAround111......");
		
		Object[] args = joinPoint.getArgs();
		for (Object arg: args) {
			System.out.println(arg);
		}
		
		Object obj = joinPoint.proceed();
		
		System.out.println("doAround222......");
		
		return obj;
	}	
	
}
