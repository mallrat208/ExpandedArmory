package mr208.WeaponVault.Thaumcraft.Items;

import ckathode.weaponmod.item.MeleeComponent;
import mr208.WeaponVault.Items.WVItemMelee;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IWarpingGear;

public class VoidItemMelee extends WVItemMelee implements IRepairable, IWarpingGear {
    private final EnumRarity rarity;
    public VoidItemMelee(String id, MeleeComponent meleecomponent,EnumRarity eRare) {
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

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        if ((!player.capabilities.disableDamage) && ((entity instanceof EntityLivingBase)) && ((!(entity instanceof EntityPlayer)) || (MinecraftServer.getServer().isPVPEnabled()))) {
            (
                    (EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.weakness.getId(), 80));
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}
