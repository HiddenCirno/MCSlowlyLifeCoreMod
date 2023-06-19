package com.iouter.slowlylife.common;

import com.iouter.slowlylife.blocks.*;
import com.iouter.slowlylife.items.SLItemBattery;
import com.iouter.slowlylife.items.SLItemCommon;
import com.iouter.slowlylife.tileentity.SLTileEntityChargepadHFSU;
import com.iouter.slowlylife.tileentity.SLTileEntityCraftingStorage;
import com.iouter.slowlylife.tileentity.SLTileEntityHFSU;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import appeng.block.crafting.ItemCraftingStorage;
import net.minecraft.item.Item;

public class Resiger implements Runnable{
    public static CreativeTabSlowlyLife creativeTabSlowlyLife;
    public static Item t3crystal;
    public static Block HFSU;
    public static Block ChargepadHFSU;
    public static Block HTMachine;
    public static Item dustEmerald;
    public static Item T3Circuit;
    public static Item HTAlloy;
    public static Item PlateHTAlloy;
    public static Block BCS65536k;
    //public static ITileDefinition bcs65536k;
    @Override
    public void run() {
        creativeTabSlowlyLife = new CreativeTabSlowlyLife();
        t3crystal = new SLItemBattery("T3Crystal", 3, 100000000, 8192, 5);
        HFSU = new SLBlockHFSU();
        ChargepadHFSU = new SLBlockChargepadHFSU();
        HTMachine = new SLBlockCommon("HTMachine", Material.rock).setHardness(0.0f).setLightLevel(1.0f);
        dustEmerald = new SLItemCommon("dustEmerald");
        T3Circuit = new SLItemCommon("T3Circuit");
        HTAlloy = new SLItemCommon("HTAlloy");
        PlateHTAlloy = new SLItemCommon("PlateHTAlloy");
        BCS65536k = new SLBlockCraftingStorage("CraftingStorage65536k");
        // = new WrappedDamageItemDefinition(bcs65536k, 1);
        resiger();
    }

    private void resiger() {
        GameRegistry.registerTileEntity(SLTileEntityHFSU.class, "HFSU");
        GameRegistry.registerTileEntity(SLTileEntityChargepadHFSU.class, "ChargepadHFSU");
        GameRegistry.registerTileEntity(SLTileEntityCraftingStorage.class, "BCS65536k");
        GameRegistry.registerBlock(HFSU, SLItemBlockElectric.class, "HFSU");
        GameRegistry.registerItem(dustEmerald, "dustEmerald");
        GameRegistry.registerBlock(ChargepadHFSU, SLItemBlockElectric.class, "ChargepadHFSU");
        GameRegistry.registerBlock(HTMachine, SLItemBlockCommon.class, "HTMachine");
        GameRegistry.registerItem(t3crystal, "T3Crystal");
        GameRegistry.registerItem(T3Circuit, "T3Circuit");
        GameRegistry.registerItem(HTAlloy, "HTAlloy");
        GameRegistry.registerItem(PlateHTAlloy, "PlateHTAlloy");
        GameRegistry.registerBlock(BCS65536k, SLItemBlockCraftingStorage.class, "CraftingStorage65536k");
    }
}
