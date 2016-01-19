package com.mr208.ExpandedArmory.Items;

import java.util.List;

import ckathode.weaponmod.item.ItemMelee;
import ckathode.weaponmod.item.MeleeComponent;
import com.mr208.ExpandedArmory.Botania.ManaHelper;
import com.mr208.ExpandedArmory.IWeaponMaterialCheck;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
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
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



@Optional.InterfaceList(
		value={@Optional.Interface(iface="vazkii.botania.api.mana.IManaUsingItem",modid="botania")})

public class ExArmItemMelee extends ItemMelee implements IWeaponMaterialCheck, IManaUsingItem {
    private int materialID;
    private ToolMaterial toolMaterial;
    private String repairMaterial;
	private EnumRarity itemRarity = EnumRarity.common;
	private int MANA_PER_DMG = 51;

    public ExArmItemMelee(String id, MeleeComponent meleecomponent, String repairmaterial) {
        super(id, meleecomponent);
        this.toolMaterial = meleecomponent.weaponMaterial;
        this.materialID = meleecomponent.weaponMaterial.ordinal();
        this.repairMaterial = repairmaterial;
    }

	public ExArmItemMelee(String id, MeleeComponent meleecomponent, String repairmaterial, EnumRarity rarity)
	{
		super(id, meleecomponent);
		this.toolMaterial = meleecomponent.weaponMaterial;
		this.materialID = meleecomponent.weaponMaterial.ordinal();
		this.repairMaterial = repairmaterial;
		this.itemRarity = rarity;
	}


    @Override
    public int getMaterialID() {
        return materialID;
    }

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
	{
		super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);
		if(this.repairMaterial=="ingotVoid")
			{
				if ((stack.isItemDamaged()) && (entity != null) && (entity.ticksExisted % 20 == 0) && ((entity instanceof EntityLivingBase)))
			{  stack.damageItem(-1, (EntityLivingBase)entity);  }
		}
		if(this.repairMaterial=="ingotManasteel")
		{
		if(!world.isRemote && entity instanceof EntityPlayer && stack.getItemDamage() >0 && ManaItemHandler.requestManaExactForTool(stack, (EntityPlayer) entity, MANA_PER_DMG * 2, true))
			stack.setItemDamage(stack.getItemDamage()-1);}
	}

	@Override
	public boolean hitEntity(ItemStack weapon, EntityLivingBase Victim, EntityLivingBase Attacker)
	{
		if(this.repairMaterial=="ingotVoid"){
			if (!Victim.worldObj.isRemote && (!(Victim instanceof EntityPlayer) || !(Attacker instanceof EntityPlayer) || MinecraftServer.getServer().isPVPEnabled())) {
				try {
					Victim.addPotionEffect(new PotionEffect(Potion.weakness.getId(), 60));
				} catch (Exception e) {
				}
			}
		}
		if(this.repairMaterial=="ingotManasteel") {
			if(usesMana(weapon)) ManaHelper.damageItem(weapon,1,Attacker,MANA_PER_DMG);
		}

		return super.hitEntity(weapon, Victim,Attacker);
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

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack weapon, EntityPlayer player, List list, boolean bool)
	{
		if(this.repairMaterial=="ingotVoid")
		{
			list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("enchantment.special.sapless"));
		}
		super.addInformation(weapon,player,list,bool);
	}

	public EnumRarity func_77613_e(ItemStack par1)
	{
		return itemRarity;
	}

	@Override
	public boolean usesMana(ItemStack itemStack) {
		if(this.repairMaterial=="ingotManasteel") return true;
		return false;
	}
}