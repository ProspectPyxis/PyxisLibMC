package prospectpyxis.pyxislib.item.wrench;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.pyxislib.ModConfig;
import prospectpyxis.pyxislib.PyxisLib;
import prospectpyxis.pyxislib.item.ItemBasic;

public class WrenchRegisterer {

    public static ItemBasic wrench = new ItemBasic("simple_wrench").setCreativeTab(PyxisLib.ctab);

    public static void register(IForgeRegistry<Item> registry) {
        if (ModConfig.enableWrench) {
            registry.register(wrench);
        }
    }

    public static void registerModels() {
        if (ModConfig.enableWrench) {
            PyxisLib.proxy.registerItemRenderer(wrench, 0, wrench.getBasicName());
        }
    }
}
