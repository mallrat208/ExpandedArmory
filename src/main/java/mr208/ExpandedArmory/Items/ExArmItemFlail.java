package mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemFlail;
import mr208.ExpandedArmory.IWeaponMaterialCheck;
import net.minecraft.item.ItemStack;

public class ExArmItemFlail extends ItemFlail implements IWeaponMaterialCheck {
    private final int materialID;
    private final ToolMaterial toolMat;

    public ExArmItemFlail(String id, ToolMaterial toolmaterial) {
        super(id, toolmaterial);
        this.materialID = toolmaterial.ordinal();
        this.toolMat = toolmaterial;
    }

    @Override
    public int getMaterialID() {
        return materialID;
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToBeRepaired, ItemStack repairMaterial)
        {
            return repairMaterial.isItemEqual(toolMat.getRepairItemStack())?true:super.getIsRepairable(itemToBeRepaired, repairMaterial);
        }
}
