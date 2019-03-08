package prospectpyxis.pyxislib.utils;

import net.minecraft.item.Item;

public class ItemUtils {

    public boolean isWrench(Item itm) {
        Item wrench = Item.getByNameOrId("pyxislib:simple_wrench");

        return itm.equals(wrench);
    }
}
