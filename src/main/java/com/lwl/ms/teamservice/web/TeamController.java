package com.lwl.ms.teamservice.web;

import com.lwl.ms.teamservice.domain.Team;
import com.lwl.ms.teamservice.service.TeamService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamController {

	private TeamService teamService;

	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	@GetMapping("/teamdetails")
	public ResponseEntity<?> getTeamDetails() {
		return ResponseEntity.ok(teamService.getTeamDetails());
	}

	@GetMapping("/labels")
	public ResponseEntity<?> getTeamLabels() {
		return ResponseEntity.ok(teamService.getTeamLabels());
	}

	@GetMapping("/{label}")
	public ResponseEntity<?> getTeam(@PathVariable("label")String label) {
		return ResponseEntity.ok(teamService.getTeamByLabel(label));
	}
}
