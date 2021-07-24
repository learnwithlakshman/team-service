package com.lwl.ms.teamservice.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.lwl.ms.teamservice.domain.Team;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private ResourceLoader resourceLoader;

	private List<Team> teamList = new ArrayList<>();

	@PostConstruct
	public void init() throws IOException {

		Path p = new ClassPathResource("teams.csv").getFile().toPath();

		List<String> str = Files.readAllLines(p);
		String[] arr;

		for (String s : str) {
			arr = s.split(",");
			String city = arr[0];
			String coach = arr[2];
			String homeGround = arr[3];
			String name = arr[4];
			String label = arr[5];

			Team t = new Team(name, coach, city, homeGround, label);
			teamList.add(t);

		}
	}

	@Override
	public List<Team> getTeamDetails() {

		List<Team> list = teamList;

		return list;
	}

	@Override
	public List<String> getTeamLabels() {

		List<String> list = new ArrayList<>();

		for (Team teamlist : teamList) {
			list.add(teamlist.getLabel());
		}

		return list;
	}

	@Override
	public Optional<Team> getTeam(String label) {

		for (Team l : teamList) {

			if (label.equals(l.getLabel())) {

				return Optional.of(l);
			} else {
				System.out.println("Optional is empty");
			}

		}

		return Optional.empty();
	}

	public static void main(String[] args) {
		TeamService obj = new TeamServiceImpl();
		obj.getTeamDetails();
	}
}
