package com.mr208.ExpandedArmory.Items;


import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import ckathode.weaponmod.item.*;
import com.mr208.ExpandedArmory.CustomMaterials;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class GenericIntegration {

    public static Item ingotBronze;
    public static Item battleaxeBronze;
    public static Item boomerangBronze;
    public static Item flailBronze;
    public static Item halberdBronze;
    public static Item katanaBronze;
    public static Item knifeBronze;
    public static Item musketbayonetBronze;
    public static Item spearBronze;
    public static Item warhammerBronze;

    public static Item ingotSteel;
    public static Item battleaxeSteel;
    public static Item boomerangSteel;
    public static Item flailSteel;
    public static Item halberdSteel;
    public static Item katanaSteel;
    public static Item knifeSteel;
    public static Item musketbayonetSteel;
    public static Item spearSteel;
    public static Item warhammerSteel;


    public void initGenericMetals() {


    }

    public static void initBronze() {

        Item.ToolMaterial bronzeMaterial = getBronzeMaterial();
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(bronzeMaterial,0xE3A55CFF));

        GameRegistry.registerItem(ingotBronze = new ItemIngot("ingotBronze"),"ingotBronze");

        if(bronzeMaterial.getRepairItemStack()==null)
        {
            bronzeMaterial.setRepairItem(new ItemStack(ingotBronze));
        }

        battleaxeBronze = new ExArmItemMelee("battleaxe.bronze", new MeleeCompBattleaxe(bronzeMaterial),"ingotBronze");
        boomerangBronze = new ExArmItemMelee("boomerang.bronze", new MeleeCompBoomerang(bronzeMaterial),"ingotBronze");
        flailBronze = new ExArmItemFlail("flail.bronze",bronzeMaterial,"ingotBronze");
        halberdBronze = new ExArmItemMelee("halberd.bronze",new MeleeCompHalberd(bronzeMaterial),"ingotBronze");
        katanaBronze = new ExArmItemMelee("katana.bronze", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,bronzeMaterial),"ingotBronze");
        knifeBronze = new ExArmItemMelee("knife.bronze", new MeleeCompKnife(bronzeMaterial),"ingotBronze");
        musketbayonetBronze = new ExArmItemMusket("musketbayonet.bronze", new MeleeCompKnife(bronzeMaterial),knifeBronze,"ingotBronze");
        spearBronze = new ExArmItemMelee("spear.bronze", new MeleeCompSpear(bronzeMaterial),"ingotBronze");
        warhammerBronze = new ExArmItemMelee("warhammer.bronze", new MeleeCompWarhammer(bronzeMaterial),"ingotBronze");

        GameRegistry.addRecipe(new ShapedOreRecipe(battleaxeBronze, "###", "#X#", " X ", 'X', "stickWood", '#', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(boomerangBronze, "XX#", "  X", "  X", 'X', "plankWood", '#', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(flailBronze, "  O", " XO", "X #", 'X', "stickWood", 'O', Items.string, '#', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(halberdBronze, " ##", " X#", "X  ", 'X', "stickWood", '#', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(katanaBronze, "  #", " # ", "X  ", 'X', "stickWood", '#', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeBronze, "#X", 'X', "stickWood", '#', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeBronze, "#", "X", 'X', "stickWood", '#', "ingotBronze"));
        GameRegistry.addShapelessRecipe(new ItemStack(musketbayonetBronze), knifeBronze, BalkonsWeaponMod.musket);
        GameRegistry.addRecipe(new ShapedOreRecipe(spearBronze, "  #", " X ", "X  ", 'X', "stickWood", '#', "ingotBronze"));
        GameRegistry.addRecipe(new ShapedOreRecipe(warhammerBronze, "#X#", "#X#", " X ", 'X', "stickWood", '#', "ingotBronze"));

    }


    public static void initSteel() {

        Item.ToolMaterial steelMaterial = getSteelMaterial();
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(steelMaterial,0x9d9d9dFF));

        GameRegistry.registerItem(ingotSteel = new ItemIngot("ingotSteel"),"EAingotSteel");
        if(steelMaterial.getRepairItemStack()==null)
        {
            steelMaterial.setRepairItem(new ItemStack(ingotSteel));
        }

        battleaxeSteel = new ExArmItemMelee("battleaxe.steel", new MeleeCompBattleaxe(steelMaterial),"ingotSteel");
        boomerangSteel = new ExArmItemMelee("boomerang.steel", new MeleeCompBoomerang(steelMaterial),"ingotSteel");
        flailSteel = new ExArmItemFlail("flail.steel",steelMaterial,"ingotSteel");
        halberdSteel = new ExArmItemMelee("halberd.steel",new MeleeCompHalberd(steelMaterial),"ingotSteel");
        katanaSteel = new ExArmItemMelee("katana.steel", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,steelMaterial),"ingotSteel");
        knifeSteel = new ExArmItemMelee("knife.steel", new MeleeCompKnife(steelMaterial),"ingotSteel");
        musketbayonetSteel = new ExArmItemMusket("musketbayonet.steel", new MeleeCompKnife(steelMaterial),knifeSteel,"ingotSteel");
        spearSteel = new ExArmItemMelee("spear.steel", new MeleeCompSpear(steelMaterial),"ingotSteel");
        warhammerSteel = new ExArmItemMelee("warhammer.steel", new MeleeCompWarhammer(steelMaterial),"ingotSteel");

        GameRegistry.addRecipe(new ShapedOreRecipe(battleaxeSteel, "###", "#X#", " X ", 'X', "stickWood", '#', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(boomerangSteel, "XX#", "  X", "  X", 'X', "plankWood", '#', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(flailSteel, "  O", " XO", "X #", 'X', "stickWood", 'O', Items.string, '#', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(halberdSteel, " ##", " X#", "X  ", 'X', "stickWood", '#', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(katanaSteel, "  #", " # ", "X  ", 'X', "stickWood", '#', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeSteel, "#X", 'X', "stickWood", '#', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeSteel, "#", "X", 'X', "stickWood", '#', "ingotSteel"));
        GameRegistry.addShapelessRecipe(new ItemStack(musketbayonetSteel), knifeSteel, BalkonsWeaponMod.musket);
        GameRegistry.addRecipe(new ShapedOreRecipe(spearSteel, "  #", " X ", "X  ", 'X', "stickWood", '#', "ingotSteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(warhammerSteel, "#X#", "#X#", " X ", 'X', "stickWood", '#', "ingotSteel"));

        
    }


    private static Item.ToolMaterial getBronzeMaterial() {
        if (Loader.isModLoaded("fusion")) return Item.ToolMaterial.valueOf("BRONZE");
        if (Loader.isModLoaded("ThermalFoundation")) return Item.ToolMaterial.valueOf("TF:BRONZE");
        return EnumHelper.addToolMaterial("EA:BRONZE", 2, 500, 6.0f, 2.0f, 15);
    }

    private static Item.ToolMaterial getSteelMaterial() {
        if (Loader.isModLoaded("fusion")) return Item.ToolMaterial.valueOf("STEEL");
        if (Loader.isModLoaded("Railcraft")) return Item.ToolMaterial.valueOf("RAILCRAFT_STEEL");
        return EnumHelper.addToolMaterial("EA:STEEL", 2, 500, 7.0f, 2.0f, 9);
    }
}