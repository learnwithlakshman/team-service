package com.lwl.ms.teamservice.service;
import com.lwl.ms.teamservice.domain.Team;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import com.lwl.ms.teamservice.exception.TeamNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@Slf4j
public class TeamServiceImpl implements TeamService {

	@Value("${data.file.name}")
	private String fileName;
	private List<Team> teamList = new ArrayList<>();

	@PostConstruct
	public void init() throws IOException {
		try{
			List<String> lines = Files.readAllLines(new ClassPathResource(fileName).getFile().toPath());
			teamList = lines.stream().map(TeamServiceImpl::lineToTeam).collect(Collectors.toList());
			log.info("Total {} are teams found",teamList.size());
		}catch (IOException e){
			log.error("File {} not found in the classpath");
		}
	}

	private static Team lineToTeam(String line) {
		String[] arr = line.split(",");
		int count = 0;
		String city = arr[count++];
		String coach = arr[count++];
		String homeGround = arr[count++];
		String name = arr[count++];
		String label = arr[count++];
		return Team.builder().city(city).name(name).homeGround(homeGround).label(label).coach(coach).build();
	}

	@Override
	public List<Team> getTeamDetails() {
		log.info("Requested for team  details and found {} teams",teamList.size());
		return teamList;
	}
	@Override
	public List<String> getTeamLabels() {
		List<String> list = teamList.stream().map(t -> t.getLabel()).collect(Collectors.toList());
		log.info("Team labels are requested and returned {}",list);
		return list;
	}

	@Override
	public Team getTeamByLabel(final String label) {
		 Assert.hasText(label,"Label can't be empty or null");
		 log.info("Requested team details of the label {}",label);
		 Optional<Team> optTeam = teamList.stream().filter(t -> t.getLabel().equalsIgnoreCase(label)).findFirst();
		 if(!optTeam.isPresent()){
		 	log.error("Team details are not found for the given label {}:",label);
		 }
		 return optTeam.orElseThrow(()->new TeamNotFoundException("Team is not found with given name :"+label));
	}

}
