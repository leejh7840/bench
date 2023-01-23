package com.nexient.bench.entity;

import javax.persistence.Entity;
import lombok.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alien {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	private String aname;
	private String tech;
}
