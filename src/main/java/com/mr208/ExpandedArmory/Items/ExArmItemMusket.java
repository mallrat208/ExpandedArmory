package com.mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemMusket;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.IWeaponMaterialCheck;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExArmItemMusket extends ItemMusket implements IWeaponMaterialCheck {
    private final int materialID;
    private final ToolMaterial toolMaterial;
    private final String repairMaterial;

    public ExArmItemMusket(String id, MeleeComponent meleecomponent, Item bayonetitem, String repairmaterial) {
        super(id, meleecomponent, bayonetitem);
        this.toolMaterial = meleecomponent.weaponMaterial;
        this.materialID = meleecomponent.weaponMaterial.ordinal();
        this.repairMaterial = repairmaterial;
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
