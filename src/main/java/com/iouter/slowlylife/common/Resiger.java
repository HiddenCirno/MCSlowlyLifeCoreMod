package com.iouter.slowlylife.common;

import appeng.block.AEBaseItemBlock;
import appeng.block.AEBaseItemBlockChargeable;
import appeng.block.AEBaseTileBlock;
import appeng.block.networking.BlockDenseEnergyCell;
import appeng.tile.powersink.AEBasePoweredTile;
import com.iouter.slowlylife.blocks.*;
import com.iouter.slowlylife.blocks.baseblock.*;
import com.iouter.slowlylife.items.SLItemBattery;
import com.iouter.slowlylife.items.SLItemCommon;
import com.iouter.slowlylife.tileentity.SLTileEntityChargepadHFSU;
import com.iouter.slowlylife.tileentity.SLTileEntityCraftingStorage;
import com.iouter.slowlylife.tileentity.SLTileEntityHFSU;
import com.iouter.slowlylife.tileentity.SLTileBackboneEnergyCell;
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
    public static Item advEngProcess;
    public static Item advLogProcess;
    public static Item advCalProcess;
    public static Item advEndProcess;
    public static Item advEngProcessPress;
    public static Item advLogProcessPress;
    public static Item advCalProcessPress;
    public static Item advEndProcessPress;
    public static Item advEngProcessBoard;
    public static Item advLogProcessBoard;
    public static Item advCalProcessBoard;
    public static Item BackboneGoldPlate;
    public static Item PlateHTAlloy;
    public static Block BCS65536k;
    public static Block BackboneEnergyCell;
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
        BackboneEnergyCell = new SLBlockBackboneEnergyCell("BackboneEnergyCell");
        // = new WrappedDamageItemDefinition(bcs65536k, 1);
        advEngProcess = new SLItemCommon("advEngProcess");
        advLogProcess = new SLItemCommon("advLogProcess");
        advCalProcess = new SLItemCommon("advCalProcess");
        advEndProcess = new SLItemCommon("advEndProcess");
        //
        advEngProcessPress = new SLItemCommon("advEngProcessPress");
        advLogProcessPress = new SLItemCommon("advLogProcessPress");
        advCalProcessPress = new SLItemCommon("advCalProcessPress");
        advEndProcessPress = new SLItemCommon("advEndProcessPress");
        //
        advEngProcessBoard = new SLItemCommon("advEngProcessBoard");
        advLogProcessBoard = new SLItemCommon("advLogProcessBoard");
        advCalProcessBoard = new SLItemCommon("advCalProcessBoard");

        BackboneGoldPlate = new SLItemCommon("BackbonePlateGold");
        resiger();
    }

    private void resiger() {
        GameRegistry.registerTileEntity(SLTileEntityHFSU.class, "HFSU");
        GameRegistry.registerTileEntity(SLTileEntityChargepadHFSU.class, "ChargepadHFSU");
        GameRegistry.registerTileEntity(SLTileEntityCraftingStorage.class, "BCS65536k");
        GameRegistry.registerTileEntity(SLTileBackboneEnergyCell.class, "BackboneEnergyCell");
        GameRegistry.registerBlock(HFSU, SLItemBlockElectric.class, "HFSU");
        GameRegistry.registerItem(dustEmerald, "dustEmerald");
        GameRegistry.registerBlock(ChargepadHFSU, SLItemBlockElectric.class, "ChargepadHFSU");
        GameRegistry.registerBlock(HTMachine, SLItemBlockCommon.class, "HTMachine");
        GameRegistry.registerItem(t3crystal, "T3Crystal");
        GameRegistry.registerItem(T3Circuit, "T3Circuit");
        GameRegistry.registerItem(HTAlloy, "HTAlloy");
        GameRegistry.registerItem(advEngProcess, "advEngProcess");
        GameRegistry.registerItem(advLogProcess, "advLogProcess");
        GameRegistry.registerItem(advCalProcess, "advCalProcess");
        GameRegistry.registerItem(advEndProcess, "advEndProcess");
        GameRegistry.registerItem(advEngProcessPress, "advEngProcessPress");
        GameRegistry.registerItem(advLogProcessPress, "advLogProcessPress");
        GameRegistry.registerItem(advCalProcessPress, "advCalProcessPress");
        GameRegistry.registerItem(advEndProcessPress, "advEndProcessPress");
        GameRegistry.registerItem(advEngProcessBoard, "advEngProcessBoard");
        GameRegistry.registerItem(advLogProcessBoard, "advLogProcessBoard");
        GameRegistry.registerItem(advCalProcessBoard, "advCalProcessBoard");
        GameRegistry.registerItem(BackboneGoldPlate, "BackbonePlateGold");
        GameRegistry.registerItem(PlateHTAlloy, "PlateHTAlloy");
        GameRegistry.registerBlock(BCS65536k, SLItemBlockCraftingStorage.class, "CraftingStorage65536k");
        GameRegistry.registerBlock(BackboneEnergyCell, SLBaseItemBlockChargeable.class, "BackboneEnergyCell");
    }
}
