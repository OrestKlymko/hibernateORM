package org.study.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "planet")
public class Planet {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String planetName;

	@OneToMany(mappedBy = "planetFrom")
	@ToString.Exclude
	private List<Ticket> departingTickets;

	@OneToMany(mappedBy = "planetTo")
	@ToString.Exclude
	private List<Ticket> arrivingTickets;


	public void setId(String id) {
		this.id = id.toUpperCase();
	}
}
