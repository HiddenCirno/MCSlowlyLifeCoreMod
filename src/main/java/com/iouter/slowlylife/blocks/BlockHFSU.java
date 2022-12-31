package com.iouter.slowlylife.blocks;

import com.iouter.slowlylife.api.blocks.BlockElectricBase;
import com.iouter.slowlylife.tileentity.TileEntityHFSU;
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
