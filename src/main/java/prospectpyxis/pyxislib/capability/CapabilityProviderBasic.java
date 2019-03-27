package prospectpyxis.pyxislib.capability;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CapabilityProviderBasic<HANDLER> implements ICapabilityProvider {

    protected Capability<HANDLER> capability;
    protected HANDLER instance;
    protected EnumFacing facing;

    public CapabilityProviderBasic(final HANDLER instance, final Capability<HANDLER> capability, @Nullable final EnumFacing facing) {
        this.instance = instance;
        this.capability = capability;
        this.facing = facing;
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability.equals(getCapability());
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability.equals(getCapability())) {
            return getCapability().cast(getInstance());
        }
        return null;
    }

    public final Capability<HANDLER> getCapability() {
        return capability;
    }

    public final HANDLER getInstance() {
        return instance;
    }

    @Nullable
    public final EnumFacing getFacing() {
        return facing;
    }
}
