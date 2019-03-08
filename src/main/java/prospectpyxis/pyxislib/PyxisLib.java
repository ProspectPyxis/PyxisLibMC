package prospectpyxis.pyxislib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import prospectpyxis.pyxislib.item.ItemBasic;
import prospectpyxis.pyxislib.item.wrench.WrenchRegisterer;
import prospectpyxis.pyxislib.proxy.CommonProxy;

@Mod(modid = PyxisLib.modid, name = PyxisLib.name, version = PyxisLib.version)
public class PyxisLib {

    public static final String modid = "pyxislib";
    public static final String name = "PyxisLib";
    public static final String version = "1.12.2-0.1";

    public static final Logger logger = LogManager.getLogger(modid);

    @Mod.Instance(modid)
    public static PyxisLib instance;

    @SidedProxy(serverSide = "prospectpyxis.pyxislib.proxy.CommonProxy", clientSide = "prospectpyxis.pyxislib.proxy.ClientProxy")
    public static CommonProxy proxy;

    @GameRegistry.ObjectHolder(modid + ":simple_wrench")
    public static ItemBasic wrench;

    public static CreativeTabs ctab = new CreativeTabs("pyxislib") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(wrench);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Now loading" + name);
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            WrenchRegisterer.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            WrenchRegisterer.registerModels();
        }
    }
}