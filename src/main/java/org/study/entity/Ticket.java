package org.study.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "from_planet_id")
	private Planet planetFrom;

	@ManyToOne
	@JoinColumn(name = "to_planet_id")
	private Planet planetTo;
}
