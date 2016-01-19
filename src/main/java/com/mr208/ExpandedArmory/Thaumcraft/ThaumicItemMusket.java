package com.mr208.ExpandedArmory.Thaumcraft;

import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Items.ExArmItemMusket;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IRepairable;

public class ThaumicItemMusket extends ExArmItemMusket implements IRepairable
{
    private final EnumRarity rarity;

    public ThaumicItemMusket(String id, MeleeComponent meleecomponent, Item bayonetitem, EnumRarity eRare, String repairmaterial) {
        super(id, meleecomponent, bayonetitem, repairmaterial);
        this.rarity = eRare;
    }

    public EnumRarity func_77613_e(ItemStack par1)
    {
        return rarity;
    }

}
