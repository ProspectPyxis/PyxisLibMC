package prospectpyxis.pyxislib.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import prospectpyxis.pyxislib.PyxisLib;
import prospectpyxis.pyxislib.block.IWrenchable;

public class ItemWrench extends Item {

    public ItemWrench() {
        setUnlocalizedName("simple_wrench");
        setRegistryName("simple_wrench");
        setCreativeTab(PyxisLib.ctab);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Block blk = worldIn.getBlockState(pos).getBlock();
        if (blk instanceof IWrenchable) {
            try {
                ((IWrenchable) blk).applyWrench(facing, player.isSneaking());
                return EnumActionResult.SUCCESS;
            } catch(Exception e) {
                PyxisLib.logger.error(e);
                return EnumActionResult.FAIL;
            }
        }
        else return EnumActionResult.PASS;
    }
}
