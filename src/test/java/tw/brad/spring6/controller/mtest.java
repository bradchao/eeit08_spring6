package tw.brad.spring6.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.brad.spring6.entity.Member;
import tw.brad.spring6.entity.Profile;
import tw.brad.spring6.service.MemberProfileService;

@WebMvcTest(MemberProfileController.class)
public class mtest {

	@MockBean
	private MemberProfileService service;
	
	@Mock
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@BeforeEach
	void before() {
		System.out.println("before()");
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void test1() throws Exception{
		System.out.println("Testing....");
		
		// 建立測試資料
		Member member = new Member();
		member.setEmail("test3@brad.tw");
		member.setPasswd("123456");
		
		Profile profile = new Profile();
		profile.setCname("Test1");
		profile.setAge(18);
		
		member.setProfile(profile);
		
		// 模擬 service 行為
		Mockito.when(service.save(Mockito.any(), Mockito.any())).thenReturn(member);
		
		// 建立參數傳遞進來的資料
		 Map<String,Object> requestBody = Map.of(
				 "email", "test3@brad.tw",
				 "passwd", "123456",
				 "profile", Map.of(
						 	"cname", "Test1",
						 	"age", 18
						 )
				 );
		 System.out.println(objectMapper.writeValueAsString(requestBody));
		
		 // 執行測試
		 ResultActions result = mockMvc.perform(post("/api/member")
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(objectMapper.writeValueAsString(requestBody)));

		 System.out.println(result == null);
		 
//		 	.andExpect(status().isOk())
//		 	.andExpect(jsonPath("$.email", is("test1@brad.tw")))
//		 	.andExpect(jsonPath("$.profile.cname", is("Test1")))
//		 	.andExpect(jsonPath("$.profile.age", is(18)));
		
		System.out.println("Finish");
	}
	
	@AfterEach
	void after() {
		System.out.println("after()");
	}
	
}
