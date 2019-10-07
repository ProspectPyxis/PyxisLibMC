package prospectpyxis.pyxislib.utils.info;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.pyxislib.block.fluid.BlockFluidClassicBase;
import prospectpyxis.pyxislib.block.fluid.BlockFluidFiniteBase;
import prospectpyxis.pyxislib.proxy.IBaseProxy;

public class FluidInformation {

    public Fluid fluid;
    public String name;
    public BlockInformation blockFluidInfo;
    public boolean isEnabled = true;
    public boolean isBucketEnabled = true;

    public FluidInformation(Fluid fluid, String name) {
        this.fluid = fluid;
        this.name = name;
    }

    public FluidInformation setEnabled(boolean e) {
        this.isEnabled = e;
        return this;
    }

    public FluidInformation setBucketEnabled(boolean be) {
        this.isBucketEnabled = be;
        return this;
    }

    public void registerFluid() {
        if (isEnabled) {
            FluidRegistry.registerFluid(this.fluid);
            if (isBucketEnabled) FluidRegistry.addBucketForFluid(this.fluid);
        }
    }

    public FluidInformation setupBlockAndItems(String modid, boolean finiteFluid, Material fluidMat) {
        if (!finiteFluid) {
            this.blockFluidInfo = new BlockInformation(new BlockFluidClassicBase(this.fluid, fluidMat).setRegistryName(this.name).setUnlocalizedName(modid + "." + this.name));
            this.blockFluidInfo.setItemBlock(new ItemBlock(this.blockFluidInfo.block).setRegistryName(this.name));
        } else {
            this.blockFluidInfo = new BlockInformation(new BlockFluidFiniteBase(this.fluid, fluidMat).setRegistryName(this.name).setUnlocalizedName(modid + "." + this.name));
            this.blockFluidInfo.setItemBlock(new ItemBlock(this.blockFluidInfo.block).setRegistryName(this.name));
        }
        return this;
    }

    public void registerBlockAndItem(IForgeRegistry<Block> blockRegistry, IForgeRegistry<Item> itemRegistry) {
        if (this.blockFluidInfo == null) return;

        this.blockFluidInfo.registerBlock(blockRegistry);
        this.blockFluidInfo.itemBlockInfo.registerItem(itemRegistry);
    }

    public void registerIBFModel(IBaseProxy proxy) {
        if (this.blockFluidInfo != null) {
            this.blockFluidInfo.itemBlockInfo.registerItemModel(proxy);
        }
    }

}
