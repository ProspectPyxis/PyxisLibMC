package prospectpyxis.pyxislib.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockUtils {

    // Returns a basic block that has no uses
    public static Block newSimpleBlock(String name) {
        return newSimpleBlock(name, Material.ROCK, CreativeTabs.MISC, 1, 1);
    }

    public static Block newSimpleBlock(String name, Material mat) {
        return newSimpleBlock(name, mat, CreativeTabs.MISC, 1, 1);
    }

    public static Block newSimpleBlock(String name, Material mat, float hardness, float resistance) {
        return newSimpleBlock(name, mat, CreativeTabs.MISC, hardness, resistance);
    }

    public static Block newSimpleBlock(String name, Material mat, CreativeTabs tab, float hardness, float resistance) {
        return new Block(mat).setCreativeTab(tab).setHardness(hardness).setResistance(resistance).setUnlocalizedName(name).setRegistryName(name);
    }
}
