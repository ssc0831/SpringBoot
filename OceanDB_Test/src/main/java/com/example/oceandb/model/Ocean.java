package com.example.oceandb.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Ocean {
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String subject;
	private String kind;
	private Date datetime;
	private String filename;
	
	@ManyToOne
    @JoinColumn(name = "location_id")
	private Location location;

	
}
