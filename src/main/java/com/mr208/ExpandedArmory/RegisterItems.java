package com.mr208.ExpandedArmory;


import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.item.*;
import com.mr208.ExpandedArmory.Items.ExArmItemFlail;
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;
import com.mr208.ExpandedArmory.Items.ExArmItemMusket;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;


public class RegisterItems {
    
    public static void RegisterRegularWeapon(Item[] weapons,String itemName, Item.ToolMaterial material,String repairItem)
    {
        weapons[0] = new ExArmItemMelee("battleaxe." + itemName, new MeleeCompBattleaxe(material),repairItem).setTextureName("exparmory:"+itemName+"/battleaxe."+itemName);
        weapons[1] = new ExArmItemMelee("boomerang." + itemName, new MeleeCompBoomerang(material),repairItem).setTextureName("exparmory:"+itemName+"/boomerang."+itemName);
        weapons[2] = new ExArmItemFlail("flail." + itemName,material,repairItem).setTextureName("exparmory:"+itemName+"/flail."+itemName);
        weapons[3] = new ExArmItemMelee("halberd." + itemName,new MeleeCompHalberd(material),repairItem).setTextureName("exparmory:"+itemName+"/halberd."+itemName);
        weapons[4] = new ExArmItemMelee("katana." + itemName, new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,material),repairItem).setTextureName("exparmory:"+itemName+"/katana."+itemName);
        weapons[5] = new ExArmItemMelee("knife." + itemName, new MeleeCompKnife(material),repairItem).setTextureName("exparmory:"+itemName+"/knife."+itemName);
        weapons[6] = new ExArmItemMusket("musketbayonet." + itemName, new MeleeCompKnife(material),weapons[5],repairItem).setTextureName("exparmory:"+itemName+"/musketbayonet."+itemName);
        weapons[7] = new ExArmItemMelee("spear." + itemName, new MeleeCompSpear(material),repairItem).setTextureName("exparmory:"+itemName+"/spear."+itemName);
        weapons[8] = new ExArmItemMelee("warhammer." + itemName, new MeleeCompWarhammer(material),repairItem).setTextureName("exparmory:"+itemName+"/warhammer."+itemName);
    }


    
    public static void CreateWeaponRecipes(Item[] weapons, String stickItem, String materialItem)
    {
        //BattleAxe
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[0], "###", "#X#", " X ", 'X', stickItem, '#', materialItem));
        //Boomerang
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[1], "XX#", "  X", "  X", 'X', "plankWood", '#', materialItem));
        //Flail
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[2], "  O", " XO", "X #", 'X', stickItem, 'O', net.minecraft.init.Items.string, '#', materialItem));
        //Halberd
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[3], " ##", " X#", "X  ", 'X', stickItem, '#', materialItem));
        //Katana
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[4], "  #", " # ", "X  ", 'X', stickItem, '#', materialItem));
        //Knife
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[5], "#X", 'X', stickItem, '#', materialItem));
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[5], "#", "X", 'X', stickItem, '#', materialItem));
        //Musket with Bayonet
        GameRegistry.addShapelessRecipe(new ItemStack(weapons[6]), weapons[5], BalkonsWeaponMod.musket);
        //Spear
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[7], "  #", " X ", "X  ", 'X', stickItem, '#', materialItem));
        //Warhammer
        GameRegistry.addRecipe(new ShapedOreRecipe(weapons[8], "#X#", "#X#", " X ", 'X', stickItem, '#', materialItem));
    }
}
