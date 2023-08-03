package com.example.demo.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "item_id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "itemname")
	private String name;

	public Item() {
		this("default");
	}

	public UUID getId() {
		return id;
	}

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// add getters, setters, etc. as needed

}
