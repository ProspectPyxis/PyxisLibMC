package prospectpyxis.pyxislib.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import prospectpyxis.pyxislib.PyxisLib;

import javax.annotation.Nullable;

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

    public static boolean compareItems(Item i1, Item against) {
        if (against == null) return false;
        else return (i1 == against);
    }

    public static boolean matchItemStacks(ItemStack i1, ItemStack i2, boolean ignoreMeta) {
        return (
                i1 != null && i2 != null &&
                i1.getItem() == i2.getItem() &&
                (i1.getItemDamage() == i2.getItemDamage() || ignoreMeta)
        );
    }

    @Nullable
    public static ItemStack parseItemStackFromString(String item) {
        int meta = 0;
        String[] split = item.split(":");
        if (split.length < 2 || split.length > 3) {
            PyxisLib.logger.error("Parsing string " + item + " to ItemStack failed: incorrect amount of colons. Returning null.");
            return null;
        }
        else if (split.length == 3) {
            meta = Integer.parseInt(split[2]);
            item = split[0] + ":" + split[1];
        }
        Item itemBase = Item.getByNameOrId(item);
        if (itemBase == null) return null;
        else return new ItemStack(itemBase, 1, meta);
    }

    public static boolean itemStackStringHasMeta(String iss) {
        return iss.split(":").length == 3;
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
