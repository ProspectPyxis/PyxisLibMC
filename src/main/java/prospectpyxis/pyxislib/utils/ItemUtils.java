package prospectpyxis.pyxislib.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemUtils {

    public static RayTraceResult raytraceFromEntity(World worldIn, Entity playerIn, boolean useLiquids, double range) {
        // Code taken from Botania, used with permission under the Botania license
        float f = playerIn.rotationPitch;
        float f1 = playerIn.rotationYaw;
        double d0 = playerIn.posX;
        double d1 = playerIn.posY + (double)playerIn.getEyeHeight();
        double d2 = playerIn.posZ;
        Vec3d vec3d = new Vec3d(d0, d1, d2);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d3 = range;
        Vec3d vec3d1 = vec3d.addVector((double)f6 * d3, (double)f5 * d3, (double)f7 * d3);
        return worldIn.rayTraceBlocks(vec3d, vec3d1, useLiquids, !useLiquids, false);
    }

    public static class SimpleItem {
        // This class is dedicated to functions that create an item with no functions
        // In essence, this does everything an ItemBase class would do without actually using janky extensions

        public static Item makeNew(String name, String modid) {
            return makeNew(name, modid, null);
        }

        public static Item makeNew(String name, String modid, CreativeTabs tab) {
            if (tab != null) {
                return new Item().setCreativeTab(tab).setRegistryName(name).setUnlocalizedName(modid + "." + name);
            } else {
                return new Item().setRegistryName(name).setUnlocalizedName(modid + "." + name);
            }
        }
    }
}
