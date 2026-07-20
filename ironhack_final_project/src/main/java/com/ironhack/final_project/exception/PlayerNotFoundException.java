package com.ironhack.final_project.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(String param) {
        super("Player with id or name " + param + " not found.");
    }
}
