package mr208.ExpandedArmory.Thaumcraft.Items;

import mr208.ExpandedArmory.Items.ExArmItemFlail;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IRepairable;


public class ThaumicItemFlail extends ExArmItemFlail implements IRepairable
        {
            private EnumRarity rarity;
            public ThaumicItemFlail(String id, ToolMaterial toolmaterial, EnumRarity eRare)
            {
                super(id, toolmaterial);
                this.rarity = eRare;
            }

            public EnumRarity func_77613_e(ItemStack par1)
            {
                return rarity;
            }
        }