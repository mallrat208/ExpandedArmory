package mr208.WeaponVault.AE2;

import appeng.api.AEApi;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import ckathode.weaponmod.item.*;
import mr208.WeaponVault.CustomMaterials;
import mr208.WeaponVault.Items.WVItemFlail;
import mr208.WeaponVault.Items.WVItemMelee;
import mr208.WeaponVault.Items.WVItemMusket;
import mr208.WeaponVault.WVConfig;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import mr208.WeaponVault.Materials;


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
        if(WVConfig.enableCertusQuartz) initCertus();
        if(WVConfig.enableNetherQuartz) initNether();
    }
    private static void initNether()
    {
        battleaxeQuartz = new WVItemMelee("battleaxe.quartz", new MeleeCompBattleaxe(Materials.netherQuartz));
        boomerangQuartz = new WVItemMelee("boomerang.quartz", new MeleeCompBoomerang(Materials.netherQuartz));
        flailQuartz = new WVItemFlail("flail.quartz", Materials.netherQuartz);
        halberdQuartz = new WVItemMelee("halberd.quartz", new MeleeCompHalberd(Materials.netherQuartz));
        katanaQuartz = new WVItemMelee("katana.quartz", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,Materials.netherQuartz));
        knifeQuartz = new WVItemMelee("knife.quartz", new MeleeCompKnife(Materials.netherQuartz));
        musketbayonetQuartz = new WVItemMusket("musketbayonet.quartz", new MeleeCompKnife(Materials.netherQuartz),knifeQuartz);
        spearQuartz = new WVItemMelee("spear.quartz",new MeleeCompSpear(Materials.netherQuartz));
        warhammerQuartz = new WVItemMelee("warhammer.quartz", new MeleeCompWarhammer(Materials.netherQuartz));
    }

    private static void initCertus()
    {
        battleaxeCertus = new WVItemMelee("battleaxe.certus", new MeleeCompBattleaxe(Materials.certusQuartz));
        boomerangCertus = new WVItemMelee("boomerang.certus", new MeleeCompBoomerang(Materials.certusQuartz));
        flailCertus = new WVItemFlail("flail.certus", Materials.certusQuartz);
        halberdCertus = new WVItemMelee("halberd.certus", new MeleeCompHalberd(Materials.certusQuartz));
        katanaCertus = new WVItemMelee("katana.certus", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,Materials.certusQuartz));
        knifeCertus = new WVItemMelee("knife.certus", new MeleeCompKnife(Materials.certusQuartz));
        musketbayonetCertus = new WVItemMusket("musketbayonet.certus", new MeleeCompKnife(Materials.certusQuartz),knifeCertus);
        spearCertus = new WVItemMelee("spear.certus",new MeleeCompSpear(Materials.certusQuartz));
        warhammerCertus = new WVItemMelee("warhammer.certus", new MeleeCompWarhammer(Materials.certusQuartz));
    }
}
