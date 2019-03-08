package prospectpyxis.pyxislib.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBasic extends Block {

    protected String name;

    public BlockBasic(Material mat, String name) {
        super(mat);

        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}
