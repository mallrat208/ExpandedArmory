package mr208.WeaponVault.Thaumcraft;

import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


import mr208.WeaponVault.CustomMaterials;
import mr208.WeaponVault.WVConfig;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import mr208.WeaponVault.Thaumcraft.Items.ThaumicItemFlail;
import mr208.WeaponVault.Thaumcraft.Items.ThaumicItemMelee;
import mr208.WeaponVault.Thaumcraft.Items.ThaumicItemMusket;
import mr208.WeaponVault.Thaumcraft.Items.VoidItemFlail;
import mr208.WeaponVault.Thaumcraft.Items.VoidItemMelee;
import mr208.WeaponVault.Thaumcraft.Items.VoidItemMusket;

import net.minecraftforge.oredict.ShapedOreRecipe;

import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.item.*;

import thaumcraft.api.ThaumcraftApi;

public class ThaumcraftIntegration {

    public static Item battleaxeThaumium;
    public static Item boomerangThaumium;
    public static Item flailThaumium;
    public static Item halberdThaumium;
    public static Item katanaThaumium;
    public static Item knifeThaumium;
    public static Item musketbayonetThaumium;
    public static Item spearThaumium;
    public static Item warhammerThaumium;

    public static Item battleaxeVoidMetal;
    public static Item boomerangVoidMetal;
    public static Item flailVoidMetal;
    public static Item halberdVoidMetal;
    public static Item katanaVoidMetal;
    public static Item knifeVoidMetal;
    public static Item musketbayonetVoidMetal;
    public static Item spearVoidMetal;
    public static Item warhammerVoidMetal;

    public static void initThaumcraft() 
    {
    if(WVConfig.enableThaumium) initThaumium();
    if(WVConfig.enableVoidMetal) initVoidMetal();
    }

    private static void initVoidMetal()
    {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(ThaumcraftApi.toolMatVoid, 0x2F1346FF));

