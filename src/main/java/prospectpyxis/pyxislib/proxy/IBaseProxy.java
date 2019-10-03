package prospectpyxis.pyxislib.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public interface IBaseProxy {

    public void registerItemRenderer(Item item, int meta, String name);
}
