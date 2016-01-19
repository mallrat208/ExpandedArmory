package com.mr208.ExpandedArmory.AE2;

import appeng.api.AEApi;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import com.mr208.ExpandedArmory.RegisterItems;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class AE2Integration {

    public static Item battleaxeCertus;
    public static Item boomerangCertus;
    public static Item flailCertus;
    public static Item halberdCertus;
    public static Item katanaCertus;
    public static Item knifeCertus;
    public static Item musketbayonetCertus;
    public static Item spearCertus;
    public static Item warhammerCertus;

    public static Item battleaxeQuartz;
    public static Item boomerangQuartz;
    public static Item flailQuartz;
    public static Item halberdQuartz;
    public static Item katanaQuartz;
    public static Item knifeQuartz;
    public static Item musketbayonetQuartz;
    public static Item spearQuartz;
    public static Item warhammerQuartz;
    public static Item.ToolMaterial netherQuartz;
    public static Item.ToolMaterial certusQuartz;

    public static void preInit()
    {

    }
    public static void initAE2()
    {
        if(ExArmConfig.enableCertusQuartz) initCertus();
        if(ExArmConfig.enableNetherQuartz) initNether();

    }
    private static void initNether()
    {
        ItemStack quartzIS = new ItemStack(Items.quartz);
        netherQuartz = EnumHelper.addToolMaterial("NETHER_QUARTZ",
                Item.ToolMaterial.IRON.getHarvestLevel(),
                Item.ToolMaterial.IRON.getMaxUses(),
                Item.ToolMaterial.IRON.getEfficiencyOnProperMaterial(),
                Item.ToolMaterial.IRON.getDamageVsEntity(),
                Item.ToolMaterial.IRON.getEnchantability());
        netherQuartz.setRepairItem(quartzIS);
        OreDictionary.registerOre("quartzNether",Items.quartz);
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(netherQuartz, 0xBFB8AEFF));
        //MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(netherQuartz, 0xD9D4CFFF));

        Item[] weaponArray = {battleaxeQuartz, boomerangQuartz, flailQuartz, halberdQuartz, katanaQuartz, knifeQuartz, musketbayonetQuartz, spearQuartz, warhammerQuartz};
        RegisterItems.RegisterRegularWeapon(weaponArray, "quartz",netherQuartz,"quartzNether");
        RegisterItems.CreateWeaponRecipes(weaponArray, "stickWood", "quartzNether");
    }

    private static void initCertus()
    {
        ItemStack certusIS = AEApi.instance().materials().materialCertusQuartzCrystal.stack(1);
        certusQuartz = EnumHelper.addToolMaterial("CERTUS_QUARTZ",
                Item.ToolMaterial.IRON.getHarvestLevel(),
                Item.ToolMaterial.IRON.getMaxUses(),
                Item.ToolMaterial.IRON.getEfficiencyOnProperMaterial(),
                Item.ToolMaterial.IRON.getDamageVsEntity(),
                Item.ToolMaterial.IRON.getEnchantability());
        certusQuartz.setRepairItem(certusIS);
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(certusQuartz, 0xADC6EEFF));
        //MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(certusQuartz, 0x91CDEAFF));

        OreDictionary.registerOre("quartzCertus",certusIS);

        Item[] weaponArray = {battleaxeCertus, boomerangCertus, flailCertus, halberdCertus, katanaCertus, knifeCertus, musketbayonetCertus, spearCertus, warhammerCertus};
        RegisterItems.RegisterRegularWeapon(weaponArray, "certus",certusQuartz,"quartzCertus");
        RegisterItems.CreateWeaponRecipes(weaponArray, "stickWood", "quartzCertus");

    }
}
