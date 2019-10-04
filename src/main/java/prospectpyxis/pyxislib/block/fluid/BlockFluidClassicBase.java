package prospectpyxis.pyxislib.block.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidClassicBase extends BlockFluidClassic {

    // Base class is necessary to handle entity pushing

    protected boolean pushesEntity = false;

    public BlockFluidClassicBase(Fluid fluid, Material material) {
        super(fluid, material);
    }

    public boolean getPushesEntity() {
        return pushesEntity;
    }

    public void setPushesEntity(boolean parPushesEntity) {
        pushesEntity = parPushesEntity;
    }

    @Override
    public Vec3d modifyAcceleration(World worldIn, BlockPos pos, Entity entityIn, Vec3d motion) {
        if (getPushesEntity()) {
            Vec3d flowAdder = getFlow(worldIn, pos, worldIn.getBlockState(pos));
            return motion.add(flowAdder);
        } else {
            return motion;
        }
    }

    protected Vec3d getFlow(IBlockAccess worldIn, BlockPos pos, IBlockState state) {
        double d0 = 0.0D;
        double d1 = 0.0D;
        double d2 = 0.0D;
        int i = this.getRenderedDepth(state);
        BlockPos.PooledMutableBlockPos pmbp = BlockPos.PooledMutableBlockPos.retain();

        for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
            pmbp.setPos(pos).move(enumfacing);
            int j = this.getRenderedDepth(worldIn.getBlockState(pmbp));

            if (j < 0) {
                if (!worldIn.getBlockState(pmbp).getMaterial().blocksMovement()) {
                    j = this.getRenderedDepth(worldIn.getBlockState(pmbp.down()));

                    if (j >= 0) {
                        int k = j - (i - 8);
                        d0 += enumfacing.getFrontOffsetX() * k;
                        d1 += enumfacing.getFrontOffsetY() * k;
                        d2 += enumfacing.getFrontOffsetZ() * k;
                    }
                }
            } else {
                int l = j - i;
                d0 += enumfacing.getFrontOffsetX() * l;
                d1 += enumfacing.getFrontOffsetY() * l;
                d2 += enumfacing.getFrontOffsetZ() * l;
            }
        }

        Vec3d vec3d = new Vec3d(d0, d1, d2);

        if (state.getValue(LEVEL) >= 8) {
            for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL) {
                pmbp.setPos(pos).move(enumfacing1);

                if (this.causesDownwardCurrent(worldIn, pmbp, enumfacing1) || this.causesDownwardCurrent(worldIn, pmbp.up(), enumfacing1)) {
                    vec3d = vec3d.normalize().addVector(0.0D, -6.0D, 0.0D);
                    break;
                }
            }
        }
        pmbp.release();
        return vec3d.normalize();
    }

    protected int getDepth(IBlockState state) {
        return state.getMaterial() == this.blockMaterial ? state.getValue(LEVEL) : -1;
    }

    protected int getRenderedDepth(IBlockState state) {
        int i = this.getDepth(state);
        return i >= 8 ? 0 : i;
    }

    @Override
    protected boolean causesDownwardCurrent(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        Material material = iblockstate.getMaterial();

        if (material == this.blockMaterial) {
            return false;
        } else if (side == EnumFacing.UP) {
            return true;
        } else if (material == Material.ICE) {
            return false;
        } else {
            boolean flag = isExceptBlockForAttachWithPiston(block) || block instanceof BlockStairs;
            return !flag && iblockstate.getBlockFaceShape(worldIn, pos, side) == BlockFaceShape.SOLID;
        }
    }
}
