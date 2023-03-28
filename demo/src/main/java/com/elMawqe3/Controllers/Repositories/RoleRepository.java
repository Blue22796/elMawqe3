package com.elMawqe3.Controllers.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elMawqe3.Models.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long>{
	public List<Role> findByName(String name);
}
