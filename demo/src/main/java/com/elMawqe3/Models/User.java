package com.elMawqe3.Models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table(name = "user",uniqueConstraints = @UniqueConstraint(name = "email"
,columnNames = "email"))
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7345641107388720431L;
	@Id
	@SequenceGenerator(name = "ev_sequence",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ev_sequence")
	private Long ID;
	private String username;
	private String password;
	@Column(name="email")
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> roles = new HashSet<>();
	
	public User(@Valid UserDto newUser) {
		this.username=newUser.getUsername();
		this.email=newUser.getEmail();
		
		
		BCryptPasswordEncoder crypter = new BCryptPasswordEncoder();
		this.password=crypter.encode(newUser.getPassword());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> auths = roles.stream().
				map(role -> new SimpleGrantedAuthority
						("ROLE_"+role.getName())).toList();
		return auths;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String say(String something) {
		return this.username+": "+something;
	}
}
