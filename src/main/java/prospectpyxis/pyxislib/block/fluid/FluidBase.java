package prospectpyxis.pyxislib.block.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class FluidBase extends Fluid {

    protected int mapColor;
    protected float overlayAlpha;
    protected SoundEvent emptySound = SoundEvents.ITEM_BUCKET_EMPTY;
    protected SoundEvent fillSound = SoundEvents.ITEM_BUCKET_FILL;
    protected Material mat = Material.WATER;

    public FluidBase(String name, ResourceLocation still, ResourceLocation flowing, int color, float alpha) {
        super(name, still, flowing);
        setColor(color);
        setAlpha(alpha);
    }

    public FluidBase(String name, ResourceLocation still, ResourceLocation flowing, int color) {
        this(name, still, flowing, color, 0.2f);
    }

    public FluidBase(String name, ResourceLocation still, ResourceLocation flowing) {
        this(name, still, flowing, 0xFFFFFFFF, 0.2f);
    }

    @Override
    public FluidBase setColor(int color) {
        this.mapColor = color;
        return this;
    }

    @Override
    public int getColor() {
        return mapColor;
    }

    public FluidBase setAlpha(float alpha) {
        this.overlayAlpha = alpha;
        return this;
    }

    public float getAlpha() {
        return overlayAlpha;
    }

    @Override
    public FluidBase setEmptySound(SoundEvent emptySound) {
        this.emptySound = emptySound;
        return this;
    }

    @Override
    public SoundEvent getEmptySound() {
        return emptySound;
    }

    @Override
    public FluidBase setFillSound(SoundEvent fillSound) {
        this.fillSound = fillSound;
        return this;
    }

    @Override
    public SoundEvent getFillSound() {
        return fillSound;
    }

    public FluidBase setMaterial(Material mat) {
        this.mat = mat;
        return this;
    }

    public Material getMaterial() {
        return mat;
    }

    @Override
    public boolean doesVaporize(FluidStack fluidStack) {
        if (block == null) return false;
        return block.getDefaultState().getMaterial() == getMaterial();
    }

}
