package com.elMawqe3.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Event {
	@Id
	@SequenceGenerator(name = "ev_sequence",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ev_sequence")
	private Long id;
	private String headline;
	private String details;
	private String author;
	private String pPath;
	
	public String getSig() {
		return "By "+this.author;
	}
	
}

