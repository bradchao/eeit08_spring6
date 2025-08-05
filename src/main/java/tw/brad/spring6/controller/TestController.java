package tw.brad.spring6.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.spring6.utils.JwtTool;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/m1/{email}")
	public void test1(@PathVariable String email) {
		String token = JwtTool.createToken(email);
		System.out.println(token);
	}
	
	@RequestMapping("/m2/{token}")
	public void test2(@PathVariable String token) {
		String email = JwtTool.parseToken(token);
		System.out.println(email);
	}
	
	
	
}
