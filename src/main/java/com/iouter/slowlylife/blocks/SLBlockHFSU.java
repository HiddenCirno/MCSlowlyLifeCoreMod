package com.iouter.slowlylife.blocks;

import com.iouter.slowlylife.api.blocks.SLBlockElectricBase;
import com.iouter.slowlylife.tileentity.SLTileEntityHFSU;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SLBlockHFSU extends SLBlockElectricBase {

    public SLBlockHFSU() {
        super("HFSU", 8192, 400000000);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new SLTileEntityHFSU();
    }
}
