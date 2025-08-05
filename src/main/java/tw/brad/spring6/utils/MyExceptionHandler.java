package tw.brad.spring6.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tw.brad.spring6.excption.AuthException;

@RestControllerAdvice	// 全域性 Exception 攔截
public class MyExceptionHandler {

	@ExceptionHandler(AuthException.class)
	public ResponseEntity<String> handlerException(AuthException e){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("權限被拒");
	}
	
}
