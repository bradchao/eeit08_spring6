package tw.brad.spring6.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.spring6.aop.CheckJwt;
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
	
	/*
	 * req : {
	 * 	email : "",
	 * 	passwd : ""
	 * }
	 * 
	 * resp: {
	 * 	token: "....."
	 * }
	 */
	@PostMapping("/member/login")
	public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> data) {
		String email = data.get("email");
		String passwd = data.get("passwd");
		
		Map<String,String> result = new HashMap<>();
		if (email.equals("brad@brad.tw") && passwd.equals("123456")) {
			result.put("token", JwtTool.createToken(email));
		}
		
		return ResponseEntity.ok(result);
	}
	
	@CheckJwt
	@PostMapping("/member/status")
	public ResponseEntity<Map<String,String>> status() {
		System.out.println("Welcome");
		Map<String,String> result = Map.of("status","ok");
		return ResponseEntity.ok(result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
