package com.mr208.ExpandedArmory.Thaumcraft.Items;

import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IRepairable;


public class ThaumicItemMelee extends ExArmItemMelee implements IRepairable {

    private final EnumRarity rarity;

    public ThaumicItemMelee(String id, MeleeComponent meleecomponent, EnumRarity eRare, String repairmaterial) {

        super(id, meleecomponent, repairmaterial);
        this.rarity = eRare;
    }

    public EnumRarity func_77613_e(ItemStack par1)
    {
        return rarity;
    }
}
