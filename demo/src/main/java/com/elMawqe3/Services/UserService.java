package com.elMawqe3.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elMawqe3.Controllers.Repositories.UserRepository;
import com.elMawqe3.Models.User;

@Service
@Transactional
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	public List<User> events() {
		return userRepo.findAll();
	}
	

	public void saveUser(User user) {
		userRepo.save(user);
		return;
	}
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<User> cands = userRepo.findByEmail(email);
		if(cands.size()==0)
			throw new UsernameNotFoundException("User doesn't exist X.x");
		return cands.get(0);
		
	}
	
	
}
