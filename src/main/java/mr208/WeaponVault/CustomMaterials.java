package mr208.WeaponVault;

import ckathode.weaponmod.entity.projectile.ICustomProjectileMaterials;
import mr208.WeaponVault.Thaumcraft.Items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;

public class CustomMaterials implements ICustomProjectileMaterials {

    public final Item.ToolMaterial customMat;
    private float[] entityColorF;
    public final int entityColorI;

    public CustomMaterials(Item.ToolMaterial material, int color)
    {
        customMat = material;
        entityColorI = color;
        entityColorF = null;
    }



    @Override
    public int[] getAllMaterialIDs() {
        int[] ids = {customMat.ordinal()};
        return ids;
    }

    @Override
    public int getMaterialID(ItemStack itemStack) {


        if(itemStack.getItem() instanceof IWeaponMaterialCheck)
        {
            return ((IWeaponMaterialCheck) itemStack.getItem()).getMaterialID();
        }
        return 0;
    }

    @Override
    public float[] getColorFromMaterialID(int i) {

        if(entityColorF==null)
        {
            entityColorF = new float[4];
            entityColorF[0] = ((entityColorI >> 24) & 0xFF)/255f;
            entityColorF[1] = ((entityColorI >> 16) & 0xFF)/255f;
            entityColorF[2] = ((entityColorI >> 8) & 0xFF)/255f;
            entityColorF[3] = (entityColorI & 0xFF)/255f;
        }
        return entityColorF;
    }
}
