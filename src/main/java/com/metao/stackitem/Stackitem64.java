package com.metao.stackitem;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;



public class Stackitem64 implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("stackitem64");

	@Override
	public void onInitialize() {

        try {
            new StackItem64configfile().InitConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}