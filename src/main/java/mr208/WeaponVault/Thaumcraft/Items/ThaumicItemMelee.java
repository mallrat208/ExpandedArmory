package mr208.WeaponVault.Thaumcraft.Items;

import ckathode.weaponmod.item.ItemMelee;
import ckathode.weaponmod.item.MeleeComponent;
import mr208.WeaponVault.IWeaponMaterialCheck;
import mr208.WeaponVault.Items.WVItemMelee;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IRepairable;


public class ThaumicItemMelee extends WVItemMelee implements IRepairable {

    private final EnumRarity rarity;

    public ThaumicItemMelee(String id, MeleeComponent meleecomponent,EnumRarity eRare) {

        super(id, meleecomponent);
        this.rarity = eRare;
    }

    public EnumRarity func_77613_e(ItemStack par1)
    {
        return rarity;
    }
}
