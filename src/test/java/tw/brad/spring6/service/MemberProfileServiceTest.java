package tw.brad.spring6.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import tw.brad.spring6.entity.Member;
import tw.brad.spring6.entity.Profile;
import tw.brad.spring6.repository.MemberRepository;
import tw.brad.spring6.repository.ProfileRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

@DataJpaTest
@Import(MemberProfileService.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("classpath:application-test.properties")
public class MemberProfileServiceTest {
	@Autowired
	private MemberProfileService service;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	private Member saveMember;
	
	@BeforeEach
	void before() {
		Member member = new Member();
		member.setEmail("b3@brad.tw");
		member.setPasswd("123");
		
		saveMember = memberRepository.save(member);
		System.out.println("saveMember ID:" + saveMember.getId());
	}
	
	@Test
	void test1() {
		Profile newprofile = new Profile();
		newprofile.setCname("B1");
		newprofile.setAge(18);

		Profile newp = service.setProfileToMember(saveMember.getId(), newprofile);
		
		assertNotNull(newp);
		System.out.println(newp.getCname());
		
		
		System.out.println("Finish1");
		
	}
	
	@Test
	void test2() {
		Profile newprofile = new Profile();
		newprofile.setCname("B1");
		newprofile.setAge(18);
		saveMember.setProfile(newprofile);
		System.out.println(saveMember.getEmail());
		System.out.println(saveMember.getProfile().getCname());
		
		// 以下才是測試
		Profile updateprofile = new Profile();
		updateprofile.setCname("B2");
		updateprofile.setAge(18);

		Profile newp = service.setProfileToMember(saveMember.getId(), updateprofile);
		
		assertNotNull(newp);
		System.out.println(newp.getCname());
		
		System.out.println("Finish2");
	}
	
	
	
}
