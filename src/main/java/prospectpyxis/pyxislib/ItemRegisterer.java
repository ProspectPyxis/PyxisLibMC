package prospectpyxis.pyxislib;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.pyxislib.item.ItemWrench;
import prospectpyxis.pyxislib.utils.info.ItemInformation;

public class ItemRegisterer {

    public static ItemInformation wrench = new ItemInformation(new ItemWrench()).setEnabled(ModSettings.enableWrench);

    public static void register(IForgeRegistry<Item> registry) {
        wrench.registerItem(registry);
    }

    public static void registerModels() {
        wrench.registerItemModel(PyxisLib.proxy);
    }
}
