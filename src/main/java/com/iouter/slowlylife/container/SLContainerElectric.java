package com.iouter.slowlylife.container;

import com.iouter.slowlylife.api.tileentity.SLTileEntityElectricBase;
import ic2.core.block.wiring.ContainerElectricBlock;
import net.minecraft.entity.player.EntityPlayer;

public class SLContainerElectric extends ContainerElectricBlock {
    public SLContainerElectric(EntityPlayer player, SLTileEntityElectricBase tileentity) {
        super(player, tileentity);
    }
}
