package com.iouter.slowlylife.tileentity;

import appeng.api.AEApi;
import com.iouter.slowlylife.SlowlyLife;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import appeng.tile.crafting.TileCraftingStorageTile;
import appeng.tile.crafting.TileCraftingTile;
import appeng.api.definitions.IBlocks;

import appeng.block.crafting.BlockAdvancedCraftingStorage;

public class SLTileEntityCraftingStorage extends TileCraftingStorageTile{
    private static final int KILO_SCALAR = 1024;

    @Override
    protected ItemStack getItemFromTile(final Object obj) {
        final int storage = ((TileCraftingTile) obj).getStorageBytes() / KILO_SCALAR;

        switch (storage) {
            case 65536:
                return new ItemStack(SlowlyLife.BCS65536k, 1, 0);
        }
        return super.getItemFromTile(obj);
    }

    @Override
    public int getStorageBytes() {
        if (this.worldObj == null || this.notLoaded()) return 0;

        switch (this.blockMetadata) {
            case 0:
                return 65536 * KILO_SCALAR;
            default:
                return 0;
        }
    }

}
