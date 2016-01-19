package com.mr208.ExpandedArmory.Items;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemCrowbarResistance extends ExArmItemCrowbar{

    private String repairMaterial;
    private String materialName;

    public ItemCrowbarResistance(Item.ToolMaterial material) {
        super(material, "resistance", "ingotSteel");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("exparmory:crowbar.resistance");
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool)
	{
		list.add(EnumChatFormatting.GOLD + "" + EnumChatFormatting.ITALIC + LanguageRegistry.instance().getStringLocalization("item.crowbar.resistance.desc"));
	}

}
