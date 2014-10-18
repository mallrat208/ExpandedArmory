package mr208.ExpandedArmory;


import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mr208.ExpandedArmory.AE2.AE2Integration;
import mr208.ExpandedArmory.Botania.BotaniaIntegration;
import mr208.ExpandedArmory.Items.GenericIntegration;
import mr208.ExpandedArmory.Thaumcraft.ThaumcraftIntegration;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;


@Mod(modid = ExArmRef.MOD_ID, name= ExArmRef.MOD_NAME, version= ExArmRef.MOD_VER, dependencies = "after:Botania;after:appliedenergistics2;after:Thaumcraft;required-after:weaponmod")
public class ExpandedArmory {

    @Mod.Instance
    public static ExpandedArmory instance;

    public static Item.ToolMaterial steelMaterial;
    public static Item.ToolMaterial bronzeMaterial;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    ExArmConfig.init(event.getSuggestedConfigurationFile());

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        Materials.initMaterials();
        if(ExArmConfig.enableBotania && Loader.isModLoaded("Botania")) BotaniaIntegration.initBotania();
        if(ExArmConfig.enableAEWeapons && Loader.isModLoaded("appliedenergistics2")) AE2Integration.initAE2();
        if(ExArmConfig.enableThaumcraftWeapons && Loader.isModLoaded("Thaumcraft")) ThaumcraftIntegration.initThaumcraft();
        if(ExArmConfig.enableSteel && !OreDictionary.getOres("ingotSteel").isEmpty())
        {
            steelMaterial = EnumHelper.addToolMaterial("WV_Steel", 2, 500, 7, 3, 10);
            GenericIntegration.initSteel();
        }
        if (ExArmConfig.enableBronze && !OreDictionary.getOres("ingotBronze").isEmpty())
        {
            bronzeMaterial = EnumHelper.addToolMaterial("WV_Bronze", 2,375,6,2,12);
            GenericIntegration.initBronze();
        }
    }
}
