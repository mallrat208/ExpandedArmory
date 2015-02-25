package mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemMelee;
import ckathode.weaponmod.item.MeleeComponent;
import mr208.ExpandedArmory.IWeaponMaterialCheck;
import net.minecraft.item.ItemStack;
import thaumcraft.common.config.ConfigItems;

public class ExArmItemMelee extends ItemMelee implements IWeaponMaterialCheck {
    private final int materialID;
    private final ToolMaterial toolMaterial;

    public ExArmItemMelee(String id, MeleeComponent meleecomponent) {
        super(id, meleecomponent);
        this.toolMaterial = meleecomponent.weaponMaterial;
        this.materialID = meleecomponent.weaponMaterial.ordinal();
    }

    @Override
    public int getMaterialID() {
        return materialID;
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToBeRepaired, ItemStack repairMaterial)
    {
        return repairMaterial.isItemEqual(toolMaterial.getRepairItemStack())?true:super.getIsRepairable(itemToBeRepaired, repairMaterial);
    }
    }