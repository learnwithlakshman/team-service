package com.lwl.ms.teamservice.service;

import com.lwl.ms.teamservice.domain.Team;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements  TeamService {

    private List<Team> teamList;

    @PostConstruct
    public void init(){
            teamList = new ArrayList<>();
            //Logic
    }

    @Override
    public List<Team> getTeamDetails() {
        return null;
    }

    @Override
    public List<String> getTeamLabels() {
        return null;
    }

    @Override
    public Optional<Team> getTeam(String label) {
        return Optional.empty();
    }
}
