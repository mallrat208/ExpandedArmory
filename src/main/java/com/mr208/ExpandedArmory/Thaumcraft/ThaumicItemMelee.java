package com.mr208.ExpandedArmory.Thaumcraft;

import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Optional;

import thaumcraft.api.IRepairable;


public class ThaumicItemMelee extends ExArmItemMelee implements IRepairable {
	private String repairMaterial;

	public ThaumicItemMelee(String id, MeleeComponent meleecomponent, String repairmaterial, EnumRarity rarity) {
		super(id, meleecomponent, repairmaterial, rarity);
	}

	@Optional.Method(modid="Thaumcraft")
	public boolean doRepair(ItemStack itemStack, EntityPlayer entityPlayer, int i) {
		if((this.repairMaterial=="ingotThaumium" || this.repairMaterial=="ingotVoid"))
		{
			return true;
		}
		return false;
	}
}