        battleaxeVoidMetal = new VoidItemMelee("battleaxe.void", new MeleeCompBattleaxe(ThaumcraftApi.toolMatVoid), EnumRarity.uncommon);
        boomerangVoidMetal = new VoidItemMelee("boomerang.void", new MeleeCompBoomerang(ThaumcraftApi.toolMatVoid),EnumRarity.uncommon);
        flailVoidMetal = new VoidItemFlail("flail.void", ThaumcraftApi.toolMatVoid,EnumRarity.uncommon);
        halberdVoidMetal = new VoidItemMelee("halberd.void", new MeleeCompHalberd(ThaumcraftApi.toolMatVoid),EnumRarity.uncommon);
        katanaVoidMetal = new VoidItemMelee("katana.void", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, ThaumcraftApi.toolMatVoid),EnumRarity.uncommon);
        knifeVoidMetal = new VoidItemMelee("knife.void", new MeleeCompKnife(ThaumcraftApi.toolMatVoid),EnumRarity.uncommon);
        musketbayonetVoidMetal = new VoidItemMusket("musketbayonet.void", new MeleeCompKnife(ThaumcraftApi.toolMatVoid), knifeVoidMetal,EnumRarity.uncommon);
        spearVoidMetal = new VoidItemMelee("spear.void", new MeleeCompSpear(ThaumcraftApi.toolMatVoid),EnumRarity.uncommon);
        warhammerVoidMetal = new VoidItemMelee("warhammer.void", new MeleeCompWarhammer(ThaumcraftApi.toolMatVoid),EnumRarity.uncommon);

        GameRegistry.addRecipe(new ShapedOreRecipe(battleaxeVoidMetal, "###", "#X#", " X ", 'X', "stickWood", '#', "ingotVoid"));
        GameRegistry.addRecipe(new ShapedOreRecipe(boomerangVoidMetal, "XX#", "  X", "  X", 'X', "plankWood", '#', "ingotVoid"));
        GameRegistry.addRecipe(new ShapedOreRecipe(flailVoidMetal, "  O", " XO", "X #", 'X', "stickWood", 'O', Items.string, '#', "ingotVoid"));
        GameRegistry.addRecipe(new ShapedOreRecipe(halberdVoidMetal, " ##", " X#", "X  ", 'X', "stickWood", '#', "ingotVoid"));
        GameRegistry.addRecipe(new ShapedOreRecipe(katanaVoidMetal, "  #", " # ", "X  ", 'X', "stickWood", '#', "ingotVoid"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeVoidMetal, "#X", 'X', "stickWood", '#', "ingotVoid"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeVoidMetal, "#", "X", 'X', "stickWood", '#', "ingotVoid"));
        GameRegistry.addShapelessRecipe(new ItemStack(musketbayonetVoidMetal), knifeVoidMetal, BalkonsWeaponMod.musket);
        GameRegistry.addRecipe(new ShapedOreRecipe(spearVoidMetal, "  #", " X ", "X  ", 'X', "stickWood", '#', "ingotVoid"));
        GameRegistry.addRecipe(new ShapedOreRecipe(warhammerVoidMetal, "#X#", "#X#", " X ", 'X', "stickWood", '#', "ingotVoid"));
    }
    private static void initThaumium()
    {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(ThaumcraftApi.toolMatThaumium, 0x46367dFF));

        battleaxeThaumium = new ThaumicItemMelee("battleaxe.thaumium", new MeleeCompBattleaxe(ThaumcraftApi.toolMatThaumium),EnumRarity.uncommon);
        boomerangThaumium = new ThaumicItemMelee("boomerang.thaumium", new MeleeCompBoomerang(ThaumcraftApi.toolMatThaumium),EnumRarity.uncommon);
        flailThaumium = new ThaumicItemFlail("flail.thaumium", ThaumcraftApi.toolMatThaumium,EnumRarity.uncommon);
        halberdThaumium = new ThaumicItemMelee("halberd.thaumium", new MeleeCompHalberd(ThaumcraftApi.toolMatThaumium),EnumRarity.uncommon);
        katanaThaumium = new ThaumicItemMelee("katana.thaumium", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, ThaumcraftApi.toolMatThaumium),EnumRarity.uncommon);
        knifeThaumium = new ThaumicItemMelee("knife.thaumium", new MeleeCompKnife(ThaumcraftApi.toolMatThaumium),EnumRarity.uncommon);
        musketbayonetThaumium = new ThaumicItemMusket("musketbayonet.thaumium", new MeleeCompKnife(ThaumcraftApi.toolMatThaumium), knifeThaumium,EnumRarity.uncommon);
        spearThaumium = new ThaumicItemMelee("spear.thaumium", new MeleeCompSpear(ThaumcraftApi.toolMatThaumium),EnumRarity.uncommon);
        warhammerThaumium = new ThaumicItemMelee("warhammer.thaumium", new MeleeCompWarhammer(ThaumcraftApi.toolMatThaumium),EnumRarity.uncommon);

        GameRegistry.addRecipe(new ShapedOreRecipe(battleaxeThaumium, "###", "#X#", " X ", 'X', "stickWood", '#', "ingotThaumium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(boomerangThaumium, "XX#", "  X", "  X", 'X', "plankWood", '#', "ingotThaumium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(flailThaumium, "  O", " XO", "X #", 'X', "stickWood", 'O', Items.string, '#', "ingotThaumium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(halberdThaumium, " ##", " X#", "X  ", 'X', "stickWood", '#', "ingotThaumium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(katanaThaumium, "  #", " # ", "X  ", 'X', "stickWood", '#', "ingotThaumium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeThaumium, "#X", 'X', "stickWood", '#', "ingotThaumium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeThaumium, "#", "X", 'X', "stickWood", '#', "ingotThaumium"));
        GameRegistry.addShapelessRecipe(new ItemStack(musketbayonetThaumium), knifeThaumium, BalkonsWeaponMod.musket);
        GameRegistry.addRecipe(new ShapedOreRecipe(spearThaumium, "  #", " X ", "X  ", 'X', "stickWood", '#', "ingotThaumium"));
        GameRegistry.addRecipe(new ShapedOreRecipe(warhammerThaumium, "#X#", "#X#", " X ", 'X', "stickWood", '#', "ingotThaumium"));
    }
    
}
