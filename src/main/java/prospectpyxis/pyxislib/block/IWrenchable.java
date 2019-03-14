package prospectpyxis.pyxislib.block;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IWrenchable {

    void applyWrench(World worldIn, BlockPos pos, EnumFacing dir, boolean isPlayerSneaking);
}
