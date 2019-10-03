package prospectpyxis.pyxislib.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Deprecated
public class ItemUtils {
    // Class is deprecated and will be fully removed in the next version!

    // This allows for registry of basic items that have no functionality
    @Deprecated
    public static Item newSimpleItem(String name) {
        return newSimpleItem(name, CreativeTabs.MISC);
    }

    @Deprecated
    public static Item newSimpleItem(String name, CreativeTabs tab) {
        return new Item().setCreativeTab(tab).setUnlocalizedName(name).setRegistryName(name);
    }
}
