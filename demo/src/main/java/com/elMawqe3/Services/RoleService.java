package com.elMawqe3.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elMawqe3.Controllers.Repositories.RoleRepository;
import com.elMawqe3.Models.Role;

@Service
public class RoleService {
	@Autowired
	private RoleRepository RR;
	
	public Role getAdminRole() {
		return RR.findByName("admin").get(0);
	}
	
	public Role getUserRole() {
		return RR.findByName("user").get(0);
	}
}
