package prospectpyxis.pyxislib.utils;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FluidUtils {

    public static boolean handleFluidMatAcceleration(Entity entityIn, Material materialIn) {
        // Code taken from Jabelar's fluid tutorial, with formatting changes
        World world = entityIn.world;
        AxisAlignedBB bb = entityIn.getEntityBoundingBox().grow(0.0d, -0.4d, 0.0d).shrink(0.001d);

        int j2 = MathHelper.floor(bb.minX);
        int k2 = MathHelper.ceil(bb.maxX);
        int l2 = MathHelper.floor(bb.minY);
        int i3 = MathHelper.ceil(bb.maxY);
        int j3 = MathHelper.floor(bb.minZ);
        int k3 = MathHelper.ceil(bb.maxZ);

        boolean flag = false;
        Vec3d vec3d = Vec3d.ZERO;
        BlockPos.PooledMutableBlockPos pmbp = BlockPos.PooledMutableBlockPos.retain();

        for (int l3 = j2; l3 < k2; ++l3) {
            for (int i4 = l2; i4 < i3; ++i4) {
                for (int j4 = j3; j4 < k3; ++j4) {
                    pmbp.setPos(l3, i4, j4);
                    IBlockState state = world.getBlockState(pmbp);
                    Block block = state.getBlock();

                    Boolean result = block.isEntityInsideMaterial(world, pmbp, state, entityIn, i3, materialIn, false);
                    if (result != null && result) {
                        flag = true;
                        vec3d = block.modifyAcceleration(world, pmbp, entityIn, vec3d);
                        continue;
                    } else if (result != null) continue;

                    if (state.getMaterial() == materialIn) {

                        double d0 = i4 + 1 - BlockLiquid.getLiquidHeightPercent(state.getValue(BlockLiquid.LEVEL));

                        if (i3 >= d0) {
                            flag = true;
                            vec3d = block.modifyAcceleration(world, pmbp, entityIn, vec3d);
                        }
                    }
                }
            }
        }

        pmbp.release();

        if (vec3d.lengthVector() > 0.0D && entityIn.isPushedByWater()) {
            vec3d = vec3d.normalize();
            double d1 = 0.014D;
            entityIn.motionX += vec3d.x * d1;
            entityIn.motionY += vec3d.y * d1;
            entityIn.motionZ += vec3d.z * d1;
        }

        entityIn.fallDistance = 0.0F;

        return flag;
    }
}
