package com.iouter.slowlylife.tileentity;

import com.iouter.slowlylife.blocks.SLBlockCraftingStorage;
import com.iouter.slowlylife.common.Resiger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import appeng.tile.crafting.TileCraftingStorageTile;
import appeng.tile.crafting.TileCraftingTile;
import net.minecraft.util.StatCollector;

import java.util.List;

public class SLTileEntityCraftingStorage extends TileCraftingStorageTile{
    private static final int KILO_SCALAR = 1024;

    @Override
    protected ItemStack getItemFromTile(final Object obj) {
        final int storage = ((SLTileEntityCraftingStorage) obj).getStorageBytes();
        //final int storage = SLBlockCraftingStorage.getStorage();
        //final int storage = 65536;
        switch (storage) {
            case 65536 * KILO_SCALAR:
                return new ItemStack(Resiger.BCS65536k, 1, 0);
            case 262144 * KILO_SCALAR:
                return new ItemStack(Resiger.BCS65536k, 1, 1);
            case 1048576 * KILO_SCALAR:
                return new ItemStack(Resiger.BCS65536k, 1, 2);
            case 2147483647:
                return new ItemStack(Resiger.BCS65536k, 1, 3);
        }
        return super.getItemFromTile(obj);
    }


    @Override
    public int getStorageBytes() {
        if (this.worldObj == null || this.notLoaded()) return 0;

        switch (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) & 3) {
            case 0:
                return 65536 * KILO_SCALAR;
            case 1:
                return 262144 * KILO_SCALAR;
            case 2:
                return 1048576 * KILO_SCALAR;
            case 3:
                return 2147483647;
            default:
                return 0;
        }
    }

}
