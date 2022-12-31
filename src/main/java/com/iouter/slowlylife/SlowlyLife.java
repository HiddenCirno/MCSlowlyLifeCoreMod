package com.iouter.slowlylife;

import com.iouter.slowlylife.blocks.SLBlockHFSU;
import com.iouter.slowlylife.blocks.SLBlockCommon;
import com.iouter.slowlylife.blocks.SLItemBlockElectric;
import com.iouter.slowlylife.blocks.SLItemBlockCommon;
import com.iouter.slowlylife.common.CreativeTabSlowlyLife;
import com.iouter.slowlylife.gui.SLGuiHander;
import com.iouter.slowlylife.items.SLItemBattery;
import com.iouter.slowlylife.items.SLItemCommon;
import com.iouter.slowlylife.tileentity.SLTileEntityHFSU;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Tags.MODID,
        version = Tags.VERSION,
        name = Tags.MODNAME,
        acceptedMinecraftVersions = "[1.7.10]",
        dependencies = "required-after:IC2")
public class SlowlyLife {

    @Mod.Instance(Tags.MODID)
    public static SlowlyLife instance;

    public static final CreativeTabSlowlyLife creativeTabSlowlyLife = new CreativeTabSlowlyLife("Slowlylife");
    public static final Item t3crystal = new SLItemBattery("T3Crystal", 3, 100000000, 8192, 5);
    public static final Block HFSU = new SLBlockHFSU();
    public static final Block Name = new SLBlockCommon("Name", Material.rock).setHardness(0.0F).setLightLevel(1.0F);
    public static final Item dustEmerald = new SLItemCommon("dustEmerald");

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
        NetworkRegistry.INSTANCE.registerGuiHandler(SlowlyLife.instance, new SLGuiHander());
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
        GameRegistry.registerTileEntity(SLTileEntityHFSU.class, "HFSU");
        GameRegistry.registerBlock(HFSU, SLItemBlockElectric.class, "HFSU");
        GameRegistry.registerItem(dustEmerald, "dustEmerald");
        GameRegistry.registerBlock(Name, SLItemBlockCommon.class, "Name");
        GameRegistry.registerItem(t3crystal, "T3Crystal");
    }

    private void registerRecipe() {}
}
