package com.elMawqe3.Models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	@Id
	@SequenceGenerator(name = "ev_sequence",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ev_sequence")
	private Long Id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User Author;
	private String content;
	private LocalDate date;
	private Time time;
}
