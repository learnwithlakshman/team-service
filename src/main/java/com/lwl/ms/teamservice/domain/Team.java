package com.lwl.ms.teamservice.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team {

	private String name;
	private String coach;
	private String city;
	private String homeGround;
	private String label;
}
