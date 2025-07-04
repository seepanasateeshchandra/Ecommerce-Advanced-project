package com.example.InterFace.Web.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InterFace.Web.Entity.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>  {
	
	
	Optional<UserDetails> findByEmailId(String emailId);
	
	
	

}
