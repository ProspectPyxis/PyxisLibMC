package prospectpyxis.pyxislib.utils.info;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import prospectpyxis.pyxislib.proxy.IBaseProxy;

import java.util.*;

public class ItemInformation {

    public Item item;
    public String name;
    public boolean isEnabled = true;
    private HashMap<String,Integer> model_data = new HashMap<>();
    private List<String> oredicts = new ArrayList<>();

    public ItemInformation(Item item, String name, HashMap<String,Integer> model_data) {
        this.item = item;
        this.name = name;
        this.model_data = model_data;
    }

    public ItemInformation(Item item, String name, String model_name, int model_meta) {
        this.item = item;
        this.name = name;
        this.model_data.put(model_name, model_meta);
    }

    public ItemInformation(Item item, String name) {
        this(item, name, name, 0);
    }

    public ItemInformation(Item item) {
        this(item, item.getRegistryName().getResourcePath(), item.getRegistryName().getResourcePath(), 0);
    }

    public ItemInformation setEnabled(boolean configOption) {
        // configOption should point to a, well, config option that would disable this item
        this.isEnabled = configOption;
        return this;
    }

    public ItemInformation setModelData(HashMap<String, Integer> model_data) {
        this.model_data = model_data;
        return this;
    }

    public ItemInformation addModelData(String name, int meta) {
        this.model_data.put(name, meta);
        return this;
    }

    public ItemInformation addOreDictEntries(String... entries) {
        this.oredicts.addAll(Arrays.asList(entries));
        return this;
    }

    public HashMap<String, Integer> getModelData() {
        return model_data;
    }

    public void registerItem(IForgeRegistry<Item> registry) {
        if (isEnabled) registry.register(this.item);
    }

    public void registerItemModel(IBaseProxy proxy) {
        if (!isEnabled) return;
        for (Map.Entry<String,Integer> entry : this.model_data.entrySet()) {
            proxy.registerItemRenderer(this.item, entry.getValue(), entry.getKey());
        }
    }

    public void registerOreDictEntries() {
        for (String o : oredicts) {
            OreDictionary.registerOre(o, this.item);
        }
    }

}
