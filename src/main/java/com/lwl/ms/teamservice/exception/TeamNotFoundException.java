package com.lwl.ms.teamservice.exception;

public class TeamNotFoundException extends  RuntimeException {

        public TeamNotFoundException(String message){
            super(message);
        }
}
