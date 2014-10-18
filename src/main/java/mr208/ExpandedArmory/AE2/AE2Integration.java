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
import mr208.ExpandedArmory.Materials;
import net.minecraft.item.ItemStack;
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

    public static void initAE2()
    {
        if(ExArmConfig.enableCertusQuartz) initCertus();
        if(ExArmConfig.enableNetherQuartz) initNether();
    }
    private static void initNether()
    {
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(Materials.netherQuartz, 0xD9D4CFFF));


        battleaxeQuartz = new ExArmItemMelee("battleaxe.quartz", new MeleeCompBattleaxe(Materials.netherQuartz));
        boomerangQuartz = new ExArmItemMelee("boomerang.quartz", new MeleeCompBoomerang(Materials.netherQuartz));
        flailQuartz = new ExArmItemFlail("flail.quartz", Materials.netherQuartz);
        halberdQuartz = new ExArmItemMelee("halberd.quartz", new MeleeCompHalberd(Materials.netherQuartz));
        katanaQuartz = new ExArmItemMelee("katana.quartz", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,Materials.netherQuartz));
        knifeQuartz = new ExArmItemMelee("knife.quartz", new MeleeCompKnife(Materials.netherQuartz));
        musketbayonetQuartz = new ExArmItemMusket("musketbayonet.quartz", new MeleeCompKnife(Materials.netherQuartz),knifeQuartz);
        spearQuartz = new ExArmItemMelee("spear.quartz",new MeleeCompSpear(Materials.netherQuartz));
        warhammerQuartz = new ExArmItemMelee("warhammer.quartz", new MeleeCompWarhammer(Materials.netherQuartz));
        
        
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
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(Materials.certusQuartz, 0x91CDEAFF));

        Item certus = AEApi.instance().materials().materialCertusQuartzCrystal.item();

        battleaxeCertus = new ExArmItemMelee("battleaxe.certus", new MeleeCompBattleaxe(Materials.certusQuartz));
        boomerangCertus = new ExArmItemMelee("boomerang.certus", new MeleeCompBoomerang(Materials.certusQuartz));
        flailCertus = new ExArmItemFlail("flail.certus", Materials.certusQuartz);
        halberdCertus = new ExArmItemMelee("halberd.certus", new MeleeCompHalberd(Materials.certusQuartz));
        katanaCertus = new ExArmItemMelee("katana.certus", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,Materials.certusQuartz));
        knifeCertus = new ExArmItemMelee("knife.certus", new MeleeCompKnife(Materials.certusQuartz));
        musketbayonetCertus = new ExArmItemMusket("musketbayonet.certus", new MeleeCompKnife(Materials.certusQuartz),knifeCertus);
        spearCertus = new ExArmItemMelee("spear.certus",new MeleeCompSpear(Materials.certusQuartz));
        warhammerCertus = new ExArmItemMelee("warhammer.certus", new MeleeCompWarhammer(Materials.certusQuartz));

        GameRegistry.addRecipe(new ShapedOreRecipe(battleaxeCertus, "###", "#X#", " X ", 'X', "stickWood", '#', certus));
        GameRegistry.addRecipe(new ShapedOreRecipe(boomerangCertus, "XX#", "  X", "  X", 'X', "plankWood", '#', certus));
        GameRegistry.addRecipe(new ShapedOreRecipe(flailCertus, "  O", " XO", "X #", 'X', "stickWood", 'O', Items.string, '#', certus));
        GameRegistry.addRecipe(new ShapedOreRecipe(halberdCertus, " ##", " X#", "X  ", 'X', "stickWood", '#', certus));
        GameRegistry.addRecipe(new ShapedOreRecipe(katanaCertus, "  #", " # ", "X  ", 'X', "stickWood", '#', certus));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeCertus, "#X", 'X', "stickWood", '#', certus));
        GameRegistry.addRecipe(new ShapedOreRecipe(knifeCertus, "#", "X", 'X', "stickWood", '#', certus));
        GameRegistry.addShapelessRecipe(new ItemStack(musketbayonetCertus), knifeCertus, BalkonsWeaponMod.musket);
        GameRegistry.addRecipe(new ShapedOreRecipe(spearCertus, "  #", " X ", "X  ", 'X', "stickWood", '#', certus));
        GameRegistry.addRecipe(new ShapedOreRecipe(warhammerCertus, "#X#", "#X#", " X ", 'X', "stickWood", '#', certus));
        
    }
}
