package com.mr208.ExpandedArmory.Thaumcraft;

import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.Thaumcraft.ThaumicItemMelee;
import com.mr208.ExpandedArmory.RegisterItems;
import cpw.mods.fml.common.registry.GameRegistry;


import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


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
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
        battleaxeVoidMetal = new ThaumicItemMelee("battleaxe.void", new MeleeCompBattleaxe(ThaumcraftApi.toolMatVoid),"ingotVoid", EnumRarity.uncommon).setTextureName("exparmory:void/battleaxe.void");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
        boomerangVoidMetal = new ThaumicItemMelee("boomerang.void", new MeleeCompBoomerang(ThaumcraftApi.toolMatVoid),"ingotVoid", EnumRarity.uncommon).setTextureName("exparmory:void/boomerang.void");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
        flailVoidMetal = new VoidItemFlail("flail.void", ThaumcraftApi.toolMatVoid, EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/flail.void");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
        halberdVoidMetal = new ThaumicItemMelee("halberd.void", new MeleeCompHalberd(ThaumcraftApi.toolMatVoid),"ingotVoid",EnumRarity.uncommon).setTextureName("exparmory:void/halberd.void");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
        katanaVoidMetal = new ThaumicItemMelee("katana.void", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, ThaumcraftApi.toolMatVoid),"ingotVoid", EnumRarity.uncommon).setTextureName("exparmory:void/katana.void");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        knifeVoidMetal = new ThaumicItemMelee("knife.void", new MeleeCompKnife(ThaumcraftApi.toolMatVoid),"ingotVoid", EnumRarity.uncommon).setTextureName("exparmory:void/knife.void");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("musket")&&BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        musketbayonetVoidMetal = new VoidItemMusket("musketbayonet.void", new MeleeCompKnife(ThaumcraftApi.toolMatVoid), knifeVoidMetal, EnumRarity.uncommon,"ingotVoid").setTextureName("exparmory:void/musketbayonet.void");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
        spearVoidMetal = new ThaumicItemMelee("spear.void", new MeleeCompSpear(ThaumcraftApi.toolMatVoid),"ingotVoid", EnumRarity.uncommon).setTextureName("exparmory:void/spear.void");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
        warhammerVoidMetal = new ThaumicItemMelee("warhammer.void", new MeleeCompWarhammer(ThaumcraftApi.toolMatVoid),"ingotVoid", EnumRarity.uncommon).setTextureName("exparmory:void/warhammer.void");

        Item[] weaponArray = {battleaxeVoidMetal, boomerangVoidMetal, flailVoidMetal, halberdVoidMetal, katanaVoidMetal, knifeVoidMetal, musketbayonetVoidMetal, spearVoidMetal, warhammerVoidMetal};
        RegisterItems.CreateWeaponRecipes(weaponArray, "stickWood", "ingotVoid");
    }
    private static void initThaumium()
    {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(ThaumcraftApi.toolMatThaumium, 0x46367dFF));
        Item thaumItem = GameRegistry.findItem("Thaumcraft", "ItemResource");

        if (ThaumcraftApi.toolMatThaumium.customCraftingMaterial==null)
        {
            ThaumcraftApi.toolMatThaumium.setRepairItem(new ItemStack(thaumItem, 1, 2));
        }
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
        battleaxeThaumium = new ThaumicItemMelee("battleaxe.thaumium", new MeleeCompBattleaxe(ThaumcraftApi.toolMatThaumium),"ingotThaumium",EnumRarity.uncommon).setTextureName("exparmory:thaumium/battleaxe.thaumium");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
        boomerangThaumium = new ThaumicItemMelee("boomerang.thaumium", new MeleeCompBoomerang(ThaumcraftApi.toolMatThaumium),"ingotThaumium", EnumRarity.uncommon).setTextureName("exparmory:thaumium/boomerang.thaumium");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
        flailThaumium = new ThaumicItemFlail("flail.thaumium", ThaumcraftApi.toolMatThaumium, EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/flail.thaumium");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
        halberdThaumium = new ThaumicItemMelee("halberd.thaumium", new MeleeCompHalberd(ThaumcraftApi.toolMatThaumium),"ingotThaumium", EnumRarity.uncommon).setTextureName("exparmory:thaumium/halberd.thaumium");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
        katanaThaumium = new ThaumicItemMelee("katana.thaumium", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA, ThaumcraftApi.toolMatThaumium),"ingotThaumium", EnumRarity.uncommon).setTextureName("exparmory:thaumium/katana.thaumium");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        knifeThaumium = new ThaumicItemMelee("knife.thaumium", new MeleeCompKnife(ThaumcraftApi.toolMatThaumium),"ingotThaumium", EnumRarity.uncommon).setTextureName("exparmory:thaumium/knife.thaumium");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("musket")&&BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        musketbayonetThaumium = new ThaumicItemMusket("musketbayonet.thaumium", new MeleeCompKnife(ThaumcraftApi.toolMatThaumium), knifeThaumium, EnumRarity.uncommon,"ingotThaumium").setTextureName("exparmory:thaumium/musketbayonet.thaumium");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
        spearThaumium = new ThaumicItemMelee("spear.thaumium", new MeleeCompSpear(ThaumcraftApi.toolMatThaumium),"ingotThaumium", EnumRarity.uncommon).setTextureName("exparmory:thaumium/spear.thaumium");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
        warhammerThaumium = new ThaumicItemMelee("warhammer.thaumium", new MeleeCompWarhammer(ThaumcraftApi.toolMatThaumium),"ingotThaumium", EnumRarity.uncommon).setTextureName("exparmory:thaumium/warhammer.thaumium");

        Item[] weaponArray = {battleaxeThaumium, boomerangThaumium, flailThaumium, halberdThaumium, katanaThaumium, knifeThaumium, musketbayonetThaumium, spearThaumium, warhammerThaumium};
        RegisterItems.CreateWeaponRecipes(weaponArray, "stickWood", "ingotThaumium");
    }
    
}
