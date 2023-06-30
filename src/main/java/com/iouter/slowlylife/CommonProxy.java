package com.iouter.slowlylife;

import com.iouter.slowlylife.common.Resiger;
import com.iouter.slowlylife.common.ResigerRecipe;
import com.iouter.slowlylife.gui.SLGuiHander;
import com.iouter.slowlylife.common.Resiger;
import com.iouter.slowlylife.items.SlItemWandCaps;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import thaumcraft.api.wands.WandCap;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CommonProxy {

    public static WandCap TestTrueCaps;
    public static WandCap TestTrueCaps1;
    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event) {
        Config.syncronizeConfiguration(event.getSuggestedConfigurationFile());
        SlowlyLife.info("Time to" + Tags.MODNAME);
        new Resiger().run();
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(SlowlyLife.instance, new SLGuiHander());
        new ResigerRecipe().run();
    }

    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event) {
    }

    public void serverAboutToStart(FMLServerAboutToStartEvent event) {}

    // register server commands in this event handler
    public void serverStarting(FMLServerStartingEvent event) {}

    public void serverStarted(FMLServerStartedEvent event) {}

    public void serverStopping(FMLServerStoppingEvent event) {}

    public void serverStopped(FMLServerStoppedEvent event) {}
}
