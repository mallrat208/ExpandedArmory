package com.mr208.ExpandedArmory.Items;

import mods.railcraft.common.items.ItemCrowbar;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ExArmItemCrowbar extends ItemCrowbar{

    private String repairMaterial;
    private String materialName;

    public ExArmItemCrowbar(Item.ToolMaterial tmMaterial,String name,String sMaterial)
    {
        super(tmMaterial);
        this.materialName = name;
        this.setUnlocalizedName("crowbar."+ name);
        this.repairMaterial = sMaterial;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("exparmory:"+materialName+"/crowbar."+materialName);
    }


    @Override
    public boolean getIsRepairable(ItemStack itemToBeRepaired, ItemStack repairMaterial)
    {
        for(int ores: OreDictionary.getOreIDs(repairMaterial))
        {
            if(OreDictionary.getOreName(ores) == this.repairMaterial) return true;
        }
        return super.getIsRepairable(itemToBeRepaired, repairMaterial);
    }


}
