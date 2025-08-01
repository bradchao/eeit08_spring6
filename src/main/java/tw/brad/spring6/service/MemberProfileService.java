package tw.brad.spring6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.brad.spring6.entity.Member;
import tw.brad.spring6.entity.Profile;
import tw.brad.spring6.repository.MemberRepository;
import tw.brad.spring6.repository.ProfileRepository;

@Service
public class MemberProfileService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private ProfileRepository profileRepository;
	
	@Transactional
	public Member save(Member member, Profile profile) {
		member.setProfile(profile);
		return memberRepository.save(member);
	}
	
	public Profile setProfileToMember(Long memberId, Profile profile) {
		Member member = memberRepository.findById(memberId).orElse(null);
		if (member != null) {
			member.setProfile(profile);
			Member m1 = memberRepository.save(member);
			return m1.getProfile();
		}else {
			return null;
		}
	}
	
}
