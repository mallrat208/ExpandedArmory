package mr208.ExpandedArmory.AE2;

import appeng.api.AEApi;
import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import ckathode.weaponmod.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import mr208.ExpandedArmory.CustomMaterials;
import mr208.ExpandedArmory.ExArmConfig;
import mr208.ExpandedArmory.Items.ExArmItemFlail;
import mr208.ExpandedArmory.Items.ExArmItemMelee;
import mr208.ExpandedArmory.Items.ExArmItemMusket;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;


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
        netherQuartz.setRepairItem(new ItemStack(Items.quartz));
        
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(netherQuartz, 0xBFB8AEFF));
        //MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(netherQuartz, 0xD9D4CFFF));

        battleaxeQuartz = new ExArmItemMelee("battleaxe.quartz", new MeleeCompBattleaxe(netherQuartz));
        boomerangQuartz = new ExArmItemMelee("boomerang.quartz", new MeleeCompBoomerang(netherQuartz));
        flailQuartz = new ExArmItemFlail("flail.quartz", netherQuartz);
        halberdQuartz = new ExArmItemMelee("halberd.quartz", new MeleeCompHalberd(netherQuartz));
        katanaQuartz = new ExArmItemMelee("katana.quartz", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,netherQuartz));
        knifeQuartz = new ExArmItemMelee("knife.quartz", new MeleeCompKnife(netherQuartz));
        musketbayonetQuartz = new ExArmItemMusket("musketbayonet.quartz", new MeleeCompKnife(netherQuartz),knifeQuartz);
        spearQuartz = new ExArmItemMelee("spear.quartz",new MeleeCompSpear(netherQuartz));
        warhammerQuartz = new ExArmItemMelee("warhammer.quartz", new MeleeCompWarhammer(netherQuartz));
        
        
        GameRegistry.addRecipe(new ShapedOreRecipe(battleaxeQuartz, "###", "#X#", " X ", 'X', "stickWood", '#', Items.quartz));
        GameRegistry.addRecipe(new ShapedOreRecipe(boomerangQuartz, "XX#", "  X", "  X", 'X', "plankWood", '#', Items.quartz));
        GameRegistry.addRecipe(new ShapedOreRecipe(flailQuartz, "  O", " XO", "X #", 'X', "stickWood", 'O', Items.string, '#', Items.quartz));
        GameRegistry.addRecipe(new ShapedOreRecipe(halberdQuartz, " ##", " X#", "X  ", 'X', "stickWood", '#', Items.quartz));
        GameRegistry.addRecipe(new ShapedOreRecipe(katanaQuartz, "  #", " # ", "X  ", 'X', "stickWood", '#', Items.quartz));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeQuartz, "#X", 'X', "stickWood", '#', Items.quartz));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeQuartz, "#", "X", 'X', "stickWood", '#', Items.quartz));
        GameRegistry.addShapelessRecipe(new ItemStack(musketbayonetQuartz), knifeQuartz, BalkonsWeaponMod.musket);
        GameRegistry.addRecipe(new ShapedOreRecipe(spearQuartz, "  #", " X ", "X  ", 'X', "stickWood", '#', Items.quartz));
        GameRegistry.addRecipe(new ShapedOreRecipe(warhammerQuartz, "#X#", "#X#", " X ", 'X', "stickWood", '#', Items.quartz));
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

        battleaxeCertus = new ExArmItemMelee("battleaxe.certus", new MeleeCompBattleaxe(certusQuartz));
        boomerangCertus = new ExArmItemMelee("boomerang.certus", new MeleeCompBoomerang(certusQuartz));
        flailCertus = new ExArmItemFlail("flail.certus", certusQuartz);
        halberdCertus = new ExArmItemMelee("halberd.certus", new MeleeCompHalberd(certusQuartz));
        katanaCertus = new ExArmItemMelee("katana.certus", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,certusQuartz));
        knifeCertus = new ExArmItemMelee("knife.certus", new MeleeCompKnife(certusQuartz));
        musketbayonetCertus = new ExArmItemMusket("musketbayonet.certus", new MeleeCompKnife(certusQuartz),knifeCertus);
        spearCertus = new ExArmItemMelee("spear.certus",new MeleeCompSpear(certusQuartz));
        warhammerCertus = new ExArmItemMelee("warhammer.certus", new MeleeCompWarhammer(certusQuartz));

        GameRegistry.addRecipe(new ShapedOreRecipe(battleaxeCertus, "###", "#X#", " X ", 'X', "stickWood", '#', certusIS));
        GameRegistry.addRecipe(new ShapedOreRecipe(boomerangCertus, "XX#", "  X", "  X", 'X', "plankWood", '#', certusIS));
        GameRegistry.addRecipe(new ShapedOreRecipe(flailCertus, "  O", " XO", "X #", 'X', "stickWood", 'O', Items.string, '#', certusIS));
        GameRegistry.addRecipe(new ShapedOreRecipe(halberdCertus, " ##", " X#", "X  ", 'X', "stickWood", '#', certusIS));
        GameRegistry.addRecipe(new ShapedOreRecipe(katanaCertus, "  #", " # ", "X  ", 'X', "stickWood", '#', certusIS));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeCertus, "#X", 'X', "stickWood", '#', certusIS));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeCertus, "#", "X", 'X', "stickWood", '#', certusIS));
        GameRegistry.addShapelessRecipe(new ItemStack(musketbayonetCertus), knifeCertus, BalkonsWeaponMod.musket);
        GameRegistry.addRecipe(new ShapedOreRecipe(spearCertus, "  #", " X ", "X  ", 'X', "stickWood", '#', certusIS));
        GameRegistry.addRecipe(new ShapedOreRecipe(warhammerCertus, "#X#", "#X#", " X ", 'X', "stickWood", '#', certusIS));
        
    }
}
