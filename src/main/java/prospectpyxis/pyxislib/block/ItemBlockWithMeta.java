package prospectpyxis.pyxislib.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockWithMeta extends ItemBlock {

    public ItemBlockWithMeta(Block b) {
        super(b);
        setHasSubtypes(true);
        setUnlocalizedName(b.getUnlocalizedName());
        setRegistryName(b.getRegistryName().toString());

        setHasSubtypes(true);
    }
}
