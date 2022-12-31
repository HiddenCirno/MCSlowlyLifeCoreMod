package com.iouter.icbattery.blocks;

import com.iouter.icbattery.api.blocks.BlockElectricBase;
import com.iouter.icbattery.tileentity.TileEntityHFSU;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHFSU extends BlockElectricBase {

    public BlockHFSU() {
        super("HFSU", 8192, 400000000);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityHFSU();
    }
}
