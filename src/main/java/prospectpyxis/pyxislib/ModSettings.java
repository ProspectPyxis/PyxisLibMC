package prospectpyxis.pyxislib;

import net.minecraftforge.common.config.Config;

@Config(modid = PyxisLib.modid)
public class ModSettings {

    @Config.Comment({
            "Setting this to true will enable the bundled wrench item.",
            "Remember to enable this if you have any mod that uses it!",
            "[default: false]"
    })
    public static boolean enableWrench = false;
}
