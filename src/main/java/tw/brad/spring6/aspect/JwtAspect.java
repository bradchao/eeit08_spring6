package tw.brad.spring6.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import tw.brad.spring6.excption.AuthException;
import tw.brad.spring6.utils.JwtTool;

@Aspect
@Component
public class JwtAspect {
	/*
	 * Authorization: Bearer token
	 */
	@Around("@annotation(tw.brad.spring6.aop.CheckJwt)")
	public Object checkJwt(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("checkJwt()");
		
		RequestContextHolder.getRequestAttributes();
		
		HttpServletRequest req =
				((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
				.getRequest();
		String authHeader = req.getHeader("Authorization");
		if (authHeader == null) {
			throw new AuthException("NO Auth");
		}
		System.out.println(authHeader);
		if (!authHeader.startsWith("Bearer ")) {
			throw new AuthException("Bearer ERROR");
		}
		
		try {
			String token = authHeader.substring(7);
			
			String email = JwtTool.parseToken(token);
			if (email == null) {
				throw new AuthException("token 可能失效");
			}
			System.out.println(email);
			
			return joinPoint.proceed();
		}catch(Exception e) {
			throw new AuthException("token 無效");
		}
		
		
		
		
		
	}
}
