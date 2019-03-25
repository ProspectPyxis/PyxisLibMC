package prospectpyxis.pyxislib.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemUtils {

    // This allows for registry of basic items that have no functionality
    public static Item newSimpleItem(String name) {
        return newSimpleItem(name, CreativeTabs.MISC);
    }

    public static Item newSimpleItem(String name, CreativeTabs tab) {
        return new Item().setCreativeTab(tab).setUnlocalizedName(name).setRegistryName(name);
    }
}
