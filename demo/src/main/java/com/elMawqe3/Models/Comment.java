package com.elMawqe3.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String Author;
	private String content;
	private LocalDate date;
}
