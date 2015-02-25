package com.mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemMusket;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.IWeaponMaterialCheck;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExArmItemMusket extends ItemMusket implements IWeaponMaterialCheck {
    private final int materialID;
    private final ToolMaterial toolMaterial;

    public ExArmItemMusket(String id, MeleeComponent meleecomponent, Item bayonetitem) {
        super(id, meleecomponent, bayonetitem);
        toolMaterial = meleecomponent.weaponMaterial;
        materialID = meleecomponent.weaponMaterial.ordinal();
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
