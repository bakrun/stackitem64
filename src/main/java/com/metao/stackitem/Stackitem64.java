package com.metao.stackitem;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ShulkerBoxScreenHandler;
import net.minecraft.screen.slot.ShulkerBoxSlot;
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
    public static void insertNewItem(PlayerEntity player, ItemStack stack2) {
        if (!player.getInventory().insertStack(stack2)) {
            player.dropItem(stack2, false);
        }
    }
}