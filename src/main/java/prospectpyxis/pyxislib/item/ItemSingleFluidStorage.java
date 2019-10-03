package prospectpyxis.pyxislib.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidHandlerItemStackSimple;

import javax.annotation.Nullable;

public class ItemSingleFluidStorage extends Item {

    public Item container;
    public Fluid canStore;

    public ItemSingleFluidStorage(Item container, Fluid canStore) {
        setMaxStackSize(1);
        this.container = container;
        this.canStore = canStore;
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return new Handler(stack, this);
    }

    private static class Handler extends FluidHandlerItemStackSimple.SwapEmpty {

        private Fluid canStore;

        private Handler(ItemStack stack, ItemSingleFluidStorage baseItem) {
            super(stack, new ItemStack(baseItem.container), Fluid.BUCKET_VOLUME);
            canStore = baseItem.canStore;
            setFluid(new FluidStack(canStore, Fluid.BUCKET_VOLUME));
        }

        @Override
        public boolean canFillFluidType(FluidStack fluid) {
            return false;
        }

        @Override
        public boolean canDrainFluidType(FluidStack fluid) {
            return fluid.getFluid() == canStore;
        }
    }
}
