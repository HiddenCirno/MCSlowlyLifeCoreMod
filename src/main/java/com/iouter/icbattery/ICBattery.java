package com.iouter.icbattery;

import com.iouter.icbattery.blocks.BlockHFSU;
import com.iouter.icbattery.blocks.ItemBlockElectric;
import com.iouter.icbattery.common.CreativeTabICBattery;
import com.iouter.icbattery.gui.GuiHander;
import com.iouter.icbattery.items.ItemBattery;
import com.iouter.icbattery.tileentity.TileEntityHFSU;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.recipe.Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = "[1.7.10]", dependencies = "required-after:IC2")
public class ICBattery {

    @Mod.Instance(Tags.MODID)
    public static ICBattery instance;

    public static final CreativeTabICBattery creativeTabICBattery = new CreativeTabICBattery("ICbattery");
    public static final Item t3crystal = new ItemBattery("T3Crystal", 3, 100000000, 8192, 5);
    public static final Block HFSU = new BlockHFSU();

    private static Logger LOG = LogManager.getLogger(Tags.MODID);

    @SidedProxy(clientSide = Tags.GROUPNAME + ".ClientProxy", serverSide = Tags.GROUPNAME + ".CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        register();
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(ICBattery.instance, new GuiHander());
        registerRecipe();
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverAboutToStart(FMLServerAboutToStartEvent event) {
        proxy.serverAboutToStart(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event) {
        proxy.serverStarted(event);
    }

    @Mod.EventHandler
    public void serverStopping(FMLServerStoppingEvent event) {
        proxy.serverStopping(event);
    }

    @Mod.EventHandler
    public void serverStopped(FMLServerStoppedEvent event) {
        proxy.serverStopped(event);
    }

    public static void debug(String message) {
        LOG.debug(message);
    }

    public static void info(String message) {
        LOG.info(message);
    }

    public static void warn(String message) {
        LOG.warn(message);
    }

    public static void error(String message) {
        LOG.error(message);
    }

    private void register() {
        GameRegistry.registerTileEntity(TileEntityHFSU.class, "ICbatteryTEStorageUnit");
        GameRegistry.registerBlock(HFSU, ItemBlockElectric.class, "HFSU");
        GameRegistry.registerItem(t3crystal, "T3Crystal", Tags.MODID);
    }

    private void registerRecipe() {

    }
}
