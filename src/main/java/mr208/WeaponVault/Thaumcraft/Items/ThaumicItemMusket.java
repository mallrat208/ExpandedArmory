package mr208.WeaponVault.Thaumcraft.Items;

import ckathode.weaponmod.item.MeleeComponent;
import mr208.WeaponVault.Items.WVItemMusket;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IRepairable;

public class ThaumicItemMusket extends WVItemMusket implements IRepairable
{
    private final EnumRarity rarity;

    public ThaumicItemMusket(String id, MeleeComponent meleecomponent, Item bayonetitem, EnumRarity eRare) {
        super(id, meleecomponent, bayonetitem);
        this.rarity = eRare;
    }

    public EnumRarity func_77613_e(ItemStack par1)
    {
        return rarity;
    }

}
