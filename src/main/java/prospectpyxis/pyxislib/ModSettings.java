package prospectpyxis.pyxislib;

import net.minecraftforge.common.config.Config;

@Config(modid = PyxisLib.modid)
public class ModSettings {

    @Config.Comment({
            "Setting this to false will disable the simple wrench item.",
            "Note that this can potentially hinder mods that use the wrench!",
            "[default: true]"
    })
    public static boolean enableWrench = true;
}
