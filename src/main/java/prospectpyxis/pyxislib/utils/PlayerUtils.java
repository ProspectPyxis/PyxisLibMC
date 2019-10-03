package prospectpyxis.pyxislib.utils;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class PlayerUtils {

    public static void attemptGiveItem(EntityPlayer player, ItemStack stack) {
        boolean flag = player.addItemStackToInventory(stack);

        if (!flag) {
            EntityItem ei = player.dropItem(stack, false);

            if (ei != null) {
                ei.setNoPickupDelay();
                ei.setOwner(player.getName());
            }
        }
    }

}
