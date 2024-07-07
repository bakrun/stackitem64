package com.metao.stackitem.mixin;

import net.minecraft.component.ComponentMap;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Item.Settings.class)
public abstract class ExampleMixin {
	@Shadow protected abstract ComponentMap getComponents();

	private ComponentMap.Builder components;



	@ModifyVariable(method = "maxCount",at = @At("HEAD"),ordinal = 0)
	private int test(int maxCount){
	return maxCount = 64;
}



}

