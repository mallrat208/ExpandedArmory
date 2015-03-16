package com.mr208.ExpandedArmory.Items;

import ckathode.weaponmod.item.ItemMelee;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.IWeaponMaterialCheck;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExArmItemMelee extends ItemMelee implements IWeaponMaterialCheck {
    private final int materialID;
    private final ToolMaterial toolMaterial;
    private final String repairMaterial;

    public ExArmItemMelee(String id, MeleeComponent meleecomponent, String repairmaterial) {
        super(id, meleecomponent);
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