package com.elMawqe3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elMawqe3.Controllers.Repositories.RoleRepository;
import com.elMawqe3.Models.Role;

@Service
public class RoleService {
	@Autowired
	private RoleRepository RR;
	
	public Role getRole(String role) {
		Role UR;
		try {
			UR= RR.findByName(role).get(0);
		}
		catch(IndexOutOfBoundsException inx){
			UR = new Role();
			UR.setName(role);
			RR.save(UR);
		}
		return UR;
	}
}
