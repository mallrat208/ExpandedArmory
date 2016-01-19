package com.mr208.ExpandedArmory.FSP;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.registry.GameRegistry;

import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import com.mr208.ExpandedArmory.Items.ItemIngot;
import com.mr208.ExpandedArmory.RegisterItems;

public class FSPIntegration {

	public static Item ingotBrass;
	public static Item battleaxeBrass;
	public static Item boomerangBrass;
	public static Item flailBrass;
	public static Item halberdBrass;
	public static Item katanaBrass;
	public static Item knifeBrass;
	public static Item musketbayonetBrass;
	public static Item spearBrass;
	public static Item warhammerBrass;
	
	public static Item ingotGilded;
	public static Item battleaxeGilded;
	public static Item boomerangGilded;
	public static Item flailGilded;
	public static Item halberdGilded;
	public static Item katanaGilded;
	public static Item knifeGilded;
	public static Item musketbayonetGilded;
	public static Item spearGilded;
	public static Item warhammerGilded;
	public static Item.ToolMaterial Brass;
	public static Item.ToolMaterial GildedIron;

	public static void preInitFSP()
	{
		GameRegistry.registerItem(ingotBrass = new ItemIngot("ingotBrass"),"ingotBrass");
		GameRegistry.registerItem(ingotGilded = new ItemIngot("ingotGildedIron"),"ingotGildedIron");
	}
	
	public static void initFSP()
	{
		if(ExArmConfig.enableBrass) initBrass();
		if(ExArmConfig.enableGildedIron) initGilded();
	}

	private static void	initBrass()
	{

		Brass = Item.ToolMaterial.valueOf("BRASS");
		MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(Brass,0xECDB42FF));
		if(Brass.getRepairItemStack()==null) Brass.setRepairItem(new ItemStack(ingotBrass));
		Item[] weaponArray = {battleaxeBrass,boomerangBrass,flailBrass,halberdBrass,katanaBrass,knifeBrass,musketbayonetBrass,spearBrass,warhammerBrass};
		RegisterItems.RegisterRegularWeapon(weaponArray,"brass",Brass,"ingotBrass");
		RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotBrass");
	}

	private static void	initGilded()
	{
		Item ingotFSP = GameRegistry.findItem("Steamcraft","steamcraftIngot");
		if(ingotFSP!=null) OreDictionary.registerOre("ingotGildedIron",new ItemStack(ingotFSP,1,3));
		GildedIron = Item.ToolMaterial.valueOf("GILDEDGOLD");
		MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(GildedIron,0xFFF068FF));
		if(GildedIron.getRepairItemStack()==null) GildedIron.setRepairItem(new ItemStack(ingotGilded));
		Item[] weaponArray = {battleaxeGilded,boomerangGilded,flailGilded,halberdGilded,katanaGilded,knifeGilded,musketbayonetGilded,spearGilded,warhammerGilded};
		RegisterItems.RegisterRegularWeapon(weaponArray,"gildediron",GildedIron,"ingotGildedIron");
		RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotGildedIron");

	}

}
