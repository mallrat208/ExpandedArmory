package com.mr208.ExpandedArmory.SimpleOres;

import alexndr.plugins.SimpleOres.SimpleOres;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.ExArmConfig;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.RegisterItems;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SimpleOreIntegration {
    
    public static Item battleaxeAdamantium;
    public static Item boomerangAdamantium;
    public static Item flailAdamantium;
    public static Item halberdAdamantium;
    public static Item katanaAdamantium;
    public static Item knifeAdamantium;
    public static Item musketbayonetAdamantium;
    public static Item spearAdamantium;
    public static Item warhammerAdamantium;

    public static Item battleaxeOnyx;
    public static Item boomerangOnyx;
    public static Item flailOnyx;
    public static Item halberdOnyx;
    public static Item katanaOnyx;
    public static Item knifeOnyx;
    public static Item musketbayonetOnyx;
    public static Item spearOnyx;
    public static Item warhammerOnyx;

    public static Item battleaxeThyrium;
    public static Item boomerangThyrium;
    public static Item flailThyrium;
    public static Item halberdThyrium;
    public static Item katanaThyrium;
    public static Item knifeThyrium;
    public static Item musketbayonetThyrium;
    public static Item spearThyrium;
    public static Item warhammerThyrium;

    public static Item battleaxeSinisite;
    public static Item boomerangSinisite;
    public static Item flailSinisite;
    public static Item halberdSinisite;
    public static Item katanaSinisite;
    public static Item knifeSinisite;
    public static Item musketbayonetSinisite;
    public static Item spearSinisite;
    public static Item warhammerSinisite;

    public static Item battleaxeMalachite;
    public static Item boomerangMalachite;
    public static Item flailMalachite;
    public static Item halberdMalachite;
    public static Item katanaMalachite;
    public static Item knifeMalachite;
    public static Item musketbayonetMalachite;
    public static Item spearMalachite;
    public static Item warhammerMalachite;

    public static Item battleaxeAshstone;
    public static Item boomerangAshstone;
    public static Item flailAshstone;
    public static Item halberdAshstone;
    public static Item katanaAshstone;
    public static Item knifeAshstone;
    public static Item musketbayonetAshstone;
    public static Item spearAshstone;
    public static Item warhammerAshstone;

    public static Item battleaxeDragonstone;
    public static Item boomerangDragonstone;
    public static Item flailDragonstone;
    public static Item halberdDragonstone;
    public static Item katanaDragonstone;
    public static Item knifeDragonstone;
    public static Item musketbayonetDragonstone;
    public static Item spearDragonstone;
    public static Item warhammerDragonstone;

    public static Item battleaxeArgonite;
    public static Item boomerangArgonite;
    public static Item flailArgonite;
    public static Item halberdArgonite;
    public static Item katanaArgonite;
    public static Item knifeArgonite;
    public static Item musketbayonetArgonite;
    public static Item spearArgonite;
    public static Item warhammerArgonite;

    public static void initSimpleMods()
    {
        if(Loader.isModLoaded("simpleores"))
        {
            if(ExArmConfig.enableAdamantium) initAdamantium();
            if(ExArmConfig.enableOnyx) initOnyx();
        }

        if(Loader.isModLoaded("fusion"))
        {
            if(ExArmConfig.enableThyrium) initThyrium();
            if(ExArmConfig.enableSinisite) initSinisite();
        }

        if(Loader.isModLoaded("netherrocks"))
        {
            if(ExArmConfig.enableMalachite) initMalachite();
            if(ExArmConfig.enableAshstone) initAshstone();
            if(ExArmConfig.enableDragonstone) initDragonstone();
            if(ExArmConfig.enableArgonite) initArgonite();

        }
    }

    public static void initAdamantium()
    {
        Item.ToolMaterial adamantiumMaterial = SimpleOres.toolAdamantium;
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(adamantiumMaterial, 0x158020FF));

        Item ingotAdamantium = GameRegistry.findItem("simpleores","adamantium_ingot");

        if(adamantiumMaterial.getRepairItemStack()==null)
        {
            adamantiumMaterial.setRepairItem(new ItemStack(ingotAdamantium));
        }
        Item[] weaponArray = {battleaxeAdamantium, boomerangAdamantium, flailAdamantium, halberdAdamantium, katanaAdamantium, knifeAdamantium, musketbayonetAdamantium, spearAdamantium, warhammerAdamantium};

        RegisterItems.RegisterRegularWeapon(weaponArray,"adamantium",adamantiumMaterial,"ingotAdamantium");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotAdamantium");

    }

    public static void initOnyx()
    {
        Item.ToolMaterial onyxMaterial = SimpleOres.toolOnyx;
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(onyxMaterial, 0x363636FF));

        Item ingotOnyx = GameRegistry.findItem("simpleores","onyx_gem");

        if(onyxMaterial.getRepairItemStack()==null)
        {
            onyxMaterial.setRepairItem(new ItemStack(ingotOnyx));
        }
        Item[] weaponArray = {battleaxeOnyx, boomerangOnyx, flailOnyx, halberdOnyx, katanaOnyx, knifeOnyx, musketbayonetOnyx, spearOnyx, warhammerOnyx};

        RegisterItems.RegisterRegularWeapon(weaponArray,"onyx",onyxMaterial,"gemOnyx");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","gemOnyx");  
        
    }
    
    public static void initThyrium()
    {
        Item.ToolMaterial thyriumMaterial = Item.ToolMaterial.valueOf("THYRIUM");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(thyriumMaterial, 0x64d6b7FF));

        Item ingotThyrium = GameRegistry.findItem("fusion","thyrium_ingot");

        if(thyriumMaterial.getRepairItemStack()==null)
        {
            thyriumMaterial.setRepairItem(new ItemStack(ingotThyrium));
        }
        Item[] weaponArray = {battleaxeThyrium, boomerangThyrium, flailThyrium, halberdThyrium, katanaThyrium, knifeThyrium, musketbayonetThyrium, spearThyrium, warhammerThyrium};

        RegisterItems.RegisterRegularWeapon(weaponArray,"thyrium",thyriumMaterial,"ingotThyrium");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotThyrium");
    }

    public static void initSinisite()
    {
        Item.ToolMaterial sinisiteMaterial = Item.ToolMaterial.valueOf("SINISITE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(sinisiteMaterial, 0x171770FF));

        Item ingotSinisite = GameRegistry.findItem("fusion","sinisite_ingot");

        if(sinisiteMaterial.getRepairItemStack()==null)
        {
            sinisiteMaterial.setRepairItem(new ItemStack(ingotSinisite));
        }
        Item[] weaponArray = {battleaxeSinisite, boomerangSinisite, flailSinisite, halberdSinisite, katanaSinisite, knifeSinisite, musketbayonetSinisite, spearSinisite, warhammerSinisite};

        RegisterItems.RegisterRegularWeapon(weaponArray,"sinisite",sinisiteMaterial,"ingotSinisite");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotSinisite");
    }

    public static void initMalachite()
    {
        Item.ToolMaterial malachiteMaterial = Item.ToolMaterial.valueOf("MALACHITE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(malachiteMaterial, 0x08ba5cFF));

        Item ingotMalachite = GameRegistry.findItem("netherrocks","malachite_ingot");

        if(malachiteMaterial.getRepairItemStack()==null)
        {
            malachiteMaterial.setRepairItem(new ItemStack(ingotMalachite));
        }
        Item[] weaponArray = {battleaxeMalachite, boomerangMalachite, flailMalachite, halberdMalachite, katanaMalachite, knifeMalachite, musketbayonetMalachite, spearMalachite, warhammerMalachite};

        RegisterItems.RegisterRegularWeapon(weaponArray,"malachite",malachiteMaterial,"ingotMalachite");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotMalachite");

    }

    public static void initAshstone()
    {
        Item.ToolMaterial ashstoneMaterial = Item.ToolMaterial.valueOf("ASHSTONE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(ashstoneMaterial, 0x7c7c7cFF));

    Item ingotAshstone = GameRegistry.findItem("netherrocks","ashstone_gem");

    if(ashstoneMaterial.getRepairItemStack()==null)
    {
        ashstoneMaterial.setRepairItem(new ItemStack(ingotAshstone));
    }
    Item[] weaponArray = {battleaxeAshstone, boomerangAshstone, flailAshstone, halberdAshstone, katanaAshstone, knifeAshstone, musketbayonetAshstone, spearAshstone, warhammerAshstone};

    RegisterItems.RegisterRegularWeapon(weaponArray,"ashstone",ashstoneMaterial,"gemAshstone");
    RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","gemAshstone");

    }

    public static void initDragonstone()
    {
        Item.ToolMaterial dragonstoneMaterial = Item.ToolMaterial.valueOf("DRAGONSTONE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(dragonstoneMaterial, 0x661714FF));

        Item ingotDragonstone = GameRegistry.findItem("netherrocks","dragonstone_gem");

        if(dragonstoneMaterial.getRepairItemStack()==null)
        {
            dragonstoneMaterial.setRepairItem(new ItemStack(ingotDragonstone));
        }
        Item[] weaponArray = {battleaxeDragonstone, boomerangDragonstone, flailDragonstone, halberdDragonstone, katanaDragonstone, knifeDragonstone, musketbayonetDragonstone, spearDragonstone, warhammerDragonstone};

        RegisterItems.RegisterRegularWeapon(weaponArray,"dragonstone",dragonstoneMaterial,"gemDragonstone");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","gemDragonstone");

    }

    public static void initArgonite()
    {
        Item.ToolMaterial argoniteMaterial = Item.ToolMaterial.valueOf("ARGONITE");
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(argoniteMaterial, 0x1b0044FF));

        Item ingotArgonite = GameRegistry.findItem("netherrocks","argonite_ingot");

        if(argoniteMaterial.getRepairItemStack()==null)
        {
            argoniteMaterial.setRepairItem(new ItemStack(ingotArgonite));
        }
        Item[] weaponArray = {battleaxeArgonite, boomerangArgonite, flailArgonite, halberdArgonite, katanaArgonite, knifeArgonite, musketbayonetArgonite, spearArgonite, warhammerArgonite};

        RegisterItems.RegisterRegularWeapon(weaponArray,"argonite",argoniteMaterial,"ingotArgonite");
        RegisterItems.CreateWeaponRecipes(weaponArray,"stickWood","ingotArgonite");

    }
    
}
