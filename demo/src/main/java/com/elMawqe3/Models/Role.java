package com.elMawqe3.Models;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

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
import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@Table(name = "role",uniqueConstraints = @UniqueConstraint(name = "name"
,columnNames = "name"))
@Entity
@Transactional
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1979674789670923835L;

	@Id
	@SequenceGenerator(name = "ev_sequence",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ev_sequence")
	private Long ID;
	
	@NotNull
	public String name;
}
