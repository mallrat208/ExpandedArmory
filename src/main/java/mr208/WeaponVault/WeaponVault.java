package mr208.WeaponVault;


import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mr208.WeaponVault.AE2.AE2Integration;
import mr208.WeaponVault.Botania.BotaniaIntegration;
import mr208.WeaponVault.Items.GenericMetalsIntegration;
import mr208.WeaponVault.Thaumcraft.ThaumcraftIntegration;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;


@Mod(modid = WVRef.MOD_ID, name= WVRef.MOD_NAME, version=WVRef.MOD_VER, dependencies = "after:Botania;after:appliedenergistics2;after:Thaumcraft;required-after:weaponmod")
public class WeaponVault {

    @Mod.Instance
    public static WeaponVault instance;

    public static Item.ToolMaterial steelMaterial;
    public static Item.ToolMaterial bronzeMaterial;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    WVConfig.init(event.getSuggestedConfigurationFile());

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        Materials.initMaterials();
        if(WVConfig.enableBotania && Loader.isModLoaded("Botania")) BotaniaIntegration.initBotania();
        if(WVConfig.enableAEWeapons && Loader.isModLoaded("appliedenergistics2")) AE2Integration.initAE2();
        if(WVConfig.enableThaumcraftWeapons && Loader.isModLoaded("Thaumcraft")) ThaumcraftIntegration.initThaumcraft();
        if(WVConfig.enableSteel && !OreDictionary.getOres("ingotSteel").isEmpty())
        {
            steelMaterial = EnumHelper.addToolMaterial("WV_Steel", 2, 500, 7, 3, 10);
            GenericMetalsIntegration.initSteel();
        }
        if (WVConfig.enableBronze && !OreDictionary.getOres("ingotBronze").isEmpty())
        {
            bronzeMaterial = EnumHelper.addToolMaterial("WV_Bronze", 2,375,6,2,12);
            GenericMetalsIntegration.initBronze();
        }
    }
}
