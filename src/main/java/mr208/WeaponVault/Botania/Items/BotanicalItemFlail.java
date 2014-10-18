package mr208.WeaponVault.Botania.Items;

import mr208.WeaponVault.Botania.ManaHelper;
import mr208.WeaponVault.Items.WVItemFlail;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;

/**
 * Created by Andrew on 10/17/2014.
 */
public class BotanicalItemFlail extends WVItemFlail implements IManaUsingItem {
    private static final int MANA_PER_DMG = 51;
    public BotanicalItemFlail(String id, ToolMaterial toolmaterial) {
        super(id, toolmaterial);
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
