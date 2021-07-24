package com.lwl.ms.teamservice.web;

import com.lwl.ms.teamservice.service.TeamService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class TeamController {

        private TeamService teamService;

        public TeamController(TeamService teamService){
            this.teamService = teamService;
        }


}
