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
import org.apache.logging.log4j.Logger;
import prospectpyxis.pyxislib.proxy.CommonProxy;

@Mod(modid = PyxisLib.modid, name = PyxisLib.name, version = PyxisLib.version)
public class PyxisLib {

    public static final String modid = "pyxislib";
    public static final String name = "PyxisLib";
    public static final String version = "1.12.2-1.0.0";

    public static Logger logger;

    @Mod.Instance(modid)
    public static PyxisLib instance;

    @SidedProxy(serverSide = "prospectpyxis.pyxislib.proxy.ServerProxy", clientSide = "prospectpyxis.pyxislib.proxy.ClientProxy")
    public static CommonProxy proxy;

    @GameRegistry.ObjectHolder(modid + ":simple_wrench")
    public static Item WRENCH;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Now loading " + name);
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
