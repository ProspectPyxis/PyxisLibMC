package prospectpyxis.pyxislib.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;

import javax.annotation.Nullable;

@Deprecated
public class CapabilityProviderSerializable<HANDLER> extends CapabilityProviderBasic<HANDLER> implements INBTSerializable<NBTBase> {
    // Same deal as CapabilityProviderBasic

    public CapabilityProviderSerializable(final Capability<HANDLER> capability, @Nullable final EnumFacing facing) {
        this(capability.getDefaultInstance(), capability, facing);
    }

    public CapabilityProviderSerializable(final HANDLER instance, final Capability<HANDLER> capability, @Nullable final EnumFacing facing) {
        super(instance, capability, facing);
    }

    @Override
    public NBTBase serializeNBT() {
        return getCapability().writeNBT(getInstance(), getFacing());
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        getCapability().readNBT(getInstance(), getFacing(), nbt);
    }
}
