package prospectpyxis.pyxislib.utils.info;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockInformation {

    public Block block;
    public String name;
    public ItemInformation itemBlockInfo;
    public boolean isEnabled = true;

    public BlockInformation(Block block, String name, String model_name, int model_meta, Item itemBlock) {
        this.block = block;
        this.name = name;
        this.itemBlockInfo = new ItemInformation(itemBlock, name, model_name, model_meta);
    }

    public BlockInformation(Block block, String name, String model_name, int model_meta) {
        this(block, name, model_name, model_meta, new ItemBlock(block).setRegistryName(block.getRegistryName().getResourcePath()));
    }

    public BlockInformation(Block block, String name) {
        this(block, name, name, 0, new ItemBlock(block).setRegistryName(block.getRegistryName().getResourcePath()));
    }

    public BlockInformation(Block block) {
        this(block, block.getRegistryName().getResourcePath(), block.getRegistryName().getResourcePath(), 0, new ItemBlock(block).setRegistryName(block.getRegistryName().getResourcePath()));
    }

    public BlockInformation setEnabled(boolean configOption) {
        // configOption should point to a, well, config option that would disable this block
        this.isEnabled = configOption;
        this.itemBlockInfo.setEnabled(configOption);
        return this;
    }

    public void registerBlock(IForgeRegistry<Block> registry) {
        if (isEnabled) registry.register(this.block);
    }
}
