package com.ironhack.final_project.exception;

public class EffectNotFoundException extends RuntimeException {
    public EffectNotFoundException(String param) {
        super("Effect with id or name " + param + " not found.");
    }
}
