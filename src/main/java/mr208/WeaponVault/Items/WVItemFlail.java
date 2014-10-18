package mr208.WeaponVault.Items;

import appeng.api.AEApi;
import ckathode.weaponmod.item.ItemFlail;
import mr208.WeaponVault.IWeaponMaterialCheck;
import mr208.WeaponVault.Materials;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import vazkii.botania.api.BotaniaAPI;


public class WVItemFlail extends ItemFlail implements IWeaponMaterialCheck {
    private final int materialID;
    private final ToolMaterial toolMat;
    public WVItemFlail(String id, ToolMaterial toolmaterial) {
        super(id, toolmaterial);
        this.materialID = toolmaterial.ordinal();
        this.toolMat = toolmaterial;
    }

    @Override
    public int getMaterialID() {
        return materialID;
    }

    @Override
    public boolean getIsRepairable(ItemStack weaponStack, ItemStack itemStack)
    {
        return itemStack.isItemEqual(getRepairItem(toolMat)) ? true: super.getIsRepairable(weaponStack, itemStack);
    }

    private ItemStack getRepairItem(ToolMaterial material)
    {
        if(material == ThaumcraftApi.toolMatThaumium) return ItemApi.getItem("itemResource",2);
        if(material == ThaumcraftApi.toolMatVoid) return ItemApi.getItem("itemResource",16);
        if(material == Materials.netherQuartz) return new ItemStack(Items.quartz);
        if(material == Materials.certusQuartz) return AEApi.instance().materials().materialCertusQuartzCrystal.stack(1);
        if(material == BotaniaAPI.manasteelToolMaterial) return OreDictionary.getOres("ingotManasteel").get(0);
        if(material == BotaniaAPI.terrasteelToolMaterial) return OreDictionary.getOres("ingotTerrasteel").get(0);
        if(material == BotaniaAPI.elementiumToolMaterial) return OreDictionary.getOres("ingotElementium").get(0);
        return new ItemStack(material.func_150995_f());
    }
}
