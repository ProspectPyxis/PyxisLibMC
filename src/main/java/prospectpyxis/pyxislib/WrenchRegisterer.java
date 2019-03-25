package prospectpyxis.pyxislib;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.pyxislib.item.wrench.ItemWrench;

public class WrenchRegisterer {

    public static Item wrench = new ItemWrench();

    public static void register(IForgeRegistry<Item> registry) {
        if (ModConfig.enableWrench) {
            registry.register(wrench);
        }
    }

    public static void registerModels() {
        if (ModConfig.enableWrench) {
            PyxisLib.proxy.registerItemRenderer(wrench, 0, wrench.getRegistryName());
        }
    }
}
