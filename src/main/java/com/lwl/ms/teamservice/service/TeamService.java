package com.lwl.ms.teamservice.service;

import com.lwl.ms.teamservice.domain.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

        public List<Team> getTeamDetails();
        public List<String> getTeamLabels();
        public Team getTeamByLabel(String label);
}
