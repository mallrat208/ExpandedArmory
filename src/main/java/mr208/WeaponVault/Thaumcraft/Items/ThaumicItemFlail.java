package mr208.WeaponVault.Thaumcraft.Items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import mr208.WeaponVault.Items.WVItemFlail;
import thaumcraft.api.IRepairable;


public class ThaumicItemFlail extends WVItemFlail implements IRepairable
        {
            private EnumRarity rarity;
            public ThaumicItemFlail(String id, ToolMaterial toolmaterial, EnumRarity eRare) {super(id, toolmaterial);this.rarity = eRare;}

            public EnumRarity func_77613_e(ItemStack par1)
            {
                return rarity;
            }
        }