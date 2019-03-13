package prospectpyxis.pyxislib.block;

import net.minecraft.util.EnumFacing;

public interface IWrenchable {

    void applyWrench(EnumFacing dir, boolean isPlayerSneaking);
}
