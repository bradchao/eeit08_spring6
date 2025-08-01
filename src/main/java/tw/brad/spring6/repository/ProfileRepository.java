package tw.brad.spring6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.brad.spring6.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
