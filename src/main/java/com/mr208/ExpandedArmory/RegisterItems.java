package com.mr208.ExpandedArmory;


import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.item.*;
import com.mr208.ExpandedArmory.Items.ExArmItemFlail;
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;
import com.mr208.ExpandedArmory.Items.ExArmItemMusket;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;


public class RegisterItems {
    
    public static void RegisterRegularWeapon(Item[] weapons,String itemName, Item.ToolMaterial material,String repairItem)
    {
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
        weapons[0] = new ExArmItemMelee("battleaxe." + itemName, new MeleeCompBattleaxe(material),repairItem).setTextureName("exparmory:"+itemName+"/battleaxe."+itemName);
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
        weapons[1] = new ExArmItemMelee("boomerang." + itemName, new MeleeCompBoomerang(material),repairItem).setTextureName("exparmory:"+itemName+"/boomerang."+itemName);
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
        weapons[2] = new ExArmItemFlail("flail." + itemName,material,repairItem).setTextureName("exparmory:"+itemName+"/flail."+itemName);
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
        weapons[3] = new ExArmItemMelee("halberd." + itemName,new MeleeCompHalberd(material),repairItem).setTextureName("exparmory:"+itemName+"/halberd."+itemName);
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
        weapons[4] = new ExArmItemMelee("katana." + itemName, new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,material),repairItem).setTextureName("exparmory:"+itemName+"/katana."+itemName);
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        weapons[5] = new ExArmItemMelee("knife." + itemName, new MeleeCompKnife(material),repairItem).setTextureName("exparmory:"+itemName+"/knife."+itemName);
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("musket")&&BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        weapons[6] = new ExArmItemMusket("musketbayonet." + itemName, new MeleeCompKnife(material),weapons[5],repairItem).setTextureName("exparmory:"+itemName+"/musketbayonet."+itemName);
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
        weapons[7] = new ExArmItemMelee("spear." + itemName, new MeleeCompSpear(material),repairItem).setTextureName("exparmory:"+itemName+"/spear."+itemName);
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
        weapons[8] = new ExArmItemMelee("warhammer." + itemName, new MeleeCompWarhammer(material),repairItem).setTextureName("exparmory:"+itemName+"/warhammer."+itemName);
    }


    
    public static void CreateWeaponRecipes(Item[] weapons, String stickItem, String materialItem)
    {
        //BattleAxe
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons[0]), "###", "#X#", " X ", 'X', stickItem, '#', materialItem));
        //Boomerang
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons[1]), "XX#", "  X", "  X", 'X', "plankWood", '#', materialItem));
        //Flail
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons[2]), "  O", " XO", "X #", 'X', stickItem, 'O', net.minecraft.init.Items.string, '#', materialItem));
        //Halberd
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons[3]), " ##", " X#", "X  ", 'X', stickItem, '#', materialItem));
        //Katana
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons[4]), "  #", " # ", "X  ", 'X', stickItem, '#', materialItem));
        //Knife
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons[5]), "#X", 'X', stickItem, '#', materialItem));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(weapons[5]), "#", "X", 'X', stickItem, '#', materialItem));
        //Musket with Bayonet
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("musket")&&(BalkonsWeaponMod.instance.modConfig.isEnabled("knife")))
        GameRegistry.addShapelessRecipe(new ItemStack(weapons[6]).copy(), weapons[5], BalkonsWeaponMod.musket);
        //Spear
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[7], "  #", " X ", "X  ", 'X', stickItem, '#', materialItem));
        //Warhammer
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[8], "#X#", "#X#", " X ", 'X', stickItem, '#', materialItem));
    }
}
