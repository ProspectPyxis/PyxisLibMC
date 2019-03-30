package prospectpyxis.pyxislib.entity.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class PlayerUtils {

    // Credit to CompatSkills for this code
    public static RayTraceResult getLookingAt(EntityPlayer player) {
        if (player == null) return null;

        Vec3d eyes = new Vec3d(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ);
        float pitch = player.rotationPitch * 0.017453292F;
        float yaw = player.rotationYaw * 0.017453292F - (float)Math.PI;
        double reach = player.getEntityAttribute(EntityPlayer.REACH_DISTANCE).getAttributeValue();
        double pitchReach = -MathHelper.cos(pitch) * reach;

        Vec3d val = eyes.add(new Vec3d((double) MathHelper.sin(yaw) * pitchReach, (double) MathHelper.sin(pitch) * reach, (double) MathHelper.cos(yaw) * pitchReach));
        return player.getEntityWorld().rayTraceBlocks(eyes, val);
    }
}
