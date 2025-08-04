package tw.brad.spring6.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import tw.brad.spring6.entity.Member;
import tw.brad.spring6.entity.Profile;

@DataJpaTest
@Rollback(true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("classpath:application-test.properties")
public class MemberRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Test
	void test1() {
		// 建立測試資料
		Profile profile = new Profile();
		profile.setCname("Test10");
		profile.setAge(18);
		
		Member member = new Member();
		member.setEmail("test10@brad.tw");
		member.setPasswd("123456");
		member.setProfile(profile);
		//member = memberRepository.save(member);
		
		//Optional<Member> result = memberRepository.findById(member.getId());
		//Optional<Member> result = memberRepository.findById(12L);
		
		// 以下
		/*
		assertTrue(result.isPresent());
		assertEquals("test10@brad.tw", result.get().getEmail());
		//System.out.println(result.get().getProfile().getCname());
		assertEquals("Test10", result.get().getProfile().getCname());
		*/
		
		System.out.println("Finish");
		
		
	}
	
	@Test
	void test2() {
		
		
		assertTrue(memberRepository.findById(3L).isPresent());
		
		memberRepository.deleteById(3L);
		assertTrue(memberRepository.findById(3L).isEmpty());
		
	}
	
	@Test
	void test3() {
		Member m1 = new Member();
		m1.setEmail("t1@brad.tw");
		m1.setPasswd("1111");
		
		Member m2 = new Member();
		m2.setEmail("t2@brad.tw");
		m2.setPasswd("1111");
		
		memberRepository.save(m1);
		memberRepository.save(m2);
		
		List<Member> all = memberRepository.findAll();
		assertTrue(all.size() == 10);
	}
	
}
