package com.mr208.ExpandedArmory;


import com.mr208.ExpandedArmory.Items.ItemIngot;
import com.mr208.ExpandedArmory.SimpleOres.SimpleOreIntegration;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.mr208.ExpandedArmory.AE2.AE2Integration;
import com.mr208.ExpandedArmory.Botania.BotaniaIntegration;
import com.mr208.ExpandedArmory.Items.GenericIntegration;
import com.mr208.ExpandedArmory.Thaumcraft.ThaumcraftIntegration;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;


@Mod(modid = ExArmRef.MOD_ID, name= ExArmRef.MOD_NAME, version= ExArmRef.MOD_VER, dependencies = "required-after:Forge@[10.13.2.1291,10.14);required-after:weaponmod@[v1.14.3,v1.15);after:Botania;after:appliedenergistics2;after:Thaumcraft;after:simpleores;after:fusion;after:netherrocks")
public class ExpandedArmory {

    @Mod.Instance
    public static ExpandedArmory instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        ExArmConfig.init(event.getSuggestedConfigurationFile());
        GenericIntegration.preInitGI();

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {

        //Materials.initMaterials();
        if(ExArmConfig.enableBotania && Loader.isModLoaded("Botania")) BotaniaIntegration.initBotania();
        if(ExArmConfig.enableAEWeapons && Loader.isModLoaded("appliedenergistics2")) AE2Integration.initAE2();
        if(ExArmConfig.enableThaumcraftWeapons && Loader.isModLoaded("Thaumcraft")) ThaumcraftIntegration.initThaumcraft();
        if(ExArmConfig.enableSteel) GenericIntegration.initSteel();
        if(ExArmConfig.enableBronze)    GenericIntegration.initBronze();
        SimpleOreIntegration.initSimpleMods();

    }
}
