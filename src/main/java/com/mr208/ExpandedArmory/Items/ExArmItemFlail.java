package com.mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemFlail;
import com.mr208.ExpandedArmory.IWeaponMaterialCheck;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExArmItemFlail extends ItemFlail implements IWeaponMaterialCheck {
    private final int materialID;
    private final ToolMaterial toolMat;
    private final String repairMaterial;

    public ExArmItemFlail(String id, ToolMaterial toolmaterial, String repairMaterial) {
        super(id, toolmaterial);
        this.materialID = toolmaterial.ordinal();
        this.toolMat = toolmaterial;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaterialID() {
        return materialID;
    }

    @Override
    public boolean getIsRepairable(ItemStack itemToBeRepaired, ItemStack repairMaterial)
    {
        for(int ores:OreDictionary.getOreIDs(repairMaterial))
        {
            if(OreDictionary.getOreName(ores) == this.repairMaterial) return true;
        }
        return super.getIsRepairable(itemToBeRepaired, repairMaterial);
    }
}
