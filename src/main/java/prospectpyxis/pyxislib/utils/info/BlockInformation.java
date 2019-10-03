package prospectpyxis.pyxislib.utils.info;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.pyxislib.PyxisLib;
import prospectpyxis.pyxislib.block.BlockWithTileEntity;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public class BlockInformation {

    public Block block;
    public String name;
    public ItemInformation itemBlockInfo;
    public boolean hasTileEntity;
    public boolean isEnabled = true;

    public BlockInformation(Block block, String name, String model_name, int model_meta, Item itemBlock) {
        this.block = block;
        this.name = name;
        this.itemBlockInfo = new ItemInformation(itemBlock, name, model_name, model_meta);

        if (this.block instanceof BlockWithTileEntity) this.hasTileEntity = true;
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

    public BlockInformation setItemBlock(Item ib) {
        this.itemBlockInfo = new ItemInformation(ib);
        return this;
    }

    public BlockInformation setItemBlockByClass(Class<? extends ItemBlock> ibc) {
        // Incredibly janky? Likely
        // Is there a better way? Likely not (but feel free to prove me wrong)
        Constructor<? extends ItemBlock> ctor;
        try {
            ctor = ibc.getConstructor(Block.class);
        } catch(Exception e) {
            PyxisLib.logger.error("Error in method setItemBlockByClass in getConstructor: " + e.getMessage());
            return this;
        }
        Item ib;
        try {
            ib = ctor.newInstance(this.block);
        } catch(Exception e) {
            PyxisLib.logger.error("Error in method setItemBlockByClass in setInstance: " + e.getMessage());
            return this;
        }
        this.itemBlockInfo = new ItemInformation(ib.setRegistryName(this.name));
        return this;
    }

    public BlockInformation setEnabled(boolean configOption) {
        // configOption should point to a, well, config option that would disable this block
        this.isEnabled = configOption;
        this.itemBlockInfo.setEnabled(configOption);
        return this;
    }

    public BlockInformation setItemBlockModel(HashMap<String,Integer> modelData) {
        this.itemBlockInfo.setModelData(modelData);
        return this;
    }

    public BlockInformation addItemBlockModel(String name, int meta) {
        this.itemBlockInfo.addModelData(name, meta);
        return this;
    }

    public Class getTileEntity() {
        if (!hasTileEntity) return null;
        else return ((BlockWithTileEntity)block).getTileEntityClass();
    }

    @SuppressWarnings("deprecation")
    public void registerTileEntity() {
        if (!hasTileEntity || !isEnabled) return;
        GameRegistry.registerTileEntity(this.getTileEntity(), this.name);
    }

    public void registerBlock(IForgeRegistry<Block> registry) {
        if (isEnabled) registry.register(this.block);
    }
}
