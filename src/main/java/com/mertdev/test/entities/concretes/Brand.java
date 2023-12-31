package com.mertdev.test.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "brand")
	private List<Model> models;
}
