package org.study.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	@ToString.Exclude
	private List<Ticket> tickets;


}
