package mr208.WeaponVault;

import ckathode.weaponmod.entity.projectile.MaterialRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class Materials {

    public static Item.ToolMaterial netherQuartz;
    public static Item.ToolMaterial certusQuartz;


    public static void initMaterials()
    {
        netherQuartz = EnumHelper.addToolMaterial("NETHER_QUARTZ",
                Item.ToolMaterial.IRON.getHarvestLevel(),
                Item.ToolMaterial.IRON.getMaxUses(),
                Item.ToolMaterial.IRON.getEfficiencyOnProperMaterial(),
                Item.ToolMaterial.IRON.getDamageVsEntity(),
                Item.ToolMaterial.IRON.getEnchantability());

        certusQuartz = EnumHelper.addToolMaterial("CERTUS_QUARTZ",
                Item.ToolMaterial.IRON.getHarvestLevel(),
                Item.ToolMaterial.IRON.getMaxUses(),
                Item.ToolMaterial.IRON.getEfficiencyOnProperMaterial(),
                Item.ToolMaterial.IRON.getDamageVsEntity(),
                Item.ToolMaterial.IRON.getEnchantability());

        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(certusQuartz, 0xADC6EEFF));
        MaterialRegistry.registerCustomProjectileMaterial(new CustomMaterials(netherQuartz, 0xBFB8AEFF));
    }
}
