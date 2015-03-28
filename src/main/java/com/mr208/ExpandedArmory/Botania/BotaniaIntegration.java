package com.mr208.ExpandedArmory.Botania;

import ckathode.weaponmod.BalkonsWeaponMod;
import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import ckathode.weaponmod.item.*;
import com.mr208.ExpandedArmory.RegisterItems;
import cpw.mods.fml.common.registry.GameRegistry;
import com.mr208.ExpandedArmory.Botania.Items.BotanicalItemFlail;
import com.mr208.ExpandedArmory.Botania.Items.BotanicalItemMelee;
import com.mr208.ExpandedArmory.Botania.Items.BotanicalItemMusket;
import com.mr208.ExpandedArmory.CustomMaterials;
import com.mr208.ExpandedArmory.ExArmConfig;
import net.minecraft.item.ItemStack;
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
        if(Item.ToolMaterial.valueOf("MANASTEEL").customCraftingMaterial==null)
        {
            Item.ToolMaterial.valueOf("MANASTEEL").setRepairItem(manasteelIS);
        }
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("battleaxe"))
        battleaxeManasteel = new BotanicalItemMelee("battleaxe.manasteel", new MeleeCompBattleaxe(BotaniaAPI.manasteelToolMaterial), "ingotManasteel").setTextureName("exparmory:manasteel/battleaxe.manasteel");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("boomerang"))
        boomerangManasteel = new BotanicalItemMelee("boomerang.manasteel", new MeleeCompBoomerang(BotaniaAPI.manasteelToolMaterial), "ingotManasteel").setTextureName("exparmory:manasteel/boomerang.manasteel");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("flail"))
        flailManasteel = new BotanicalItemFlail("flail.manasteel", BotaniaAPI.manasteelToolMaterial, "ingotManasteel").setTextureName("exparmory:manasteel/flail.manasteel");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("halberd"))
        halberdManasteel = new BotanicalItemMelee("halberd.manasteel", new MeleeCompHalberd(BotaniaAPI.manasteelToolMaterial), "ingotManasteel").setTextureName("exparmory:manasteel/halberd.manasteel");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("katana"))
        katanaManasteel = new BotanicalItemMelee("katana.manasteel", new MeleeComponent(MeleeComponent.MeleeSpecs.KATANA,BotaniaAPI.manasteelToolMaterial), "ingotManasteel").setTextureName("exparmory:manasteel/katana.manasteel");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        knifeManasteel = new BotanicalItemMelee("knife.manasteel", new MeleeCompKnife(BotaniaAPI.manasteelToolMaterial), "ingotManasteel").setTextureName("exparmory:manasteel/knife.manasteel");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("musket")&&BalkonsWeaponMod.instance.modConfig.isEnabled("knife"))
        musketbayonetManasteel = new BotanicalItemMusket("musketbayonet.manasteel", new MeleeCompKnife(BotaniaAPI.manasteelToolMaterial),knifeManasteel, "ingotManasteel").setTextureName("exparmory:manasteel/musketbayonet.manasteel");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("spear"))
        spearManasteel = new BotanicalItemMelee("spear.manasteel", new MeleeCompSpear(BotaniaAPI.manasteelToolMaterial), "ingotManasteel").setTextureName("exparmory:manasteel/spear.manasteel");
        if(BalkonsWeaponMod.instance.modConfig.isEnabled("warhammer"))
        warhammerManasteel = new BotanicalItemMelee("warhammer.manasteel", new MeleeCompWarhammer(BotaniaAPI.manasteelToolMaterial), "ingotManasteel").setTextureName("exparmory:manasteel/warhammer.manasteel");

        Item[] weaponArray = {battleaxeManasteel, boomerangManasteel, flailManasteel, halberdManasteel, katanaManasteel, knifeManasteel, musketbayonetManasteel, spearManasteel, warhammerManasteel};
        RegisterItems.CreateWeaponRecipes(weaponArray,"livingwoodTwig","ingotManasteel");

    }
}
