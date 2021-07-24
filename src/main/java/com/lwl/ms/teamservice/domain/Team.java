package com.lwl.ms.teamservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {

	private String name;
	private String coach;
	private String city;
	private String homeGround;
	private String label;
}
