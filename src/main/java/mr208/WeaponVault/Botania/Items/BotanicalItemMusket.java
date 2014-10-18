package mr208.WeaponVault.Botania.Items;

import ckathode.weaponmod.item.MeleeComponent;
import mr208.WeaponVault.Botania.ManaHelper;
import mr208.WeaponVault.Items.WVItemMusket;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;

public class BotanicalItemMusket extends WVItemMusket implements IManaUsingItem {
    private static final int MANA_PER_DMG = 51;
    public BotanicalItemMusket(String id, MeleeComponent meleecomponent, Item bayonetitem) {
        super(id, meleecomponent, bayonetitem);
    }

    @Override
    public boolean hitEntity(ItemStack itemWeapon, EntityLivingBase targetEntity, EntityLivingBase usingEntity)
    {
        if(usesMana(itemWeapon)) ManaHelper.damageItem(itemWeapon, 1, usingEntity, MANA_PER_DMG);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemWeapon, World world, Block block, int x,int y, int z, EntityLivingBase player)
    {
        if(usesMana(itemWeapon) && block.getBlockHardness(world,x,y,z) !=0f) ManaHelper.damageItem(itemWeapon,1,player,MANA_PER_DMG);
        return true;
    }

    @Override
    public boolean usesMana(ItemStack stack) {
        return true;
    }
}
