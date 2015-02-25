package com.mr208.ExpandedArmory.Botania;

import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import ckathode.weaponmod.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import com.mr208.ExpandedArmory.Botania.Items.BotanicalItemFlail;
import com.mr208.ExpandedArmory.Botania.Items.BotanicalItemMelee;
import com.mr208.ExpandedArmory.Botania.Items.BotanicalItemMusket;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import vazkii.botania.api.BotaniaAPI;
import net.minecraft.item.Item;
import vazkii.botania.common.item.ModItems;

public class BotaniaIntegration {

    public static Item battleaxeManasteel;
    public static Item boomerangManasteel;
    public static Item flailManasteel;
    public static Item halberdManasteel;
    public static Item katanaManasteel;
    public static Item knifeManasteel;
    public static Item musketbayonetManasteel;
    public static Item spearManasteel;
    public static Item warhammerManasteel;

    public static void initBotania()
    {
        if(ExArmConfig.enableManaSteel) initManasteel();
    }
    private static void initManasteel()
    {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(BotaniaAPI.manasteelToolMaterial, 0x7DC3E5FF));
        ItemStack manasteelIS = new ItemStack(ModItems.manaResource,1,0);
        if(Item.ToolMaterial.valueOf("MANASTEEL").getRepairItemStack()==null)
        {
            Item.ToolMaterial.valueOf("MANASTEEL").setRepairItem(manasteelIS);
        }

        battleaxeManasteel = new BotanicalItemMelee("battleaxe.manasteel", new MeleeCompBattleaxe(BotaniaAPI.manasteelToolMaterial));
        boomerangManasteel = new BotanicalItemMelee("boomerang.manasteel", new MeleeCompBoomerang(BotaniaAPI.manasteelToolMaterial));
        flailManasteel = new BotanicalItemFlail("flail.manasteel", BotaniaAPI.manasteelToolMaterial);
        halberdManasteel = new BotanicalItemMelee("halberd.manasteel", new MeleeCompHalberd(BotaniaAPI.manasteelToolMaterial));
        katanaManasteel = new BotanicalItemMelee("katana.manasteel", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,BotaniaAPI.manasteelToolMaterial));
        knifeManasteel = new BotanicalItemMelee("knife.manasteel", new MeleeCompKnife(BotaniaAPI.manasteelToolMaterial));
        musketbayonetManasteel = new BotanicalItemMusket("musketbayonet.manasteel", new MeleeCompKnife(BotaniaAPI.manasteelToolMaterial),knifeManasteel);
        spearManasteel = new BotanicalItemMelee("spear.manasteel", new MeleeCompSpear(BotaniaAPI.manasteelToolMaterial));
        warhammerManasteel = new BotanicalItemMelee("warhammer.manasteel", new MeleeCompWarhammer(BotaniaAPI.manasteelToolMaterial));

        GameRegistry.addRecipe(new ShapedOreRecipe(battleaxeManasteel, "###", "#X#", " X ", 'X', "livingwoodTwig", '#', "ingotManasteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(boomerangManasteel, "XX#", "  X", "  X", 'X', "plankWood", '#', "ingotManasteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(flailManasteel, "  O", " XO", "X #", 'X', "livingwoodTwig", 'O', Items.string, '#', "ingotManasteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(halberdManasteel, " ##", " X#", "X  ", 'X', "livingwoodTwig", '#', "ingotManasteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(katanaManasteel, "  #", " # ", "X  ", 'X', "livingwoodTwig", '#', "ingotManasteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeManasteel, "#X", 'X', "livingwoodTwig", '#', "ingotManasteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeManasteel, "#", "X", 'X', "livingwoodTwig", '#', "ingotManasteel"));
        GameRegistry.addShapelessRecipe(new ItemStack(musketbayonetManasteel), knifeManasteel, BalkonsWeaponMod.musket);
        GameRegistry.addRecipe(new ShapedOreRecipe(spearManasteel, "  #", " X ", "X  ", 'X', "livingwoodTwig", '#', "ingotManasteel"));
        GameRegistry.addRecipe(new ShapedOreRecipe(warhammerManasteel, "#X#", "#X#", " X ", 'X', "livingwoodTwig", '#', "ingotManasteel"));

    }
}
