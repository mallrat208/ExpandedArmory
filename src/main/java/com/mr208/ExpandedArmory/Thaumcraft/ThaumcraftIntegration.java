package com.mr208.ExpandedArmory.Thaumcraft;

import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.RegisterItems;
import cpw.mods.fml.common.registry.GameRegistry;


import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import com.mr208.ExpandedArmory.Thaumcraft.Items.ThaumicItemFlail;
import com.mr208.ExpandedArmory.Thaumcraft.Items.ThaumicItemMelee;
import com.mr208.ExpandedArmory.Thaumcraft.Items.ThaumicItemMusket;
import com.mr208.ExpandedArmory.Thaumcraft.Items.VoidItemFlail;
import com.mr208.ExpandedArmory.Thaumcraft.Items.VoidItemMelee;
import com.mr208.ExpandedArmory.Thaumcraft.Items.VoidItemMusket;

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
    if(ExArmConfig.enableThaumium) initThaumium();
    if(ExArmConfig.enableVoidMetal) initVoidMetal();
    }

    private static void initVoidMetal()
    {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(ThaumcraftApi.toolMatVoid, 0x2F1346FF));
        Item voidItem = GameRegistry.findItem("Thaumcraft","ItemResource");

        if (ThaumcraftApi.toolMatVoid.getRepairItemStack()==null)
        {
            ThaumcraftApi.toolMatVoid.setRepairItem(new ItemStack(voidItem,1,16));
        }

        battleaxeVoidMetal = new VoidItemMelee("battleaxe.void", new MeleeCompBattleaxe(ThaumcraftApi.toolMatVoid), EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/battleaxe.void");
        boomerangVoidMetal = new VoidItemMelee("boomerang.void", new MeleeCompBoomerang(ThaumcraftApi.toolMatVoid), EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/boomerang.void");
        flailVoidMetal = new VoidItemFlail("flail.void", ThaumcraftApi.toolMatVoid, EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/flail.void");
        halberdVoidMetal = new VoidItemMelee("halberd.void", new MeleeCompHalberd(ThaumcraftApi.toolMatVoid), EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/halberd.void");
        katanaVoidMetal = new VoidItemMelee("katana.void", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, ThaumcraftApi.toolMatVoid), EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/katana.void");
        knifeVoidMetal = new VoidItemMelee("knife.void", new MeleeCompKnife(ThaumcraftApi.toolMatVoid), EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/knife.void");
        musketbayonetVoidMetal = new VoidItemMusket("musketbayonet.void", new MeleeCompKnife(ThaumcraftApi.toolMatVoid), knifeVoidMetal, EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/musketbayonet.void");
        spearVoidMetal = new VoidItemMelee("spear.void", new MeleeCompSpear(ThaumcraftApi.toolMatVoid), EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/spear.void");
        warhammerVoidMetal = new VoidItemMelee("warhammer.void", new MeleeCompWarhammer(ThaumcraftApi.toolMatVoid), EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/warhammer.void");

        Item[] weaponArray = {battleaxeVoidMetal, boomerangVoidMetal, flailVoidMetal, halberdVoidMetal, katanaVoidMetal, knifeVoidMetal, musketbayonetVoidMetal, spearVoidMetal, warhammerVoidMetal};
        RegisterItems.CreateWeaponRecipes(weaponArray, "stickWood", "ingotVoid");
    }
    private static void initThaumium()
    {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(ThaumcraftApi.toolMatThaumium, 0x46367dFF));
        Item thaumItem = GameRegistry.findItem("Thaumcraft", "ItemResource");

        if (ThaumcraftApi.toolMatThaumium.getRepairItemStack()==null)
        {
            ThaumcraftApi.toolMatThaumium.setRepairItem(new ItemStack(thaumItem, 1, 2));
        }

        battleaxeThaumium = new ThaumicItemMelee("battleaxe.thaumium", new MeleeCompBattleaxe(ThaumcraftApi.toolMatThaumium), EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/battleaxe.thaumium");
        boomerangThaumium = new ThaumicItemMelee("boomerang.thaumium", new MeleeCompBoomerang(ThaumcraftApi.toolMatThaumium), EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/boomerang.thaumium");
        flailThaumium = new ThaumicItemFlail("flail.thaumium", ThaumcraftApi.toolMatThaumium, EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/flail.thaumium");
        halberdThaumium = new ThaumicItemMelee("halberd.thaumium", new MeleeCompHalberd(ThaumcraftApi.toolMatThaumium), EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/halberd.thaumium");
        katanaThaumium = new ThaumicItemMelee("katana.thaumium", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, ThaumcraftApi.toolMatThaumium), EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/katana.thaumium");
        knifeThaumium = new ThaumicItemMelee("knife.thaumium", new MeleeCompKnife(ThaumcraftApi.toolMatThaumium), EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/knife.thaumium");
        musketbayonetThaumium = new ThaumicItemMusket("musketbayonet.thaumium", new MeleeCompKnife(ThaumcraftApi.toolMatThaumium), knifeThaumium, EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/musketbayonet.thaumium");
        spearThaumium = new ThaumicItemMelee("spear.thaumium", new MeleeCompSpear(ThaumcraftApi.toolMatThaumium), EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/spear.thaumium");
        warhammerThaumium = new ThaumicItemMelee("warhammer.thaumium", new MeleeCompWarhammer(ThaumcraftApi.toolMatThaumium), EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/warhammer.thaumium");

        Item[] weaponArray = {battleaxeThaumium, boomerangThaumium, flailThaumium, halberdThaumium, katanaThaumium, knifeThaumium, musketbayonetThaumium, spearThaumium, warhammerThaumium};
        RegisterItems.CreateWeaponRecipes(weaponArray, "stickWood", "ingotThaumium");
    }
    
}
