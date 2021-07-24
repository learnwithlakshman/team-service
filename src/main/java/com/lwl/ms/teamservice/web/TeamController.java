package com.lwl.ms.teamservice.web;

import com.lwl.ms.teamservice.domain.Team;
import com.lwl.ms.teamservice.service.TeamService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamController {

	private TeamService teamService;

	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	@GetMapping("/teamDetails")
	public List<Team> getTeamDetails() {

		return teamService.getTeamDetails();

	}

	@GetMapping("/label")
	public List<String> getTeamLabels() {

		return teamService.getTeamLabels();
	}

	@GetMapping("/{label}")
	public Optional<Team> getTeam(String label) {
		return teamService.getTeam(label);

	}
}
