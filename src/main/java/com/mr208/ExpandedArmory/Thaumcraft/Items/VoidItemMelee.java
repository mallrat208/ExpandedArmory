package com.mr208.ExpandedArmory.Thaumcraft.Items;

import ckathode.weaponmod.item.MeleeComponent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import com.mr208.ExpandedArmory.Items.ExArmItemMelee;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IWarpingGear;

import java.util.List;

public class VoidItemMelee extends ExArmItemMelee implements IRepairable, IWarpingGear {
    private final EnumRarity rarity;
    public VoidItemMelee(String id, MeleeComponent meleecomponent, EnumRarity eRare) {
        super(id, meleecomponent);
        this.rarity = eRare;
    }

    public EnumRarity func_77613_e(ItemStack par1)
    {
        return rarity;
    }

    @Override
    public int getWarp(ItemStack itemStack, EntityPlayer player) {
        return 1;
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
    {
        super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);
        if ((stack.isItemDamaged()) && (entity != null) && (entity.ticksExisted % 20 == 0) && ((entity instanceof EntityLivingBase)))
        {  stack.damageItem(-1, (EntityLivingBase)entity);  }
    }

    @Override
    public boolean hitEntity(ItemStack weapon, EntityLivingBase Victim, EntityLivingBase Attacker)
    {
        if(!Victim.worldObj.isRemote && (!(Victim instanceof EntityPlayer) || !(Attacker instanceof EntityPlayer) || MinecraftServer.getServer().isPVPEnabled()))
        {
        try {
            Victim.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 60));
        }
        catch (Exception e)
        {        }
        }
        return super.hitEntity(weapon, Victim,Attacker);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack weapon, EntityPlayer player, List list, boolean bool)
    {
        list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("enchantment.special.sapless"));
        super.addInformation(weapon,player,list,bool);
    }
}
