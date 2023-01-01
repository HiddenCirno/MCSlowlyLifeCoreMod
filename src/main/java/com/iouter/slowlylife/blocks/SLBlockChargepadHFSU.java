package com.iouter.slowlylife.blocks;

import com.iouter.slowlylife.api.blocks.SLBlockChargepadBase;
import com.iouter.slowlylife.tileentity.SLTileEntityChargepadHFSU;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SLBlockChargepadHFSU extends SLBlockChargepadBase {
    public SLBlockChargepadHFSU() {
        super("ChargepadHFSU", 8192, 400000000);
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new SLTileEntityChargepadHFSU();
    }
}
