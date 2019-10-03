package prospectpyxis.pyxislib.utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockUtils {

    public static class SimpleBlock {
        // This class is dedicated to functions that create a block with no functions
        // In essence, this does everything a BlockBase class would do without actually using janky extensions

        public static Block makeNew(String name, String modid) {
            return makeNew(name, modid, Material.ROCK, null, 1, 1);
        }

        public static Block makeNew(String name, String modid, Material mat) {
            return makeNew(name, modid, mat, null, 1, 1);
        }

        public static Block makeNew(String name, String modid, CreativeTabs tab) {
            return makeNew(name, modid, Material.ROCK, tab, 1, 1);
        }

        public static Block makeNew(String name, String modid, CreativeTabs tab, float hardness, float resistance) {
            return makeNew(name, modid, Material.ROCK, tab, hardness, resistance);
        }

        public static Block makeNew(String name, String modid, Material mat, float hardness, float resistance) {
            return makeNew(name, modid, mat, null, hardness, resistance);
        }

        public static Block makeNew(String name, String modid, Material mat, CreativeTabs tab, float hardness, float resistance) {
            if (tab != null) {
                return new Block(mat).setCreativeTab(tab).setHardness(hardness).setResistance(resistance).setRegistryName(name).setUnlocalizedName(modid + "." + name);
            } else {
                return new Block(mat).setHardness(hardness).setResistance(resistance).setRegistryName(name).setUnlocalizedName(modid + "." + name);
            }
        }
    }
}
